/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.chatbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {

  @Autowired
  CustomerDAO customerDAO;

  @GetMapping(value = "/user")
  public String enterChat(@RequestParam("username") String username, @RequestParam("contact") String contact,@RequestParam("hospital") String hospitaltype, Model model) {

    final CustomerDetails customerDetails = new CustomerDetails();
    customerDetails.setName(username);
    customerDetails.setContact(contact);
    customerDetails.setHospitalType(hospitaltype);

    customerDAO.addCustomer(customerDetails);


    model.addAttribute("username",username);

    return "chatpage";
  }

}
