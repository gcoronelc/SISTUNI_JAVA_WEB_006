package pe.egcc.eurekaapp.model;

public class JsonModel {

  private int code;
  private String text;

  public JsonModel() {
  }

  public JsonModel(int code, String text) {
    super();
    this.code = code;
    this.text = text;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

}
