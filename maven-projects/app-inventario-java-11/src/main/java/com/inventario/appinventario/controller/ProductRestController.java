package com.inventario.appinventario.controller;

import com.inventario.appinventario.entity.Product;
import com.inventario.appinventario.service.ProductService;
import com.inventario.appinventario.util.MyCustomResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ProductRestController {

    @Autowired
    private ProductService service;

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MyCustomResponseBody deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
        return new MyCustomResponseBody("Producto borrado", "OK");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/products")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts() {
        return service.listAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/products")
    @ResponseStatus(HttpStatus.CREATED)
    public MyCustomResponseBody saveProduct(@RequestBody Product product) {
        service.save(product);
        return new MyCustomResponseBody("Producto creado", "OK");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product detailProduct(@PathVariable(name = "id") int id) {
        return service.get(id);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MyCustomResponseBody updateProduct(@RequestBody Product product, @PathVariable(name = "id") int id) {
        service.save(product);
        return new MyCustomResponseBody("Producto editado", "OK");
    }
}
