package knightly.spring_warehouse;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentRepository extends JpaRepository <Component, Long> {
}
