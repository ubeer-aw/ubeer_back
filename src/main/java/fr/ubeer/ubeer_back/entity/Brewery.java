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

    @Column(name = "NOM", nullable = false)
    private String name;

    @Column(name="DESCRIPTION", length = 1000)
    private String description;

    @Column(name = "IMAGE", nullable = false)
    private String img;
    @OneToMany(mappedBy="brewery", cascade = CascadeType.ALL)
    private Set<Beer> beers;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Set<Beer> getBeers() {
        return beers;
    }

    public void setBeers(Set<Beer> beers) {
        this.beers = beers;
    }

    @Override
    public String toString() {
        return "Brewery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", img='" + img + '\'' +
                ", beers=" + beers +
                '}';
    }
}
