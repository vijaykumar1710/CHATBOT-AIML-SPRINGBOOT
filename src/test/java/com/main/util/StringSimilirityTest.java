/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringSimilirityTest {

  @Test
  public void testSimilarity_EqualString() {
    final double actual = StringSimilarity.similarity("string test", "string test");
    final double expected = 1.0;
    assertEquals(expected, actual,0.0);
  }
  @Test
  public void testSimilarity_EmptyString() {
    final double actual = StringSimilarity.similarity("","");
    final double expected = 1.0;
    assertEquals(expected, actual,0.0);
  }
  @Test
  public void testSimilarity_NonEqualString1() {
    final double actual = StringSimilarity.similarity("Test","Test1");
    final double expected = 0.8;
    assertEquals(expected, actual,0.0);
  }
  @Test
  public void testSimilarity_NonEqualString2() {
    final double actual = StringSimilarity.similarity("Test1","Test");
    final double expected = 0.8;
    assertEquals(expected, actual,0.0);
  }

}
