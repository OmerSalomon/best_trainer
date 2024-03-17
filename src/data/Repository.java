package data;

import properties.Customer;
import properties.Gender;
import properties.Trainer;

import java.util.*;

public class Repository {
    private static final Random random = new Random();

    private static Repository repository = null;
    public static Repository getInstance(){
        Repository res = repository;
        if (repository == null)
            repository = new Repository();
        return repository;
    }

    private Repository(){
    }

    public  List<Customer> getCustomer(){
       return generateRandomCustomers(50);
    }

    private List<Customer> generateRandomCustomers(int numberOfCustomers) {
        List<Customer> customers = new ArrayList<>();

        for (int i = 0; i < numberOfCustomers; i++) {
            String id = UUID.randomUUID().toString();
            String firstName = "FirstName" + i;
            String lastName = "LastName" + i;
            Date birthDate = generateRandomBirthDate();
            Gender gender = random.nextBoolean() ? Gender.MALE : Gender.FEMALE;
            boolean[] accessibleTime = generateAccessibleTime();
            int demandWorkout = random.nextInt(5) + 1; // Assuming workout IDs range from 1 to 5

            customers.add(new Customer(id, firstName, lastName, birthDate, gender, accessibleTime, demandWorkout));
        }

        return customers;
    }

    private static Date generateRandomBirthDate() {
        int year = 1950 + random.nextInt(50); // Random year between 1950 and 2000
        int month = random.nextInt(12); // Random month
        int day = 1 + random.nextInt(28); // Random day (to avoid complications with February)
        return new GregorianCalendar(year, month, day).getTime();
    }


    public  List<Trainer> getTrainers() {
        List<Trainer> trainers = Arrays.asList(
                createTrainer("T001", "John", "Doe", new GregorianCalendar(1980, Calendar.JANUARY, 1).getTime(), Gender.MALE, generateAccessibleTime(), Arrays.asList(1, 2, 3)),
                createTrainer("T002", "Jane", "Smith", new GregorianCalendar(1990, Calendar.FEBRUARY, 2).getTime(), Gender.FEMALE, generateAccessibleTime(), Arrays.asList(4, 5, 6)),
                createTrainer("T003", "Jim", "Brown", new GregorianCalendar(1975, Calendar.MARCH, 3).getTime(), Gender.MALE, generateAccessibleTime(), Arrays.asList(7, 8, 9)),
                createTrainer("T004", "Jessica", "Garcia", new GregorianCalendar(1985, Calendar.APRIL, 4).getTime(), Gender.FEMALE, generateAccessibleTime(), Arrays.asList(10, 11, 12)),
                createTrainer("T005", "Jeremy", "Wilson", new GregorianCalendar(1995, Calendar.MAY, 5).getTime(), Gender.MALE, generateAccessibleTime(), Arrays.asList(13, 14, 15))
        );

        return trainers;
    }

    public static boolean[] generateAccessibleTime() {
        boolean[] accessibleTime = new boolean[24 * 7];
        Random random = new Random();
        for (int i = 0; i < accessibleTime.length; i++) {
            accessibleTime[i] = random.nextBoolean(); // Randomly set availability
        }
        return accessibleTime;
    }

    public static Trainer createTrainer(String id, String firstName, String lastName, Date birthDate, Gender gender, boolean[] accessibleTime, List<Integer> workouts) {
        return new Trainer(id, firstName, lastName, birthDate, gender, accessibleTime, workouts);
    }
}
