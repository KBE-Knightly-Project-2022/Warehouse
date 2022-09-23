package knightly.spring_warehouse.controller;

import knightly.spring_warehouse.Controller.Controller;
import knightly.spring_warehouse.exceptions.IdNotFoundException;
import knightly.spring_warehouse.service.Impl.DataServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(Controller.class)
public class ControllerMVCTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DataServiceImpl dataService;

    @Test
    public void getAllProducts() {
        try {
            mockMvc.perform(get("/products"))
                    .andExpect(status().isOk());

            verify(dataService).getAllProducts();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void getAllComponents() {
        try {
            mockMvc.perform(get("/components"))
                    .andExpect(status().isOk());

            verify(dataService).getAllComponents();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void getComponentById() {
        try {
            mockMvc.perform(get("/component/0"))
                    .andExpect(status().isOk());

            verify(dataService).getComponentByID(0L);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void getProductById() {
        try {
            mockMvc.perform(get("/product/1"))
                    .andExpect(status().isOk());

            verify(dataService).getProductByID(1L);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void getProductByWrongId() {
        try {
            mockMvc.perform(get("/product/90000"))
                    .andExpect(status().is(404));

        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void getComponentByWrongId() {
        try {
            Mockito.when(dataService.getComponentByID(90000)).thenThrow(IdNotFoundException.class);
            mockMvc.perform(get("/component/90000"))
                    .andExpect(status().is(404));

        } catch (Exception e) {
            fail();
        }
    }
}
