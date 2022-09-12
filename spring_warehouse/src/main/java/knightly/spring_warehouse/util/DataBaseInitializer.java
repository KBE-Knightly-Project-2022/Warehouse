package knightly.spring_warehouse.util;

import knightly.spring_warehouse.repository.jpa.Component;
import knightly.spring_warehouse.repository.jpa.Product;
import knightly.spring_warehouse.repository.ComponentRepository;
import knightly.spring_warehouse.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataBaseInitializer {

    final static String COMPONENTS_CSV_PATH = "src/main/resources/components.csv";
    final static String PRODUCTS_CSV_PATH = "src/main/resources/products.csv";
    private final CsvComponentLoader csvComponentLoader = new CsvComponentLoader();
    private final CsvProductLoader csvProductLoader = new CsvProductLoader();
    private static final Logger logger = LoggerFactory.getLogger(DataBaseInitializer.class);

    @Bean
    CommandLineRunner initializeDatabase(ComponentRepository componentRepository, ProductRepository productRepository) {
        return args -> {

            try {
                List<Component> components = csvComponentLoader.loadComponentsFromCsv(COMPONENTS_CSV_PATH);
                componentRepository.saveAll(components);

                List<Product> products = csvProductLoader.loadProductsFromCsv(PRODUCTS_CSV_PATH, components);
                productRepository.saveAll(products);
            } catch (Exception e) {
                logger.error("Database was already loaded, stoppping rereading from csv");
            }
        };
    }
}
