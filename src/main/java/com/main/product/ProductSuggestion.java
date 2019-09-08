/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.product;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.main.device.Device;

public class ProductSuggestion {

  private static final String PRODUCTS = "src/main/resources/products.json";

  public static List<Device> compareProduct(JSONObject clientPref) throws IOException, ParseException{
    final JSONParser parser = new JSONParser();
    final Object obj = parser.parse(new FileReader(PRODUCTS));
    final JSONArray jsonArray = (JSONArray) obj;
    return ProductUtil.addToList(jsonArray, clientPref);
  }

  private ProductSuggestion() {}
}
