package knightly.spring_warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private ComponentRepository componentRepository;


    @GetMapping("/components")
    public List<Component> getAllComponents(){
        return componentRepository.findAll();
    }

    @GetMapping("/components/{id}")
    public Optional<Component> getComponentByID(@PathVariable("id") long id){
        return componentRepository.findById(id);
    }
}
