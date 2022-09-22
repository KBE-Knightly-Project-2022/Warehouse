package knightly.spring_warehouse.repository.util;

import knightly.spring_warehouse.repository.jpa.Component;
import knightly.spring_warehouse.repository.jpa.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CsvProductLoader {

    private static final Logger logger = LoggerFactory.getLogger(CsvProductLoader.class);

    public List<Product> loadProductsFromCsv(String fileName, List<Component> components) {

        return importLinesFromCsv(fileName).stream().map(
                line -> createProduct(components, line))
                .collect(Collectors.toList());
    }

    private Product createProduct(List<Component> productComponents, List<String> line) {
        return new Product()
                .setId(Long.parseLong(line.get(0)))
                .setName(line.get(1))
                .setComponents(getComponents(line.get(2), productComponents));
    }

    private List<Component> getComponents(String lineOfRequiredComponents,List<Component> components) {

        return Arrays.stream(lineOfRequiredComponents.split("-"))
                .map(componentId -> components.get(Integer.parseInt(componentId)))
                .collect(Collectors.toList());
    }

    private List<List<String>> importLinesFromCsv(String prodcutsFileName) {

        final List<List<String>> lines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(prodcutsFileName));
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                lines.add(Arrays.asList(columns));
            }
        } catch (IOException e) {
            logger.error("failed loading csv file in "+ this.getClass());
            return Collections.emptyList();
        }
        return lines;
    }

}
