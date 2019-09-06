/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.device;

public class Device {
  String productName;
  String acuity;
  String screenType;
  String screenSize;
  String addons;
  String basicfeatures;
  double percentage;



  @Override
  public String toString() {
    return "Device [productName=" + productName + ", acuity=" + acuity + ", screenType="
        + screenType + ", screenSize=" + screenSize + ", addons=" + addons + ", basicfeatures="
        + basicfeatures + ", percentage=" + percentage + "]";
  }

  public Device( String productName, String acuity, String screenType,
      String screenSize, String addons, String basicfeatures, double percentage) {
    super();
    this.productName = productName;
    this.acuity = acuity;
    this.screenType = screenType;
    this.screenSize = screenSize;
    this.addons = addons;
    this.basicfeatures = basicfeatures;
    this.percentage = percentage;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }



  public Device() {

  }

  public double getPercentage() {
    return percentage;
  }
  public void setPercentage(double percentage) {
    this.percentage = percentage;
  }
  public String getBasicfeatures() {
    return basicfeatures;
  }
  public void setBasicfeatures(String basicfeatures) {
    this.basicfeatures = basicfeatures;
  }

  public String getAcuity() {
    return acuity;
  }
  public void setAcuity(String acuity) {
    this.acuity = acuity;
  }
  public String getScreenType() {
    return screenType;
  }
  public void setScreenType(String screenType) {
    this.screenType = screenType;
  }
  public String getScreenSize() {
    return screenSize;
  }
  public void setScreenSize(String screenSize) {
    this.screenSize = screenSize;
  }
  public String getAddons() {
    return addons;
  }
  public void setAddons(String addons) {
    this.addons = addons;
  }

}
