import data.Repository;
import genetic_algorithm.Algorithm;
import genetic_algorithm.Solution;
import properties.Customer;
import properties.Trainer;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArrayList<Trainer> trainers = Repository.getInstance().getTrainers();
        ArrayList<Customer> customers = Repository.getInstance().getCustomer();

        Algorithm algorithem = new Algorithm(trainers, customers);
        Solution bestSolution = algorithem.findBestSolution(100,1500);

        System.out.println(bestSolution);
    }



}