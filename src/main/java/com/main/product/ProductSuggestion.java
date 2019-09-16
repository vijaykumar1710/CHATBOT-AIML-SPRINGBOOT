/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.product;

import java.io.IOException;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import com.main.device.Device;
import com.main.util.FetchProducts;


public class ProductSuggestion {



  public static List<Device> compareProduct(JSONObject prefjsonObject1) throws IOException, ParseException{

    return ProductUtil.addToList(FetchProducts.fetch(), prefjsonObject1);

  }

  private ProductSuggestion() {}
}
