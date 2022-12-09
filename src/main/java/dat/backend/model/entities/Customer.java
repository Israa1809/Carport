package dat.backend.model.entities;

public class Customer {
    private String customerName;
    private String address;
    private int postalCode;
    private String city;
    private int phoneNumber;
    private String email;

    private User user;

    public Customer(String customerName, String address, int postalCode, String city, int phone, String email){
        this.customerName = customerName;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNumber = phone;
        this.email = email;
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

    public String getEmail() {
        return email;
    }


}
