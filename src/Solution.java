import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class Solution {

    public static Solution createRandomSolution(ArrayList<Trainer> trainers, ArrayList<Customer> customers){
        HashMap<String, ArrayList<String>> trainerToCustomers = new HashMap<>();
        Random random = new Random();

        for (Customer customer : customers){
            Trainer trainer = trainers.get(random.nextInt(trainers.size()));
            if (trainerToCustomers.containsKey(trainer.getId())) {
                ArrayList<String> list = trainerToCustomers.get(trainer.getId());
                list.add(customer.getId());
            }
            else {
                ArrayList<String> list = new ArrayList<>();
                list.add(customer.getId());
                trainerToCustomers.put(trainer.getId(), list);
            }

            ArrayList<String> customersList = trainerToCustomers.get(trainer.getId());
        }
        Solution solution = new Solution(trainerToCustomers);

    }

    private  ArrayList<Customer> customers;
    private HashMap<String, ArrayList<String>> trainerToCustomers;

    public Solution(HashMap<String, ArrayList<String>> trainerToCustomers) {
        this.trainerToCustomers = trainerToCustomers;
    }

    public int fitness(){
        for ()
    }
}
