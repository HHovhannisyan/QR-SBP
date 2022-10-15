package ru.mertech.sbpskb.pojo.sbp;



public enum QrType {
  QR_STATIC("QRStatic"), QR_DYNAMIC("QRDynamic");
  
  private final String code;
  
  QrType(String paramString1) {
    this.code = paramString1;
  }
  
  public final String getCode() {
    return this.code;
  }
}
