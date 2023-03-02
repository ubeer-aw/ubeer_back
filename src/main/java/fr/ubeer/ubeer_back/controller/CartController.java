package fr.ubeer.ubeer_back.controller;

import fr.ubeer.ubeer_back.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class CartController {

    @Autowired
    private CartService cartService;
}
