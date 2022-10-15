package ru.mertech.sbpskb.pojo.sbp;

public enum OperationType {
    PAYMENT("C2BQRD", "Продажа"), REFUND("B2C", "Возврат");

    private final String code;

    private final String label;


    OperationType(String paramString1, String paramString2) {
        this.code = paramString1;
        this.label = paramString2;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getLabel() {
        return this.label;
    }
}
