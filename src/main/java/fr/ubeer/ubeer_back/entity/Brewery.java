package fr.ubeer.ubeer_back.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "BRASSERIE")
public class Brewery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "UTILISATEUR_ID")
    private User user;
    @Column(name = "NOM", length = 1000, nullable = false)
    private String name;
    @Column(name="DESCRIPTION", length = 5000)
    private String description;
    @Column(name="NOTE")
    private double stars;
    @Column(name = "IMAGE", length = 1000, nullable = false)
    private String img;
    @OneToMany(mappedBy="brewery", cascade = CascadeType.ALL)
    private Set<Product> products;

    public Brewery() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Brewery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", stars=" + stars +
                ", img='" + img + '\'' +
                ", products=" + products +
                '}';
    }
}
