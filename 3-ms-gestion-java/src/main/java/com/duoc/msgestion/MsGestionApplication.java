package com.duoc.msgestion;

import com.duoc.msgestion.model.Producto;
import com.duoc.msgestion.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.duoc.msgestion")
public class MsGestionApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsGestionApplication.class, args);
    }

    @Bean
    public CommandLineRunner initDatabase(ProductoRepository repository) {
        return args -> {
            // Carga inicial de datos de prueba en la base de datos SQLite
            repository.save(new Producto("Notebook Asus Core i7", 749990.0));
            repository.save(new Producto("Monitor Gamer 24 Pulgadas", 139990.0));
            repository.save(new Producto("Mouse Inalambrico Pro", 29990.0));
        };
    }
}