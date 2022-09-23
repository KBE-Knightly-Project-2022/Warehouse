package knightly.spring_warehouse.service.Impl;

import knightly.spring_warehouse.service.DataService;
import knightly.spring_warehouse.exceptions.IdNotFoundException;
import knightly.spring_warehouse.repository.ComponentRepository;
import knightly.spring_warehouse.repository.ProductRepository;
import knightly.spring_warehouse.repository.jpa.Component;
import knightly.spring_warehouse.repository.jpa.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    ComponentRepository componentRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Component> getAllComponents() {
        return this.componentRepository.findAll();
    }

    @Override
    public Component getComponentByID(long id) {
        return componentRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductByID(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id));
    }
}
