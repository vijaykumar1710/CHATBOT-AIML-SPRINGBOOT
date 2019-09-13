/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.customer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "USER DETAILS")
@RestController
public class CustomerController {

  @Autowired
  CustomerDAO customerDAO;

  @ApiOperation(value = "adds customer to db")
  @PostMapping(value = "/user/add")
  public Customer add(@RequestParam("username") String username, @RequestParam("contact") String contact,@RequestParam("hospital") String hospitaltype,@RequestParam("email") String email) {
    final Customer customerDetails = new Customer(username,contact,hospitaltype,email);
    customerDAO.addCustomer(customerDetails);
    return customerDetails;
  }

  @ApiOperation(value = "get customer from db by email")
  @GetMapping(value = "/user")
  public Customer getCustomerByEmail(@RequestParam("email") String email) {
    return customerDAO.getCustomer(email);
  }

  @ApiOperation(value = "get all the customers")
  @GetMapping(value="/users")
  public List<Customer> getCustomers(){
    return customerDAO.getCustomers();
  }

}

