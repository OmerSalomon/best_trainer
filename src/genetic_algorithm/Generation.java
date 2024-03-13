package genetic_algorithm;

import properties.Customer;
import properties.Trainer;

import java.util.ArrayList;
import java.util.Collections;

public class Generation {
    private final ArrayList<Solution> solutions;
    private ArrayList<Trainer> trainers;
    private ArrayList<Customer> customers;
    private final int generationSize;
    private int fitness = -1;

    public Generation(ArrayList<Trainer> trainers, ArrayList<Customer> customers, int generationSize) {
        this.trainers = trainers;
        this.customers = customers;
        this.generationSize = generationSize;
        this.solutions = createRandomGeneration(generationSize);
    }

    private Generation(ArrayList<Trainer> trainers, ArrayList<Customer> customers, int generationSize, ArrayList<Solution> solutions) {
        this.trainers = trainers;
        this.customers = customers;
        this.generationSize = generationSize;
        this.solutions = solutions;
    }




    private ArrayList<Solution> createRandomGeneration(int amount){
        ArrayList<Solution> solutions = new ArrayList<>();

        for (int i = 0; i < amount; i++){
            Solution solution = Solution.createRandomSolution(trainers, customers);
            solutions.add(solution);
        }

        return solutions;
    }

    private void createMutationsForWorstChildren(ArrayList<Solution> solutions, int amount , int mutationPerSolution){
        Collections.sort(solutions);
        int index = solutions.size() - 1;
        for (int i = 0; i < amount; i++) {
            solutions.get(index).makeMutation(mutationPerSolution);
            index--;
        }
    }

    public Generation createNextGeneration(){
        ArrayList<Solution> topHalfSolutions = getTopHalfSolutions();
        ArrayList<Solution> childrenSolutions = new ArrayList<>();

        int i = 0;
        int j = topHalfSolutions.size() - 1;

        while (i < topHalfSolutions.size()){
            Solution parent_1 = topHalfSolutions.get(i);
            Solution parent_2 = topHalfSolutions.get(j);
            childrenSolutions.add(parent_1.createChild(parent_2));
            i++;
            j--;
        }



        createMutationsForWorstChildren(childrenSolutions, childrenSolutions.size()/3 ,1);

        ArrayList<Solution> randomSolutions = createRandomGeneration(generationSize / 2);

        ArrayList<Solution> nextGenSolution = new ArrayList<>();
        nextGenSolution.addAll(randomSolutions);
        nextGenSolution.addAll(childrenSolutions);

        Generation nextGeneration = new Generation(trainers, customers, generationSize, nextGenSolution);
        return nextGeneration;
    }




    public ArrayList<Solution> getTopHalfSolutions(){
        ArrayList<Solution> topHalfSolutions = new ArrayList<>();

        Collections.sort(solutions);

        for (int i = 0; i < solutions.size() / 2; i++) {
            topHalfSolutions.add(solutions.get(i));
        }

        return topHalfSolutions;
    }


    public void printTotalSolutionsDiscrepancies(){
        for (Solution solution : solutions){
            int fitness = solution.discrepancy();
            System.out.println(fitness);
        }
    }

    public int discrepancy(){
        if (fitness == -1){
            int generationDiscrepancies = 0;

            for (Solution solution : solutions){
                generationDiscrepancies += solution.discrepancy();
            }

            return generationDiscrepancies;
        }
        return fitness;
    }

    public void printAllSolutionDiscrepancies(){
        for (Solution solution : solutions)
            System.out.println(solution.discrepancy());
    }



    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < solutions.size(); i++) {
            res.append("Solution " + i);
            res.append("\n");
            res.append(solutions.get(i).toString());
            res.append("\n");
            res.append("\n");
        }

        return res.toString();
    }

    public Solution findBestSolution() {
        Solution bestSolution = null;
        int lowestDiscrepancy = Integer.MAX_VALUE;

        for (Solution solution : solutions){
            if (solution.discrepancy() < lowestDiscrepancy){
                lowestDiscrepancy = solution.discrepancy();
                bestSolution = solution;
            }
        }

        return bestSolution;
    }
}
