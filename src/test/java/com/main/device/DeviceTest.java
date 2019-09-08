/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.device;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DeviceTest {

  @Test
  public void testToString() {
    final Device device = new Device("efficia_CM10", "mid acuity", "non touch screen", "10 inch", "SpO2", "3- and 5-lead ECG", 75.5);
    final String actual = device.toString();
    final String expected = "Device [productName=efficia_CM10, acuity=mid acuity, screenType=non touch screen, screenSize=10 inch, addons=SpO2, basicfeatures=3- and 5-lead ECG, percentage=75.5]";
    assertEquals(expected, actual);
  }

  @Test
  public void testGetProductName() {
    final Device device = new Device("efficia_CM10", "mid acuity", "non touch screen", "10 inch", "SpO2", "3- and 5-lead ECG", 75.5);
    final String actual = device.getProductName();
    final String expected = "efficia_CM10";
    assertEquals(expected, actual);
  }

  @Test
  public void testSetProductName() {
    final Device device = new Device();
    device.setProductName("efficia_CM10");
    final String expected = "efficia_CM10";
    final String actual = device.getProductName();
    assertEquals(expected, actual);
  }

  @Test
  public void testGetPercentage() {
    final Device device = new Device("efficia_CM10", "mid acuity", "non touch screen", "10 inch", "SpO2", "3- and 5-lead ECG", 75.5);
    final double actual = device.getPercentage();
    final double expected = 75.5;
    assertEquals(expected, actual,0);
  }

  @Test
  public void testSetPercentage() {
    final Device device = new Device();
    device.setPercentage(75.5);
    final double expected = 75.5;
    final double actual = device.getPercentage();
    assertEquals(expected, actual,0);
  }

  @Test
  public void testGetBasicfeatures() {
    final Device device = new Device("efficia_CM10", "mid acuity", "non touch screen", "10 inch", "SpO2", "3- and 5-lead ECG", 75.5);
    final String actual = device.getBasicfeatures();
    final String expected = "3- and 5-lead ECG";
    assertEquals(expected, actual);
  }

  @Test
  public void testSetBasicfeatures() {
    final Device device = new Device();
    device.setBasicfeatures("3- and 5-lead ECG");
    final String expected = "3- and 5-lead ECG";
    final String actual = device.getBasicfeatures();
    assertEquals(expected, actual);
  }

  @Test
  public void testGetAcuity() {
    final Device device = new Device("efficia_CM10", "mid acuity", "non touch screen", "10 inch", "SpO2", "3- and 5-lead ECG", 75.5);
    final String actual = device.getAcuity();
    final String expected = "mid acuity";
    assertEquals(expected, actual);
  }

  @Test
  public void testSetAcuity() {
    final Device device = new Device();
    device.setAcuity("mid acuity");
    final String expected = "mid acuity";
    final String actual = device.getAcuity();
    assertEquals(expected, actual);
  }

  @Test
  public void testGetScreenType() {
    final Device device = new Device("efficia_CM10", "mid acuity", "non touch screen", "10 inch", "SpO2", "3- and 5-lead ECG", 75.5);
    final String actual = device.getScreenType();
    final String expected = "non touch screen";
    assertEquals(expected, actual);
  }

  @Test
  public void testSetScreenType() {
    final Device device = new Device();
    device.setScreenType("non touch screen");
    final String expected = "non touch screen";
    final String actual = device.getScreenType();
    assertEquals(expected, actual);
  }

  @Test
  public void testGetScreenSize() {
    final Device device = new Device("efficia_CM10", "mid acuity", "non touch screen", "10 inch", "SpO2", "3- and 5-lead ECG", 75.5);
    final String actual = device.getScreenSize();
    final String expected = "10 inch";
    assertEquals(expected, actual);
  }

  @Test
  public void testSetScreenSize() {
    final Device device = new Device();
    device.setScreenSize("10 inch");
    final String expected = "10 inch";
    final String actual = device.getScreenSize();
    assertEquals(expected, actual);
  }

  @Test
  public void testGetAddons() {
    final Device device = new Device("efficia_CM10", "mid acuity", "non touch screen", "10 inch", "SpO2", "3- and 5-lead ECG", 75.5);
    final String actual = device.getAddons();
    final String expected = "SpO2";
    assertEquals(expected, actual);
  }

  @Test
  public void testSetAddons() {
    final Device device = new Device();
    device.setAddons("SpO2");
    final String expected = "SpO2";
    final String actual = device.getAddons();
    assertEquals(expected, actual);
  }

}
