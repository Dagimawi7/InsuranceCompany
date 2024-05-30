import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsuranceCompany {
    private static final String CUSTOMER_FILE = "customers.txt";
    private static final String POLICY_FILE = "policies.txt";

    private List<Customer> customers = new ArrayList<>();
    private List<Policy> policies = new ArrayList<>();

    public static void main(String[] args) {
        InsuranceCompany company = new InsuranceCompany();
        company.loadAllData();
        company.run();
        company.saveAllData();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Insurance Company Management System");
            System.out.println("1. Add Customer");
            System.out.println("2. Create Policy");
            System.out.println("3. View Customers");
            System.out.println("4. View Policies");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addCustomer(scanner);
                    break;
                case 2:
                    createPolicy(scanner);
                    break;
                case 3:
                    viewCustomers();
                    break;
                case 4:
                    viewPolicies();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void addCustomer(Scanner scanner) {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();
        int id = customers.size() + 1;
        Customer customer = new Customer(id, name, email);
        customers.add(customer);
        System.out.println("Customer added successfully!");
    }

    public void createPolicy(Scanner scanner) {
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter policy number: ");
        String policyNumber = scanner.nextLine();
        System.out.print("Enter coverage amount: ");
        double coverageAmount = scanner.nextDouble();
        System.out.print("Enter premium amount: ");
        double premiumAmount = scanner.nextDouble();
        int id = policies.size() + 1;
        Policy policy = new Policy(id, customerId, policyNumber, coverageAmount, premiumAmount);
        policies.add(policy);
        System.out.println("Policy created successfully!");
    }

    public void viewCustomers() {
        System.out.println("Customers:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public void viewPolicies() {
        System.out.println("Policies:");
        for (Policy policy : policies) {
            System.out.println(policy);
        }
    }

    public void saveAllData() {
        FileUtil.writeToFile(CUSTOMER_FILE, customers);
        FileUtil.writeToFile(POLICY_FILE, policies);
    }

    public void loadAllData() {
        customers = FileUtil.readFromFile(CUSTOMER_FILE, Customer.class);
        policies = FileUtil.readFromFile(POLICY_FILE, Policy.class);
    }
}
