/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.device;

import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import org.json.simple.JSONObject;
import org.junit.Test;

public class DeviceMapperTest {

  @Test
  public void testCreateObject() {
    final String actual;
    final HashMap<String,Object> additionalDetails = new HashMap<>();
    additionalDetails.put("name", "efficia_CM12");
    additionalDetails.put("acuity", "mid acuity");
    additionalDetails.put("screen_type", "non touch screen");
    additionalDetails.put("screen_size", "12 inch");
    additionalDetails.put("basic_features", "'3- and 5-lead ECG', 'Philips ST analysis', 'Impedance respiration', 'Philips NBP', 'Dual continuous temp'");
    additionalDetails.put("add_ons" , "'SpO2', 'Masimo SET', 'Dual IBP'");

    final JSONObject jsonObject = new JSONObject(additionalDetails);

    actual = (DeviceMapper.createObject(jsonObject, 0.75)).toString();
    final Device device = new Device("efficia_CM12","mid acuity","non touch screen","12 inch","'SpO2', 'Masimo SET', 'Dual IBP'","'3- and 5-lead ECG', 'Philips ST analysis', 'Impedance respiration', 'Philips NBP', 'Dual continuous temp'",0.75);
    final String expected = device.toString();
    assertEquals(expected , actual);
  }

}
