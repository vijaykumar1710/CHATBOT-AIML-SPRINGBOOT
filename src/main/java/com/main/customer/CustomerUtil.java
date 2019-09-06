/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerUtil {

  @Autowired
  CustomerDAO customerDAO;

  public void addToDB(String username,String contact, String hospitaltype) {
    final CustomerDetails customerDetails = new CustomerDetails(username,contact,hospitaltype);
    customerDAO.addCustomer(customerDetails);
  }
}
