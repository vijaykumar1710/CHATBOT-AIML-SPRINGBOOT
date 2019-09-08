/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.product;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.main.device.Device;
import com.main.device.DeviceMapper;
import com.main.util.StringSimilarity;
import com.main.util.Utility;

public class ProductUtil {



  private ProductUtil() {}

  public static boolean hasExactMatch(JSONObject jsonObject, JSONObject clientPref) {

    final String acuity = (String) clientPref.get("acuity");
    final String screenType = (String) clientPref.get("screen_type");
    final String screenSize = (String) clientPref.get("screen_size");

    return (jsonObject.get("acuity").toString().equalsIgnoreCase(acuity)
        && jsonObject.get("screen_type").toString().equalsIgnoreCase(screenType)
        && jsonObject.get("screen_size").toString().equalsIgnoreCase(screenSize));
  }

  public static boolean hasSimilarMatch(JSONObject jsonObject1, JSONObject jsonObject) {
    return Utility.checkPercentage(
        StringSimilarity.similarity(jsonObject.toJSONString(), jsonObject1.toJSONString()));
  }

  public static List<Device> check(List<Device> exactDevice, List<Device> similarDevice) {
    if (exactDevice.isEmpty()) {
      return similarDevice;
    } else {
      return exactDevice;
    }
  }

  public static List<Device> addToList(JSONArray jsonArray, JSONObject clientPref) {
    final List<Device> exactdevices = new ArrayList<>();
    final List<Device> similardevices = new ArrayList<>();
    for (int i = 0; i < jsonArray.size(); i++) {
      final JSONObject jsonObject = (JSONObject) jsonArray.get(i);
      if (ProductUtil.hasExactMatch(jsonObject, clientPref)) {
        exactdevices.add(DeviceMapper.createObject(jsonObject,
            StringSimilarity.similarity(clientPref.toJSONString(), jsonObject.toJSONString())));
      } else if (ProductUtil.hasSimilarMatch(jsonObject, clientPref)) {
        similardevices.add(DeviceMapper.createObject(jsonObject,
            StringSimilarity.similarity(clientPref.toJSONString(), jsonObject.toJSONString())));
      }
    }
    return ProductUtil.check(exactdevices, similardevices);
  }


}
