package ru.duxa.testShop.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.duxa.testShop.models.Product;
import ru.duxa.testShop.repositories.ProductRepository;
import ru.duxa.testShop.services.ProductService;
import ru.duxa.testShop.util.ProductErrorResponse;
import ru.duxa.testShop.util.ProductNotCreateException;
import ru.duxa.testShop.util.ProductNotFoundException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<HttpStatus> addProduct(@RequestBody @Valid Product product, BindingResult bindingResult) {
        checkErr(bindingResult);

        productService.save(product);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody @Valid Product product, BindingResult bindingResult,
                                             @PathVariable("id") int id) {
        checkErr(bindingResult);

        productService.update(id, product);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/getProduct")
    public List<Product> getAll() {
        return productService.findAll();
    }

    @GetMapping("/getProduct/{id}")
    public Product productById(@PathVariable("id") int id) {
        return productService.findById(id);
    }

    @GetMapping("getTypeProduct/{type}")
    public List<Product> productByType(@PathVariable("type") String type) {
        return productService.getByTypeProduct(type);
    }

    @ExceptionHandler
    private ResponseEntity<ProductErrorResponse> handleException(ProductNotFoundException e) {
        ProductErrorResponse response = new ProductErrorResponse(
                "Product with this id was`t found",
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<ProductErrorResponse> handleException(ProductNotCreateException e) {
        ProductErrorResponse response = new ProductErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private void checkErr(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorMsg.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";");
            }
            throw new ProductNotCreateException(errorMsg.toString());
        }
    }

}
