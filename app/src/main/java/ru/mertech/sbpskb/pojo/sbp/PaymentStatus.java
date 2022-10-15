package ru.mertech.sbpskb.pojo.sbp;

public enum PaymentStatus {
    NOT_STARTED("NTST", "Операция не зарегистрирована"), RECEIVED("RCVD", "Операция в обработке"), ACCEPTED("ACWP", "Операция завершена успешно"), REJECTED("RJCT", "Операция отклонена"), SUCCESS("SUCCESS", "SUCCESS");

    private final String code;

    private final String message;

    PaymentStatus(String paramString1, String paramString2) {
        this.code = paramString1;
        this.message = paramString2;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }
}
