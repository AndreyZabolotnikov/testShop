package ru.duxa.testShop.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.duxa.testShop.models.Product;
import ru.duxa.testShop.repositories.ProductRepository;
import ru.duxa.testShop.util.ProductNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(int id) {
        Optional<Product> foundProduct = productRepository.findById(id);
        return foundProduct.orElseThrow(ProductNotFoundException::new);
    }

    public List<Product> getByTypeProduct(String type) {
        return productRepository.getByTypeProduct(type);
    }

    @Transactional
    public void save(Product product) {
        productRepository.save(product);
    }

}
