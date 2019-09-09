/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.customer;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CustomerDetailsTest {

  @Test
  public void testToString() {
    final CustomerDetails customer = new CustomerDetails("Test", "9123456789", "tier 1");
    final String actual = customer.toString();
    final String expected = "CustomerDetails [name=Test, contact=9123456789, hospitalType=tier 1]";
    assertEquals(expected, actual);
  }

  @Test
  public void testGetName() {
    final CustomerDetails customer = new CustomerDetails("Test", "9123456789", "tier 1");
    final String actual = customer.getName();
    final String expected = "Test";
    assertEquals(expected, actual);
  }

  @Test
  public void testSetName() {
    final CustomerDetails customer = new CustomerDetails();
    customer.setName("Test");
    final String expected = "Test";
    final String actual = customer.getName();
    assertEquals(expected, actual);
  }

  @Test
  public void testGetContact() {
    final CustomerDetails customer = new CustomerDetails("Test", "9123456789", "tier 1");
    final String actual = customer.getContact();
    final String expected = "9123456789";
    assertEquals(expected, actual);
  }

  @Test
  public void testSetContact() {
    final CustomerDetails customer = new CustomerDetails();
    customer.setContact("9123456789");
    final String expected = "9123456789";
    final String actual = customer.getContact();
    assertEquals(expected, actual);
  }

  @Test
  public void testGetHospitalType() {
    final CustomerDetails customer = new CustomerDetails("Test", "9123456789", "tier 1");
    final String actual = customer.getHospitalType();
    final String expected = "tier 1";
    assertEquals(expected, actual);
  }

  @Test
  public void testSetHospitalType() {
    final CustomerDetails customer = new CustomerDetails();
    customer.setHospitalType("tier 1");
    final String expected = "tier 1";
    final String actual = customer.getHospitalType();
    assertEquals(expected, actual);
  }
}
