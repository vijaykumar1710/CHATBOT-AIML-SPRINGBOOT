/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.product;

import static org.junit.Assert.assertEquals;
import java.util.LinkedHashMap;
import org.json.simple.JSONObject;
import org.junit.Test;

public class ProductUtilTest {

  @Test
  public void testHasExactMatchforExactMatch() {
    final LinkedHashMap<String, Object> obj = new LinkedHashMap<>();
    obj.put("acuity","mid acuity");
    obj.put("screen_type","touch screen");
    obj.put("screen_size","12 inch");
    obj.put("basic_features"," '3- and 5-lead ECG', 'Philips ST analysis', 'Impedance respiration', 'Philips NBP', 'Dual continuous temp'");
    obj.put("add_ons","null");
    final JSONObject jsonObject = new JSONObject(obj);

    final LinkedHashMap<String, Object> preference = new LinkedHashMap<>();
    preference.put("acuity","mid acuity");
    preference.put("screen_type","touch screen");
    preference.put("screen_size","12 inch");
    preference.put("basic_features"," '3- and 5-lead ECG', 'Philips ST analysis', 'Impedance respiration', 'Philips NBP', 'Dual continuous temp'");
    preference.put("add_ons","SpO2");
    final JSONObject clientPref = new JSONObject(preference);
    final boolean actual = ProductUtil.hasExactMatch(jsonObject, clientPref);
    assertEquals(true, actual);
  }
  @Test
  public void testHasExactMatchforNotExactMatch() {
    final LinkedHashMap<String, Object> obj = new LinkedHashMap<>();
    obj.put("acuity","Low acuity");
    obj.put("screen_type","non touch screen");
    obj.put("screen_size","12 inch");
    obj.put("basic_features"," '3- and 5-lead ECG', 'Philips ST analysis', 'Impedance respiration', 'Philips NBP', 'Dual continuous temp'");
    obj.put("add_ons","null");
    final JSONObject jsonObject = new JSONObject(obj);

    final LinkedHashMap<String, Object> preference = new LinkedHashMap<>();
    preference.put("acuity","mid acuity");
    preference.put("screen_type","touch screen");
    preference.put("screen_size","12 inch");
    preference.put("basic_features"," '3- and 5-lead ECG', 'Philips ST analysis', 'Impedance respiration', 'Philips NBP', 'Dual continuous temp'");
    preference.put("add_ons","SpO2");
    final JSONObject clientPref = new JSONObject(preference);
    final boolean actual = ProductUtil.hasExactMatch(jsonObject, clientPref);
    assertEquals(false, actual);
  }

  @Test
  public void testHasSimilarMatch() {
    final LinkedHashMap<String, Object> obj = new LinkedHashMap<>();
    obj.put("acuity","mid acuity");
    obj.put("screen_type","touch screen");
    obj.put("screen_size","12 inch");
    obj.put("basic_features"," '3- and 5-lead ECG', 'Philips ST analysis', 'Impedance respiration', 'Philips NBP', 'Dual continuous temp'");
    obj.put("add_ons","null");
    final JSONObject jsonObject = new JSONObject(obj);

    final LinkedHashMap<String, Object> preference = new LinkedHashMap<>();
    preference.put("acuity","high acuity");
    preference.put("screen_type","touch screen");
    preference.put("screen_size","12 inch");
    preference.put("basic_features"," '3- and 5-lead ECG', 'Philips ST analysis', 'Impedance respiration', 'Philips NBP', 'Dual continuous temp'");
    preference.put("add_ons","SpO2");
    final JSONObject clientPref = new JSONObject(preference);
    final boolean actual = ProductUtil.hasSimilarMatch(jsonObject, clientPref);
    assertEquals(true, actual);
  }

}
