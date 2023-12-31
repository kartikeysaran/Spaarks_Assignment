package kartikey.saran.myapplication.model;

public class Address {
    private String city;
    private Geo geo;
    private String street;
    private String suite;
    private String zipcode;

    public Address(String city, Geo geo, String street, String suite, String zipcode) {
        this.city = city;
        this.geo = geo;
        this.street = street;
        this.suite = suite;
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}