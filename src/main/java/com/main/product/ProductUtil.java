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

  final static List<Device> exact_devices = new ArrayList<>();
  final static List<Device> similar_devices = new ArrayList<>();

  public static boolean hasExactMatch(JSONObject jsonObject, JSONObject jsonObject1) {

    final String acuity = (String) jsonObject1.get("acuity");
    final String screenType = (String) jsonObject1.get("screen_type");
    final String screenSize = (String) jsonObject1.get("screen_size");

    return (jsonObject.get("acuity").toString().equalsIgnoreCase(acuity)
        && jsonObject.get("screen_type").toString().equalsIgnoreCase(screenType)
        && jsonObject.get("screen_size").toString().equalsIgnoreCase(screenSize));
  }

  public static boolean hasSimilarMatch(JSONObject jsonObject, JSONObject jsonObject1) {
    return Utility.checkPercentage(StringSimilarity.similarity(jsonObject.toString(), jsonObject1.toString()));
  }

  public static List<Device> check(List<Device> device,List<Device> device1){
    if (device.isEmpty()) {
      return device1;
    } else {
      return device;
    }
  }

  public static List<Device> addToList(JSONArray jsonArray, JSONObject jsonObject1){
    for (int i = 0; i < jsonArray.size(); i++) {
      final JSONObject jsonObject = (JSONObject) jsonArray.get(i);
      if(ProductUtil.hasExactMatch(jsonObject, jsonObject1)) {
        exact_devices.add(DeviceMapper.createObject(jsonObject,StringSimilarity.similarity(jsonObject.toString(), jsonObject1.toString())));
      }else if(ProductUtil.hasSimilarMatch(jsonObject, jsonObject1)){
        similar_devices.add(DeviceMapper.createObject(jsonObject,StringSimilarity.similarity(jsonObject.toString(), jsonObject1.toString())));
      }
    }
    return ProductUtil.check(exact_devices,similar_devices) ;
  }

  private ProductUtil() {}

}
