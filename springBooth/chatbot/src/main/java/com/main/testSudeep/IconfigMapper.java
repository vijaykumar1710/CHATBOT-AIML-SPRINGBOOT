/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.testSudeep;

public interface IconfigMapper {
  boolean containsKey(String parameterName);

  String get(String parameterName);
}
