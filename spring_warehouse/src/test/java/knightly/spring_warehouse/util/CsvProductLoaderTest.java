package knightly.spring_warehouse.util;

import knightly.spring_warehouse.repository.jpa.Component;
import knightly.spring_warehouse.repository.jpa.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CsvProductLoaderTest {

    private String TEST_CSV_PATCH = "src/test/resources/testProducts.csv";
    private String INVALID_PATH = "this is not a valid path";
    private CsvProductLoader csvProductloader;

    @BeforeEach
    void setUpCsvProductLoader() {
        this.csvProductloader = new CsvProductLoader();
    }

    @Test
    public void loadComponentsFromCsvTestValid() {
        List<Product> testList = this.csvProductloader.loadProductsFromCsv(TEST_CSV_PATCH, getTestComponents());

        assertThat(testList).usingRecursiveComparison()
                .isEqualTo(getExpectedProducts());
    }

    @Test
    public void getEmptyListOnException() {
        List<Product> emptyList = this.csvProductloader.loadProductsFromCsv(INVALID_PATH, getTestComponents());

        Assertions.assertTrue(emptyList.isEmpty());
    }

    private List<Product> getExpectedProducts() {
        List<Component> componentList = getTestComponents();
        Product testProduct1 = new Product(0, "baker",
                List.of(componentList.get(4),
                        componentList.get(3),
                        componentList.get(2)));

        Product testProduct2 = new Product(1, "biker",
                List.of(componentList.get(3),
                        componentList.get(3),
                        componentList.get(3),
                        componentList.get(3)));

        Product testProduct3 = new Product(2, "fighter",
                List.of(componentList.get(0),
                        componentList.get(1),
                        componentList.get(3),
                        componentList.get(4)));

        return List.of(testProduct1, testProduct2, testProduct3);
    }

    private List<Component> getTestComponents() {
        return List.of(new Component(0, "foam spear", 10, "foaming", 10, 10, "1hand", 10, 10, 10),
                new Component(1, "wood sword", 20, "made from tree", 20, 20, "1hand", 20, 20, 20),
                new Component(2, "plastic shield", 30, "anti bonk", 30, 30, "1hand", 30, 30, 30),
                new Component(3, "bike helmet", 40, "safety first", 40, 40, "2hand", 40, 40, 40),
                new Component(4, "oven mitts", 50, "cake", 50, 2, "hands", 50, 50, 50));
    }
}
