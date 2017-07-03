package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellValue;
import com.medicalsystem.model.Reoperation;
import com.medicalsystem.service.ReoperationService;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReoperationBuilder {

    private final ReoperationService reoperationService;

    @Autowired
    public ReoperationBuilder(ReoperationService reoperationService) {
        this.reoperationService = reoperationService;
    }

    /**
     * Creates a list of Reoperation based on excel input.
     * Input can be e.g. "456", "13", "6", hence the list.
     */
    public List<Reoperation> build(Row row) {
        List<Reoperation> reoperations = new ArrayList<>();

        /* Reoperation */
        CellValue reoperationCell = new CellValue(row, "reoperation.number");
        String value = reoperationCell.getAsString();

        for (char c : value.toCharArray()) {
            int id = Character.getNumericValue(c);
            Reoperation reoperation = reoperationService.getById(id);

            if (reoperation == null) {
                System.out.println("Reoperation not found: " + id);
                continue;
            }

            reoperations.add(reoperation);
        }

        return reoperations;
    }

}