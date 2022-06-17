package pl.agachalat.recipesmanagementsystem.dto.measure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.agachalat.recipesmanagementsystem.domain.System;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UnitOfMeasureDto {

    private Long uomId;
    private String name;
    private System system;

}
