package genetic_algorithm;

import properties.Customer;
import properties.Trainer;

import java.util.ArrayList;
import java.util.Random;

public class Solution implements Comparable<Solution> {
    private static final int GENDER_EQUALITY_POINTS = 5;
    private static final int AGE_DIFFERENCE_FACTOR = 1;
    private static final int WORKOUT_TIME_DELTA_FACTOR = 3;

    private final ArrayList<Pair> pairs;

    private Solution(ArrayList<Trainer> trainers){
        pairs = new ArrayList<>();

        for (Trainer trainer : trainers)
            pairs.add(new Pair(trainer));
    }

    private Solution(){
        pairs = new ArrayList<>();
    }

    public Solution createChild(Solution parent){
        Solution child = new Solution();
        boolean flag = true;

        ArrayList<Pair> parentPair = parent.getPairs();

        for (int i = 0; i < pairs.size(); i++) {
            if (flag){
                child.addPair(parentPair.get(i));
            }
            else {
                child.addPair(this.pairs.get(i));
            }
        }

        return child;
    }

    public void addPair(Pair pair){
        pairs.add(pair);
    }

    public ArrayList<Pair> getPairs(){
        return pairs;
    }


    private void addToPair(Customer customer, int index){
        pairs.get(index).addCustomer(customer);
    }

    public int fitness(){
        int fitnessDiscrepancy = 0;

        for (Pair pair : pairs)
            fitnessDiscrepancy += pair.getDiscrepancy();

        return fitnessDiscrepancy;
    }

    public static Solution createRandomSolution(ArrayList<Trainer> trainers, ArrayList<Customer> customers){
        Solution solution = new Solution(trainers);

        Random random = new Random();
        for (Customer customer : customers){
            int index = random.nextInt(trainers.size());
            solution.addToPair(customer, index);
        }

        return solution;
    }



    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        for (Pair pair : pairs){
            res.append(pair.toString());
            res.append("\n");
        }

        return res.toString();
    }

    @Override
    public int compareTo(Solution o) {
        return fitness() - o.fitness();
    }
}
