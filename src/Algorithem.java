import java.util.ArrayList;
import java.util.HashMap;

public class Algorithem {
    private final ArrayList<Trainer> trainers;
    private final ArrayList<Customer> customers;

    private HashMap<String, ArrayList<String>> solution;

    public Algorithem(ArrayList<Trainer> trainers, ArrayList<Customer> customers) {
        this.trainers = trainers;
        this.customers = customers;
    }
}