package com.pokeshop.ecommerce.entity.enumerado;

public enum EnumGenero {

    M("MASCULINO"),
    F("FEMENINO"),
    S("SIN ESPECIFICAR");

    private final String value;

    EnumGenero(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }

    public static EnumGenero getEnumByValue(String value) {
        for (EnumGenero e : EnumGenero.values()) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }
        return null;
    }

}