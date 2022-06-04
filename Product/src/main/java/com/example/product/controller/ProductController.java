package com.example.product.controller;

import com.example.product.entity.Product;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


/**
 * http"//localhost:8080/api/v1/products | GET | return list product
 * http"//localhost:8080/api/v1/products | POST | create list product
 * http"//localhost:8080/api/v1/products/1 | DELETE | remove product
 * http"//localhost:8080/api/v1/products/1 | GET | find product by id
 * http"//localhost:8080/api/v1/products/1 | PUT | update product
 *
 */
@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {
    //full option CRUD

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Product>> getList(){
        return ResponseEntity.ok(productService.findAll());
    }

    // Path Variable
    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getDetail(@PathVariable String id) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (!optionalProduct.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalProduct.get());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }


    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        if (!productService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Product> update(@PathVariable String id, @RequestBody Product product) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (!optionalProduct.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Product existStudent = optionalProduct.get();
        // update data
        existStudent.setId(product.getId());
        existStudent.setName(product.getName());
        existStudent.setSlug(product.getSlug());
        existStudent.setDescription(product.getDescription());
        existStudent.setDetail(product.getDetail());
        existStudent.setPrice(product.getPrice());
        existStudent.setImage(product.getImage());
        existStudent.setBrand(product.getBrand());
        existStudent.setUserCre(product.getUserCre());
        existStudent.setUserUp(product.getUserUp());
        existStudent.setUserDel(product.getUserDel());
        existStudent.setUpdatedAt(product.getUpdatedAt());
        existStudent.setStatus(product.getStatus());
        return ResponseEntity.ok(productService.save(existStudent));
    }

}

