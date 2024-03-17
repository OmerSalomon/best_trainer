import data.Repository;
import genetic_algorithm.Algorithm;
import genetic_algorithm.Solution;
import properties.Customer;
import properties.Trainer;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Trainer> trainers = Repository.getInstance().getTrainers();
        List<Customer> customers = Repository.getInstance().getCustomer();

        Solution solutionA = new Solution(trainers, customers);
        Solution solutionB = new Solution(trainers, customers);

        Solution crossedSolution = new Solution(solutionA, solutionB);
        System.out.print(solutionA);
        System.out.print(solutionB);
        System.out.print(crossedSolution);

    }



}