package ma.enset.inventoryservice;

import ma.enset.inventoryservice.entities.Product;
import ma.enset.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProductRepository productRepository,RepositoryRestConfiguration respositoryRestConfiguration) {
        return args -> {
            respositoryRestConfiguration.exposeIdsFor(Product.class);
          productRepository.saveAll(
                  List.of(
                          Product.builder().name("Computer").quantity(12).price(1200).build(),
                          Product.builder().name("Imprimante").quantity(129).price(1300).build(),
                          Product.builder().name("Smartphone").quantity(15).price(1800).build()


                  )
          );
        };
    }
}
