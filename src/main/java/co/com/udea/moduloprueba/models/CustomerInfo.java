package co.com.udea.moduloprueba.models;

public final class CustomerInfo {

    private final String firstName;
    private final String lastName;
    private final String postalCode;

    private CustomerInfo(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    public static CustomerInfo of(String firstName, String lastName, String postalCode) {
        return new CustomerInfo(firstName, lastName, postalCode);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }
}