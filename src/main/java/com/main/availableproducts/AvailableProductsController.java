/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.availableproducts;

import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.main.result.DetailsToSalesPeople;
import com.main.util.FetchProducts;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Available Products")
@RestController
public class AvailableProductsController {


  @ApiOperation(value = "Returns all the available products")
  @GetMapping(value="/products")
  public JSONArray getAllProducts() throws IOException, ParseException{
    return FetchProducts.fetch();
  }

  @ApiOperation(value = "add product to user preference csv file")
  @GetMapping(value="/product")
  public JSONObject takeProduct(@RequestParam("username") String username, @RequestParam("productName") String productName) throws IOException, ParseException{

    final JSONArray jsonArray = FetchProducts.fetch();

    JSONObject jsonObject = null;

    for(int i=0;i<jsonArray.size();i++) {
      jsonObject = (JSONObject) jsonArray.get(i);
      if(jsonObject.get("name").toString().equalsIgnoreCase(productName)) {
        DetailsToSalesPeople.addDetailsToCSV(username,jsonObject);
        break;
      }
    }
    return jsonObject;
  }
}
