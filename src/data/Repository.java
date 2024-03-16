package data;

import properties.Customer;
import properties.Trainer;

import java.util.ArrayList;

public class Repository {
    private static Repository repository = null;
    public static Repository getInstance(){
        Repository res = repository;
        if (repository == null)
            repository = new Repository();
        return repository;
    }

    private Repository(){
    }

    public  ArrayList<Customer> getCustomer(){
       return null;
    }

    public  ArrayList<Trainer> getTrainers() {
        return null;
    }
}
