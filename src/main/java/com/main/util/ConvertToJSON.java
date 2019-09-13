/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.util;

import org.json.simple.JSONObject;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class ConvertToJSON {

  public static JSONObject convertToJSON(SqlRowSet requirement) {


    final JSONObject obj = new JSONObject();

    if(requirement.next()) {
      obj.put("acuity",requirement.getObject("ACUITY"));
      obj.put("screen_type",requirement.getObject("SCREENTYPE"));
      obj.put("screen_size",requirement.getObject("SCREENSIZE"));
      obj.put("basic_features"," '3- and 5-lead ECG', 'Philips ST analysis', 'Impedance respiration', 'Philips NBP', 'Dual continuous temp'");
      obj.put("add_ons",requirement.getObject("ADDONS"));
    }

    return obj;

  }

  private ConvertToJSON() {}

}
