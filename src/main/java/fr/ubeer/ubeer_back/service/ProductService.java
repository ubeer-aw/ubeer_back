package fr.ubeer.ubeer_back.service;

import fr.ubeer.ubeer_back.entity.Product;
import fr.ubeer.ubeer_back.repository.ProductRepository;
import fr.ubeer.ubeer_back.repository.BreweryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BreweryRepository breweryRepository;

    public List<Product> findAllByBreweryId(Integer breweryId) {
        return productRepository.findAllByBreweryId(breweryId);
    }

    public Product findById(Integer productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public void addProduct(Integer breweryId, Product product) {
        product.setBrewery(breweryRepository.findById(breweryId).orElse(null));
        productRepository.save(product);
    }

    public void updateProduct(Integer breweryId, Product product) {
        product.setBrewery(breweryRepository.findById(breweryId).orElse(null));
        productRepository.save(product);
    }

    public void deleteProductById(Integer productId) {
        productRepository.deleteById(productId);
    }
}
