package fr.ubeer.ubeer_back.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PANIER")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "UTILISATEUR_ID")
    private User user;
    @Column(name = "DATE")
    private LocalDateTime date;
    @Column(name = "TOTAL")
    private double total;

    @OneToMany(mappedBy="cart", cascade = CascadeType.ALL)
    private Set<Cart_Beer> content;

    {
        date = LocalDateTime.now();
        content = new HashSet<>();
    }

    public Cart() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", user=" + user +
                ", date=" + date +
                ", total=" + total +
                '}';
    }
}
