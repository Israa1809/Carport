package dat.backend.model.entities;

public class Customer {
    String customerName;
    String address;
    int postalCode;
    String city;
    int phoneNumber;

    User user;

    public Customer(String customerName, String address, int postalCode, String city, int phone){
        this.customerName = customerName;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNumber = phone;


    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
}
