package genetic_algorithm;

import properties.Customer;
import properties.Trainer;

import java.util.ArrayList;

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
