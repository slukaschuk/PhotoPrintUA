package ua.com.spiritus.models;

import javax.persistence.*;


@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "adressid")
    private Integer addressId;
    @Column(name = "phone")
    private String phone;
    @Column(name = "zip")
    private String zip;
    @Column(name = "country")
    private String country;
    @Column(name = "street")
    private String street;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "cityid", nullable = false)
    private City city;

    public Address() {

    }

    public Address(String phone, String zip, String country, String street) {
        this.phone      = phone;
        this.zip        = zip;
        this.country    = country;
        this.street     = street;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (!addressId.equals(address.addressId)) return false;
        if (phone != null ? !phone.equals(address.phone) : address.phone != null) return false;
        if (zip != null ? !zip.equals(address.zip) : address.zip != null) return false;
        if (country != null ? !country.equals(address.country) : address.country != null) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (!user.equals(address.user)) return false;
        return city.equals(address.city);

    }

    @Override
    public int hashCode() {
        int result = addressId.hashCode();
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + user.hashCode();
        result = 31 * result + city.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "phone='" + phone + '\'' +
                ", zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                ", street='" + street + '\'' +
                ", city=" + city +
                '}';
    }
}
