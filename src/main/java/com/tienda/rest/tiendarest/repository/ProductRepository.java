package com.tienda.rest.tiendarest.repository;

import com.tienda.rest.tiendarest.entitys.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<product, Long> {

}

