package com.tienda.rest.tiendarest.controller;

import com.tienda.rest.tiendarest.dto.productDTO;
import com.tienda.rest.tiendarest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tienda/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<productDTO> guardarProducto(@RequestBody productDTO product){
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<productDTO>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<productDTO> getProductById(@PathVariable(name="id") Long id){
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<productDTO> updateProduct(@PathVariable(name="id") Long id, @RequestBody productDTO productDTO){
        return new ResponseEntity<>(productService.updateProduct(id, productDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(name="id") Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("Producto eliminado con exito", HttpStatus.OK);
    }

}
