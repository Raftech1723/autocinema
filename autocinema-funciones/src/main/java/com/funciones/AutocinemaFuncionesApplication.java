package com.funciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.funciones.client")
public class AutocinemaFuncionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutocinemaFuncionesApplication.class, args);
	}

}
