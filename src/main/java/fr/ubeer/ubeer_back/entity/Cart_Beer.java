package fr.ubeer.ubeer_back.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PANIER_BIERE")
public class Cart_Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "PANIER_ID")
    private Cart cart;
    @ManyToOne
    @JoinColumn(name = "BIERE_ID")
    private Beer beer;
    @Column(name = "QUANTITE")
    private int quantity;

    public Cart_Beer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart_Beer{" +
                "id=" + id +
                ", cart=" + cart +
                ", beer=" + beer +
                ", quantity=" + quantity +
                '}';
    }
}
