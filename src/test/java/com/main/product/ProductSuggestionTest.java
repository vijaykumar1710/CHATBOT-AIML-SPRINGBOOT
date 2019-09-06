/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.product;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.HashMap;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;

public class ProductSuggestionTest {

  @Test
  public void testCompareProduct() throws IOException, ParseException {
    final String expected ="[Device [productName=efficia_CM12, acuity=mid acuity, screenType=non touch screen, screenSize=12 inch, addons=[\"SpO2\",\"Masimo SET\",\"Dual IBP\"], basicfeatures=[\"3- and 5-lead ECG\",\"Philips ST analysis\",\"Impedance respiration\",\"Philips NBP\",\"Dual continuous temp\"], percentage=0.50187265917603]]";
    final HashMap<String, Object> additionalDetails = new HashMap<>();
    additionalDetails.put("acuity", "mid acuity");
    additionalDetails.put("screen_type", "non touch screen");
    additionalDetails.put("screen_size", "12 inch");
    additionalDetails.put("basic_features","'3- and 5-lead ECG', 'Philips ST analysis', 'Impedance respiration', 'Philips NBP', 'Dual continuous temp'");
    additionalDetails.put("add_ons", "'SpO2', 'Masimo SET', 'Dual IBP'");

    final JSONObject jsonObject = new JSONObject(additionalDetails);
    final String actual = ProductSuggestion.compareProduct(jsonObject).toString();
    assertEquals(expected, actual);
  }

  @Test
  public void testCompareProduct_notexactmatch() throws IOException, ParseException {
    final String expected ="[Device [productName=IntelliVue_MX500, acuity=high acuity, screenType=touch screen, screenSize=12 inch, addons=[\"SpO2\",\"Masimo SET\",\"Dual IBP\",\"etCO2 Oridion\",\"etCO2 Respironics\",\"12-lead ECG\"], basicfeatures=[\"3- and 5-lead ECG\",\"Philips ST analysis\",\"Impedance respiration\",\"Philips NBP\",\"Dual continuous temp\"], percentage=0.8354037267080745], Device [productName=IntelliVue_MX700, acuity=high acuity, screenType=touch screen, screenSize=15 inch, addons=[\"SpO2\",\"Masimo SET\",\"Dual IBP\",\"etCO2 Oridion\",\"etCO2 Respironics\",\"12-lead ECG\"], basicfeatures=[\"3- and 5-lead ECG\",\"Philips ST analysis\",\"Impedance respiration\",\"Philips NBP\",\"Dual continuous temp\"], percentage=0.8322981366459627], Device [productName=IntelliVue_MX800, acuity=high acuity, screenType=touch screen, screenSize=15 inch, addons=[\"SpO2\",\"Masimo SET\",\"Dual IBP\",\"etCO2 Oridion\",\"etCO2 Respironics\",\"12-lead ECG\",\"Cardiac output\"], basicfeatures=[\"3- and 5-lead ECG\",\"Philips ST analysis\",\"Impedance respiration\",\"Philips NBP\",\"Dual continuous temp\"], percentage=0.7910447761194029]]";
    final HashMap<String, Object> additionalDetails = new HashMap<>();
    additionalDetails.put("name","efficia");
    additionalDetails.put("acuity", "high acuity");
    additionalDetails.put("screen_type", "non touch screen");
    additionalDetails.put("screen_size", "12 inch");
    additionalDetails.put("basic_features","'3- and 5-lead ECG', 'Philips ST analysis', 'Impedance respiration', 'Philips NBP', 'Dual continuous temp'");
    additionalDetails.put("add_ons", "'SpO2', 'Masimo SET', 'Dual IBP', 'etCO2 Oridion', 'etCO2 Respironics', '12-lead ECG'");

    final JSONObject jsonObject = new JSONObject(additionalDetails);
    final String actual = ProductSuggestion.compareProduct(jsonObject).toString();
    assertEquals(expected, actual);
  }

}
