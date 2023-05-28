package fr.ubeer.ubeer_back.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CATEGORIE_BRASSERIE")
public class BreweryCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Integer id;

    @Column(name = "NOM", nullable = false)
    private String name;

    public BreweryCategory() {
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

    @Override
    public String toString() {
        return "BreweryCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
