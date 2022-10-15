package ru.mertech.sbpskb.pojo.sbp;

public enum RefundStatus {
  RECEIVED("RCVD", "Операция в обработке"),ACCEPTED("ACWP", "Операция завершена успешно"),  REJECTED("RJCT", "Операция отклонена");

  private final String code;

  private final String message;

  RefundStatus(String paramString1, String paramString2) {
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

