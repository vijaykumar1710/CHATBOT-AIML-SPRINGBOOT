/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.chatbot;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductSuggestionController {

  @Autowired
  DeviceDAO deviceDAO;

  Utility utility = new Utility();

  private static final String PRODUCTS = "src/main/resources/products.json";
  JSONObject jsonObject = new JSONObject();
  JSONObject jsonObject1 = new JSONObject();

  public List<Device> compareProduct(String username) throws FileNotFoundException, IOException, ParseException, SQLException {

    final JSONParser parser = new JSONParser();
    final Object obj =  parser.parse(new FileReader(PRODUCTS));

    final JSONArray jsonArray = (JSONArray) obj;
    final StringSimilarity stringSimilarity = new StringSimilarity();

    final List<Device> devices = new ArrayList<>();
    final List<Device> devices1 = new ArrayList<>();


    jsonObject = deviceDAO.getDeviceInfo(username);

    final String acuity = (String) jsonObject.get("acuity");
    final String screentype = (String) jsonObject.get("screen_type");
    final String screensize = (String) jsonObject.get("screen_size");

    for(int i=0;i<jsonArray.size();i++) {
      jsonObject1 = (JSONObject) jsonArray.get(i);
      if(jsonObject1.get("acuity").toString().contains(acuity) && jsonObject1.get("screen_type").toString().equalsIgnoreCase(screentype)) {
        if(jsonObject1.get("screen_size").toString().equalsIgnoreCase(screensize)) {
          devices.add(deviceDAO.createObject(jsonObject1,stringSimilarity.similarity(jsonObject.toString(), jsonObject1.toString())));
        }
      }else {
        if(utility.checkPercentage(stringSimilarity.similarity(jsonObject.toString(), jsonObject1.toString()))) {
          devices1.add(deviceDAO.createObject(jsonObject1, stringSimilarity.similarity(jsonObject.toString(), jsonObject1.toString())));
        }
      }
    }

    if(devices.isEmpty()) {
      return devices1;
    }else {
      return devices;
    }

  }
}
