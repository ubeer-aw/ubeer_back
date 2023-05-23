package fr.ubeer.ubeer_back.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "UTILISATEUR")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Integer id;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    private Set<Brewery> brewery;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", brewery=" + brewery +
                '}';
    }
}
