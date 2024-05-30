import java.io.Serializable;

public class Policy implements Serializable {
    private int id;
    private int customerId;
    private String policyNumber;
    private double coverageAmount;
    private double premiumAmount;

    public Policy(int id, int customerId, String policyNumber, double coverageAmount, double premiumAmount) {
        this.id = id;
        this.customerId = customerId;
        this.policyNumber = policyNumber;
        this.coverageAmount = coverageAmount;
        this.premiumAmount = premiumAmount;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public double getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(double coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return id + "," + customerId + "," + policyNumber + "," + coverageAmount + "," + premiumAmount;
    }

    public static Policy fromString(String str) {
        String[] parts = str.split(",");
        return new Policy(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), parts[2], Double.parseDouble(parts[3]), Double.parseDouble(parts[4]));
    }
}
