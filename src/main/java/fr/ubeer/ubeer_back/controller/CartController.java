package fr.ubeer.ubeer_back.controller;

import fr.ubeer.ubeer_back.entity.Cart;
import fr.ubeer.ubeer_back.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping( "/cart/{id}" )
    public Cart getProductById(@PathVariable Integer id) {
        return cartService.findById(id);
    }
}
