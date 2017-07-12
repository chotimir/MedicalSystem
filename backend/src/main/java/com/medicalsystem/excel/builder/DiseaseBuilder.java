package com.medicalsystem.excel.builder;

import com.medicalsystem.excel.CellValue;
import com.medicalsystem.excel.ExcelColumnsProperties;
import com.medicalsystem.model.Disease;
import com.medicalsystem.model.DiseaseDescription;
import com.medicalsystem.service.DiseaseDescriptionService;
import com.medicalsystem.service.DiseaseService;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DiseaseBuilder {

    private final ExcelColumnsProperties columnsProperties;
    private final DiseaseService diseaseService;
    private final DiseaseDescriptionService diseaseDescriptionService;

    public List<DiseaseDescription> build(Row row) {
        List<DiseaseDescription> diseaseDescriptions = new ArrayList<>();

        /* Get index of the column of the first disease */
        int firstDiseaseIndex = columnsProperties.getColumnPropertyAsInt("disease.shock.number");

        /* Get index of the column of the last disease */
        int lastDiseaseIndex = columnsProperties.getColumnPropertyAsInt("disease.ekg.number");

        /* Iterate over diseases - assumes that disease description ids are in proper order */
        int descriptionId = 1;

        for (int i = firstDiseaseIndex; i <= lastDiseaseIndex; i++, descriptionId++) {

            /* Get disease result */
            CellValue resultCell = new CellValue(row, i);
            int result = resultCell.getAsInt();

            if (result > 0) {
                Disease disease = diseaseService.getById(descriptionId);
                DiseaseDescription diseaseDescription = diseaseDescriptionService.getByDiseaseAndExcelValue(disease, result);

                if (diseaseDescription != null) {
                    diseaseDescriptions.add(diseaseDescription);
                }
            }

        }

        return diseaseDescriptions;
    }
}
