package knightly.spring_warehouse.service;

import knightly.spring_warehouse.repository.jpa.Component;
import knightly.spring_warehouse.repository.jpa.Product;

import java.util.List;

public interface DataService {

    List<Component> getAllComponents();
    Component getComponentByID(long id);
    List<Product> getAllProducts();
    Product getProductByID(long id);
}
