/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.result;

import java.io.IOException;
import java.util.List;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.main.device.Device;
import com.main.product.ProductPreferences;
import com.main.product.ProductSuggestion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "RESULT")
@RestController
public class ResultPageController {

  @Autowired
  ProductPreferences productPreferences;

  @ApiOperation(value = "product suggested by bot")
  @GetMapping(value = "/result")
  public List<Device> submitDetails(@RequestParam("username") String username) throws IOException, ParseException{
    return ProductSuggestion.compareProduct(productPreferences.getPreferences(username));
  }

}
