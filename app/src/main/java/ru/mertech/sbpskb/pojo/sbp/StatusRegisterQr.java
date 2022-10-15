package ru.mertech.sbpskb.pojo.sbp;


public enum StatusRegisterQr {
  SUCCESS("SUCCESS"), ERROR("ERROR");
  
  private final String code;

  StatusRegisterQr(String paramString1) {
    this.code = paramString1;
  }
  
  public final String getCode() {
    return code;
  }
}
