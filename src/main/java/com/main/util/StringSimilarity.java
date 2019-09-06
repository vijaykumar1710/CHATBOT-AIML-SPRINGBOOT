/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.util;

import org.apache.commons.text.similarity.LevenshteinDistance;

public class StringSimilarity {

  /**
   * Calculates the similarity (a number within 0 and 1) between two strings.
   */
  public static double similarity(String s1, String s2) {
    String longer = s1;
    String shorter = s2;
    if (s1.length() < s2.length()) { // longer should always have greater length
      longer = s2; shorter = s1;
    }
    final int longerLength = longer.length();
    if (longerLength == 0) {
      return 1.0;  // both strings are zero length
    }
    final LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
    return (longerLength - levenshteinDistance.apply(longer, shorter)) / (double) longerLength;

  }

  private StringSimilarity() {}

}
