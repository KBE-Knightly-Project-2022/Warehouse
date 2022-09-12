package knightly.spring_warehouse.Controller;

import knightly.spring_warehouse.exceptions.IdNotFoundException;
import knightly.spring_warehouse.repository.jpa.Component;
import knightly.spring_warehouse.repository.jpa.Product;
import knightly.spring_warehouse.repository.ComponentRepository;
import knightly.spring_warehouse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private ComponentRepository componentRepository;

    @Autowired
    ProductRepository productRepository;


    @GetMapping("/components")
    public List<Component> getAllComponents() {
        return componentRepository.findAll();
    }

    @GetMapping("/component/{id}")
    public Component getComponentByID(@PathVariable("id") long id) {
        return componentRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id));
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public Product getProductByID(@PathVariable("id") long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id));
    }
}
