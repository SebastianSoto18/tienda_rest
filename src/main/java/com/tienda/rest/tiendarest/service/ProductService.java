package com.tienda.rest.tiendarest.service;

import com.tienda.rest.tiendarest.dto.productDTO;

import java.util.List;

public interface ProductService {
    public productDTO createProduct(productDTO productDTO);

    public List<productDTO> getAllProducts();

    public productDTO getProductById(Long id);

    public productDTO updateProduct(Long id, productDTO productDTO);

    public void deleteProduct(Long id);
}
