/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.main.AddAiml;

public class AddAimlTest {

  @Test
  public void testUpdateAiml() {
    final boolean actual = AddAiml.updateAiml();
    assertEquals(true, actual);
  }


}
