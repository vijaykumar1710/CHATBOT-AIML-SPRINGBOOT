/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.util;

import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.support.rowset.SqlRowSet;

@RunWith(MockitoJUnitRunner.class)
public class ConvertToJSONTest {

  @Mock
  private SqlRowSet sqlRowSet;

  @Test
  public void testConvertToJSON() {

    Mockito.when(sqlRowSet.next()).thenReturn(true);
    Mockito.when(sqlRowSet.getObject("ACUITY")).thenReturn("mid acuity");
    Mockito.when(sqlRowSet.getObject("SCREENTYPE")).thenReturn("touch screen");
    Mockito.when(sqlRowSet.getObject("SCREENSIZE")).thenReturn("12 inch");
    Mockito.when(sqlRowSet.getObject("ADDONS")).thenReturn("null");

    final HashMap<String, Object> obj = new HashMap<>();
    obj.put("acuity","mid acuity");
    obj.put("screen_type","touch screen");
    obj.put("screen_size","12 inch");
    obj.put("basic_features"," '3- and 5-lead ECG', 'Philips ST analysis', 'Impedance respiration', 'Philips NBP', 'Dual continuous temp'");
    obj.put("add_ons","null");

    final JSONObject expected = new JSONObject(obj);

    final JSONObject actual = ConvertToJSON.convertToJSON(sqlRowSet);
    assertEquals(expected, actual);
  }

}
