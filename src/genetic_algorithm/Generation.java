package genetic_algorithm;

import properties.Customer;
import properties.Trainer;

import javax.xml.transform.SourceLocator;
import java.util.ArrayList;
import java.util.Collections;

public class Generation {
    private ArrayList<Solution> solutions;

    private Generation(ArrayList<Solution> solutions){
        this.solutions = solutions;
    }

    public static Generation createRandomGeneration(ArrayList<Trainer> trainers, ArrayList<Customer> customers, int generationSize){
        ArrayList<Solution> solutions = new ArrayList<>();

        for (int i = 0; i < generationSize; i++){
            Solution solution = Solution.createRandomSolution(trainers, customers);
            solutions.add(solution);
        }

        return new Generation(solutions);
    }

    public static Generation createNextGeneration(ArrayList<Solution> topHalfSolutions){
        ArrayList<Solution> nextGenSolutions = new ArrayList<>();

        int i = 0;
        int j = topHalfSolutions.size() - 1;


        while (i < topHalfSolutions.size()){
            Solution parent_1 = topHalfSolutions.get(i);
            Solution parent_2 = topHalfSolutions.get(j);
            nextGenSolutions.add(parent_1.createChild(parent_2));
            i++;
            j--;
        }

        return new Generation(nextGenSolutions);
    }



    public ArrayList<Solution> getTopHalfSolutions(){
        ArrayList<Solution> topHalfSolutions = new ArrayList<>();

        Collections.sort(solutions);

        for (int i = 0; i < solutions.size() / 2; i++) {
            topHalfSolutions.add(solutions.get(i));
        }

        return topHalfSolutions;
    }

    public static void createNextGeneration(){

    }

    public void printTotalSolutionsDiscrepancies(){
        for (Solution solution : solutions){
            int fitness = solution.fitness();
            System.out.println(fitness);
        }
    }

    public int fitness(){
        int generationDiscrepancies = 0;

        for (Solution solution : solutions){
            generationDiscrepancies += solution.fitness();
        }

        return generationDiscrepancies;
    }

    public void printAllSolutionDiscrepancies(){
        for (Solution solution : solutions)
            System.out.println(solution.fitness());
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
}
