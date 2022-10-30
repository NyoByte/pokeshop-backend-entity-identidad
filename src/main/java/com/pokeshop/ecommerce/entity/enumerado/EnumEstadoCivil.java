package com.pokeshop.ecommerce.entity.enumerado;

public enum EnumEstadoCivil {
    S("SOLTERO"),
    C("CASADO"),
    D("DIVORCIADO"),
    V("VIUDO"),
    ;

    private final String value;

    EnumEstadoCivil(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }

    public static EnumEstadoCivil getEnumByValue(String value) {
        for (EnumEstadoCivil e : EnumEstadoCivil.values()) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }
        return null;
    }

}