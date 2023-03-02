package fr.ubeer.ubeer_back.service;

import fr.ubeer.ubeer_back.entity.Cart;
import fr.ubeer.ubeer_back.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart findById(Integer cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }
}
