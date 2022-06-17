package pl.agachalat.recipesmanagementsystem.dto.measure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.agachalat.recipesmanagementsystem.domain.UnitOfMeasure;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ImperialMetricMapDto {

    private Long immId;
    private UnitOfMeasure imperialUnit;
    private UnitOfMeasure metricUnit;
    private Double metricQuantity;
}
