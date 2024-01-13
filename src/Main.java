import data.Repository;
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
        Solution parent_1 = Solution.createRandomSolution(trainers, customers);
        Solution parent_2 = Solution.createRandomSolution(trainers, customers);
        Solution child = parent_1.createChild(parent_2);
        System.out.println("parent_1");
        System.out.println(parent_1);
        System.out.println("parent_2");
        System.out.println(parent_2);
        System.out.println("child");
        System.out.println(child);
    }



}