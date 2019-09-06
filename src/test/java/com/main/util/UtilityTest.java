/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UtilityTest {

  @Test
  public void testCheckPercentage() {
    final Boolean actual = Utility.checkPercentage(0.70);
    final Boolean expected = false;
    assertEquals(expected, actual);
  }

  @Test
  public void testCheckPercentage1() {
    final Boolean actual = Utility.checkPercentage(0.80);
    final Boolean expected = true;
    assertEquals(expected, actual);
  }

}
