package kartikey.saran.myapplication.model;

public class User {
    private Address address;
    private Company company;
    private String email;
    private int id;
    private String name;
    private String phone;
    private String username;
    private String website;

    public User(Address address, Company company, String email, int id, String name, String phone, String username, String website) {
        this.address = address;
        this.company = company;
        this.email = email;
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.username = username;
        this.website = website;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
