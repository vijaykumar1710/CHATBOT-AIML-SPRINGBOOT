/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.util;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class FetchProducts {

  private static final String PRODUCTS = "src/main/resources/products.json";

  public static JSONArray fetch() throws IOException, ParseException {

    final JSONParser parser = new JSONParser();
    final Object obj = parser.parse(new FileReader(PRODUCTS));
    return (JSONArray) obj;

  }

  private FetchProducts() {

  }
}
