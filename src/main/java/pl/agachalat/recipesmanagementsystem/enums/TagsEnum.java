package pl.agachalat.recipesmanagementsystem.enums;

public enum TagsEnum {

    GLUTEN_FREE("gluten_free"),
    VEGETARIAN("vegetarian"),
    VEGAN("vegan"),
    LOW_FAT("low_fat"),
    LOW_CARB("low_carb"),
    LOW_CALORI("low_calori"),
    KETO("keto"),
    HIGH_PROTEIN("high_protein");

    private final String value;

    TagsEnum(String value) {
        this.value = value;
    }


}
