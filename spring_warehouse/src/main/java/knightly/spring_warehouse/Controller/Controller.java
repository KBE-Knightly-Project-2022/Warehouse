package knightly.spring_warehouse.Controller;

import knightly.spring_warehouse.service.Impl.DataServiceImpl;
import knightly.spring_warehouse.repository.jpa.Component;
import knightly.spring_warehouse.repository.jpa.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    DataServiceImpl dataService;


    @GetMapping("/components")
    public List<Component> getAllComponents() {
        return dataService.getAllComponents();
    }

    @GetMapping("/component/{id}")
    public Component getComponentByID(@PathVariable("id") long id) {
        return dataService.getComponentByID(id);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return dataService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProductByID(@PathVariable("id") long id) {
        return dataService.getProductByID(id);
    }
}
