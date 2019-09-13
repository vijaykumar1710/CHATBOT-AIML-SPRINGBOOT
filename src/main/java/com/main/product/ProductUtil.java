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

  public static boolean hasExactMatch(JSONObject jsonObject, JSONObject prefjsonObject1) {

    final String acuity = (String) prefjsonObject1.get("acuity");
    final String screenType = (String) prefjsonObject1.get("screen_type");
    final String screenSize = (String) prefjsonObject1.get("screen_size");

    return (jsonObject.get("acuity").toString().equalsIgnoreCase(acuity)
        && jsonObject.get("screen_type").toString().equalsIgnoreCase(screenType)
        && jsonObject.get("screen_size").toString().equalsIgnoreCase(screenSize));
  }

  public static boolean hasSimilarMatch(JSONObject jsonObject, JSONObject prefjsonObject1) {
    return Utility.checkPercentage(StringSimilarity.similarity(jsonObject.toString(), prefjsonObject1.toString()));
  }

  public static List<Device> check(List<Device> device,List<Device> device1){
    if (device.isEmpty()) {
      return device1;
    } else {
      return device;
    }
  }

  public static List<Device> addToList(JSONArray jsonArray, JSONObject prefjsonObject1){
    final List<Device> exactDevices = new ArrayList<>();
    final List<Device> similarDevices = new ArrayList<>();
    for (int i = 0; i < jsonArray.size(); i++) {
      final JSONObject jsonObject = (JSONObject) jsonArray.get(i);
      if(ProductUtil.hasExactMatch(jsonObject, prefjsonObject1)) {
        exactDevices.add(DeviceMapper.createObject(jsonObject,StringSimilarity.similarity(jsonObject.toString(), prefjsonObject1.toString())));
      }else if(ProductUtil.hasSimilarMatch(jsonObject, prefjsonObject1)){
        similarDevices.add(DeviceMapper.createObject(jsonObject,StringSimilarity.similarity(jsonObject.toString(), prefjsonObject1.toString())));
      }
    }
    return ProductUtil.check(exactDevices,similarDevices) ;
  }

  private ProductUtil() {}

}
