/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.product;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.main.device.DeviceDAO;

@Controller
public class ProductPreferences {

  @Autowired
  DeviceDAO deviceDAO;

  public JSONObject getPreferences(String username) {
    return deviceDAO.getDeviceInfo(username);
  }

}
