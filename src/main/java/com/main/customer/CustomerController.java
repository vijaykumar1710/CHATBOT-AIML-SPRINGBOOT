/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "USER DETAILS")
@Controller
public class CustomerController {

  @Autowired
  CustomerUtil customerUtil;

  @ApiOperation(value = "Returns NEXT PAGE")
  @GetMapping(value = "/user")
  public String enterChat(@RequestParam("username") String username, @RequestParam("contact") String contact,@RequestParam("hospital") String hospitaltype, Model model) {
    customerUtil.addToDB(username, contact, hospitaltype);
    model.addAttribute("username",username);
    return "chatpage";
  }

}
