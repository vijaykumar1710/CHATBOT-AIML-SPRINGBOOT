/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.device;

import org.json.simple.JSONObject;

public class DeviceMapper {

  public static Device createObject(JSONObject jsonObject,double percentage) {

    final Device device = new Device();
    device.setAcuity(jsonObject.get("acuity").toString());
    device.setProductName(jsonObject.get("name").toString());
    device.setScreenType(jsonObject.get("screen_type").toString());
    device.setScreenSize(jsonObject.get("screen_size").toString());
    device.setBasicfeatures(jsonObject.get("basic_features").toString());
    device.setAddons(jsonObject.get("add_ons").toString());
    device.setPercentage(percentage);

    return device;

  }

  private DeviceMapper() {}
}
