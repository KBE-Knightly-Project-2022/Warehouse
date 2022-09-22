package knightly.spring_warehouse.util;

import knightly.spring_warehouse.repository.jpa.Component;
import knightly.spring_warehouse.repository.util.CsvComponentLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CsvComponentLoaderTest {

    private String TEST_CSV_PATCH = "src/test/resources/testComponents.csv";
    private String INVALID_PATH = "this is not a valid path";
    private CsvComponentLoader csvComponentLoader;

    @BeforeEach
    void setUpCsvComponentLoader () {
        this.csvComponentLoader = new CsvComponentLoader();
    }

    @Test
    public void loadComponentsFromCsvTestValid () {
         List<Component> testList = this.csvComponentLoader.loadComponentsFromCsv(TEST_CSV_PATCH);
         List<Component> expectedList = this.getExpectedComponents();

         assertThat(testList).usingRecursiveComparison()
                .isEqualTo(getExpectedComponents());
    }

    @Test
    public void getEmptyListOnException () {
        List<Component> emptyList = this.csvComponentLoader.loadComponentsFromCsv(INVALID_PATH);

        Assertions.assertTrue(emptyList.isEmpty());
    }

    private List<Component> getExpectedComponents () {
        return List.of(new Component(0,"foam spear",10,"foaming",10,10,"1hand",10,10,10),
                new Component(1,"wood sword",20,"made from tree",20,20,"1hand",20,20,20),
                new Component(2,"plastic shield",30,"anti bonk",30,30,"1hand",30,30,30),
                new Component(3,"bike helmet",40,"safety first",40,40,"2hand",40,40,40),
                new Component(4,"oven mitts",50,"cake",50,2,"hands",50,50,50));
    }


}
