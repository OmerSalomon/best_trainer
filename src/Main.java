import data.Repository;
import genetic_algorithm.Algorithem;
import genetic_algorithm.Generation;
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

        Algorithem algorithem = new Algorithem(trainers, customers);
        Solution bestSolution = algorithem.findBestSolution(100,1000);

        System.out.println(bestSolution);
    }



}