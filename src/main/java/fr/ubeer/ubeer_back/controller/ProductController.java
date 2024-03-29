package fr.ubeer.ubeer_back.controller;

import fr.ubeer.ubeer_back.entity.Product;
import fr.ubeer.ubeer_back.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping( "/api/public/product/{id}" )
    public Product getProductById(@PathVariable Integer id) {
        return productService.findById(id);
    }

    @GetMapping( "/api/public/product/{id}/brewery" )
    public Product getBreweryIdByProductId(@PathVariable Integer id) {
        return productService.findById(id);
    }

    @PostMapping( "/api/private/product" )
    public void createProduct(@RequestParam Integer breweryId, @RequestBody Product product) {
        productService.addProduct(breweryId, product);
    }

    @PatchMapping( "/api/private/product" )
    public void updateProduct(@RequestParam Integer breweryId, @RequestBody Product product) {
        productService.updateProduct(breweryId, product);
    }

    @DeleteMapping( "/api/private/product/{id}" )
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProductById(id);
    }
}

