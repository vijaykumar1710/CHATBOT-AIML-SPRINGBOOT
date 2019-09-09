/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.automation;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.main.Application;

@SpringBootApplication
public class UIAutomationTest {


  @Before
  public void startApp() {
    SpringApplication.run(Application.class);
  }
  @Test
  public void test() {
    final String actual = WebAuto.automate("tier1", "mid acuity", "touch screen", "12 inch", "SpO2");
    final String expected = "efficia_CM120";
    assertEquals(expected, actual);

  }




}
