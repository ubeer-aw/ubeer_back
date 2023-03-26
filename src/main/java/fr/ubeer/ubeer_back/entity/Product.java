package fr.ubeer.ubeer_back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "PRODUIT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Integer id;
    @Column(name = "NOM", nullable = false)
    private String name;
    @Column(name = "DESCRIPTION", length = 1000)
    private String description;
    @Column(name = "IMAGE", nullable = false)
    private String img;
    @Column(name="PRIX", nullable = false)
    private double price;
    @ManyToOne
    @JoinColumn(name = "BRASSERIE_ID")
    private Brewery brewery;

    {
        price = 0;
    }

    public Product() {
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getBrewery() {
        return brewery.getId();
    }

    public void setBrewery(Brewery brewery) {
        this.brewery = brewery;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", img='" + img + '\'' +
                ", price=" + price +
                ", brewery=" + brewery +
                '}';
    }
}
