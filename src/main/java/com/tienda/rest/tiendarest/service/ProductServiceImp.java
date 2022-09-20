package com.tienda.rest.tiendarest.service;

import com.tienda.rest.tiendarest.dto.productDTO;
import com.tienda.rest.tiendarest.entitys.product;
import com.tienda.rest.tiendarest.exepciones.ResourceNotFoundException;
import com.tienda.rest.tiendarest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    //convertir a DTO
    private productDTO convertirProductToProductDTO(product product){
        productDTO productDTO = new productDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setCategory(product.getCategory());
        productDTO.setStock(product.getStock());
        productDTO.setCode(product.getCode());
        return productDTO;
    }

    //convertir a entidad
    private product convertirProductDTOToProduct(productDTO productDTO){
        product product = new product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(productDTO.getCategory());
        product.setStock(productDTO.getStock());
        product.setCode(productDTO.getCode());
        return product;
    }


    @Override
    public productDTO createProduct(productDTO productDTO) {
        //convertir el productDTO a product entidad
        product product = convertirProductDTOToProduct(productDTO);
        product = productRepository.save(product);
        //convertir el product a productDTO
        productDTO productDTOresponse = convertirProductToProductDTO(product);
        return productDTOresponse;
    }

    @Override
    public List<productDTO> getAllProducts() {
        List<product> productos = productRepository.findAll();
        return productos.stream().map(producto -> convertirProductToProductDTO(producto)).collect(Collectors.toList());
    }


    public productDTO getProductById(Long id) {
        product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("producto","id",id));
        return convertirProductToProductDTO(product);
    }

    @Override
    public productDTO updateProduct(Long id, productDTO productDTO) {
        product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("producto","id",id));
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(productDTO.getCategory());
        product.setStock(productDTO.getStock());
        product.setCode(productDTO.getCode());
        product = productRepository.save(product);
        return convertirProductToProductDTO(product);
    }

    @Override

    public void deleteProduct(Long id) {
        product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("producto","id",id));
        productRepository.delete(product);
    }


}

