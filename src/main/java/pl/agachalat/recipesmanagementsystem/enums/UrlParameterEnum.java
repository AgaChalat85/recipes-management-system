package pl.agachalat.recipesmanagementsystem.enums;

import lombok.Getter;

@Getter
public enum UrlParameterEnum {
    ID("id"),
    Q("q"),
    TAGS("tags");

    private final String value;

    UrlParameterEnum(String value) {
        this.value = value;
    }
}
