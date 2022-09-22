package knightly.spring_warehouse.repository.util;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import knightly.spring_warehouse.repository.jpa.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Collections;
import java.util.List;

public class CsvComponentLoader {

    private static final Logger logger = LoggerFactory.getLogger(CsvComponentLoader.class);

    public List<Component> loadComponentsFromCsv(String fileName) {

        try {
            final MappingIterator<Component> mappingIterator = getCsvMapper()
                    .readerWithSchemaFor(Component.class)
                    .readValues(
                            new File(fileName)
                    );
            return mappingIterator.readAll();
        } catch (IOException e) {
            logger.error("failed loading csv file in "+ this.getClass());
            return Collections.emptyList();
        }
    }

    private CsvMapper getCsvMapper() {
        return new CsvMapper().enable(CsvParser.Feature.WRAP_AS_ARRAY);
    }
}
