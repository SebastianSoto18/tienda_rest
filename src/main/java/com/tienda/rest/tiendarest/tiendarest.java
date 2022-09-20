package com.tienda.rest.tiendarest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class tiendarest {

  public static void main(String[] args) {
    SpringApplication.run(tiendarest.class, args);
  }
}
