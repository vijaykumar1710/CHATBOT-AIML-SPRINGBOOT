/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.chatbot;

import org.json.simple.JSONObject;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class ConvertToJSON {

  @SuppressWarnings("unchecked")
  public JSONObject convertToJSON(SqlRowSet requirement) {

    final JSONObject obj = new JSONObject();

    if(requirement.next()) {
      obj.put("acuity",requirement.getObject(2));
      obj.put("screen_type",requirement.getObject(3));
      obj.put("screen_size",requirement.getObject(4));
      obj.put("basic_features"," '3- and 5-lead ECG', 'Philips ST analysis', 'Impedance respiration', 'Philips NBP', 'Dual continuous temp'");
      obj.put("add_ons",requirement.getObject(5));
    }

    return obj;

  }
}
