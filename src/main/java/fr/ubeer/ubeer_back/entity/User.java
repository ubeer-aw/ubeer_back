package fr.ubeer.ubeer_back.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "UTILISATEUR")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Integer id;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "mdp", nullable = false)
    private String pwd;
    @OneToOne
    @JoinColumn(name = "PANIER_ID")
    private Cart cart;
    @Column(name = "PRENOM", nullable = false)
    private String first_name;
    @Column(name = "NOM", nullable = false)
    private String last_name;
    @Column(name = "ADRESSE")
    private String address;
    @Column(name = "VILLE")
    private String city;
    @Column(name = "CODE_POSTAL")
    private String zip_code;
    @Column(name = "PAYS")
    private String country;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", cart=" + cart +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", zip_code='" + zip_code + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
