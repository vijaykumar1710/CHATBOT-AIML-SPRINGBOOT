/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.customer;

public class CustomerDetails {

  String name;
  String contact;
  String hospitalType;


  @Override
  public String toString() {
    return "CustomerDetails [name=" + name + ", contact=" + contact + ", hospitalType="
        + hospitalType + "]";
  }


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public String getContact() {
    return contact;
  }


  public void setContact(String contact) {
    this.contact = contact;
  }


  public String getHospitalType() {
    return hospitalType;
  }


  public void setHospitalType(String hospitalType) {
    this.hospitalType = hospitalType;
  }


  public CustomerDetails(String name, String contact, String hospitalType) {
    super();
    this.name = name;
    this.contact = contact;
    this.hospitalType = hospitalType;
  }


  public CustomerDetails() {
    super();
  }

}
