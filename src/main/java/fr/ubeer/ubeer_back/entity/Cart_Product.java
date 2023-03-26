package fr.ubeer.ubeer_back.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PANIER_PRODUIT")
public class Cart_Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "PANIER_ID")
    private Cart cart;
    @ManyToOne
    @JoinColumn(name = "BIERE_ID")
    private Product product;
    @Column(name = "QUANTITE")
    private int quantity;

    public Cart_Product() {
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart_Product{" +
                "id=" + id +
                ", cart=" + cart +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
