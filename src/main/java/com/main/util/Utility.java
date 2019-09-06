/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.util;

public class Utility {
  private Utility() {
  }

  public static Boolean checkPercentage(double percentage) {
    return(percentage >= 0.75);
  }

}
