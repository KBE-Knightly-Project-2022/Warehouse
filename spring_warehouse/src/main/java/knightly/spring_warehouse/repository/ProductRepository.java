package knightly.spring_warehouse.repository;

import knightly.spring_warehouse.repository.jpa.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
