package br.com.digisystem.firsttestdigisystem.enums;

/**
 * @author Fernando Zandonadi
 * @Email ferzan17@gmail.com
 **/
public enum OperationsEnum {

    SOMA(1, "SOMA"),
    SUBTRACAO(2, "SUBTRAI"),
    MEDIA(3, "MEDIA"),
    TOTAL(4, "TOTAL");

    Integer id;
    String description;

    OperationsEnum(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

}
