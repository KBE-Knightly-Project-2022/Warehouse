package knightly.spring_warehouse.controller;

import knightly.spring_warehouse.Controller.Controller;
import knightly.spring_warehouse.service.Impl.DataServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @InjectMocks
    private Controller controller;

    @Mock
    private DataServiceImpl dataService;

    @Test
    public void getAllProducts() {
        controller.getAllProducts();

        Mockito.verify(dataService, Mockito.times(1)).getAllProducts();
    }

    @Test
    public void getAllComponents() {
        controller.getAllComponents();

        Mockito.verify(dataService, Mockito.times(1)).getAllComponents();
    }

    @Test
    public void getProductByID() {
        controller.getProductByID(1L);

        Mockito.verify(dataService, Mockito.times(1)).getProductByID(1L);
    }

    @Test
    public void getComponentsByID() {
        controller.getComponentByID(1L);

        Mockito.verify(dataService, Mockito.times(1)).getComponentByID(1L);
    }
}
