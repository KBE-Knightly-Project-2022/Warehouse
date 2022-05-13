package knightly.spring_warehouse.repository;

import knightly.spring_warehouse.model.Component;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentRepository extends JpaRepository <Component, Long> {
}
