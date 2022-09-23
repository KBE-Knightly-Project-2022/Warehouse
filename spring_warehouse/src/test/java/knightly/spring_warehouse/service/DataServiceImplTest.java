package knightly.spring_warehouse.service;

import knightly.spring_warehouse.repository.ComponentRepository;
import knightly.spring_warehouse.repository.ProductRepository;
import knightly.spring_warehouse.repository.jpa.Component;
import knightly.spring_warehouse.repository.jpa.Product;
import knightly.spring_warehouse.service.Impl.DataServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class DataServiceImplTest {

    @InjectMocks
    private DataServiceImpl dataServiceImpl;

    @Mock
    private ComponentRepository componentRepository;

    @Mock
    private ProductRepository productRepository;


    @Test
    public void  getAllComponentsTest() {
        dataServiceImpl.getAllComponents();

        Mockito.verify(componentRepository, times(1)).findAll();
    }

    @Test
    public void getAllProducts() {
        dataServiceImpl.getAllProducts();

        Mockito.verify(productRepository, times(1)).findAll();
    }

//    @Test
//    public void getComponentByID() {
//        Component component = mock(Component.class);
//        when(componentRepository.findById(any())).thenReturn(java.util.Optional.of(component));
//        dataServiceImpl.getComponentByID(2L);
//
//
//        Mockito.verify(componentRepository.findById(any()));
//    }

//    @Test
//    public void getProductByID() {
//        Product product = mock(Product.class);
//        when(componentRepository.findById(any())).thenReturn(java.util.Optional.of(product));
//        dataServiceImpl.getProductByID(0L);
//
//        Mockito.verify(productRepository.findById(any()));
//    }

    private Component getComponent() {
        return new Component(
                2L,
                "Floomp"
                ,20
                ,"nice"
                ,1
                ,1
                ,"ead"
                ,1
                ,1
                ,1
        );
    }

}
