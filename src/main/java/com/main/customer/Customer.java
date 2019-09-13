/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.customer;

public class Customer {

  String name;
  String contact;
  String hospitalType;
  String email;

  @Override
  public String toString() {
    return "Customer [name=" + name + ", contact=" + contact + ", hospitalType=" + hospitalType
        + ", email=" + email + "]";
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
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public Customer(String name, String contact, String hospitalType, String email) {
    super();
    this.name = name;
    this.contact = contact;
    this.hospitalType = hospitalType;
    this.email = email;
  }
  public Customer() {
    super();
  }


}
