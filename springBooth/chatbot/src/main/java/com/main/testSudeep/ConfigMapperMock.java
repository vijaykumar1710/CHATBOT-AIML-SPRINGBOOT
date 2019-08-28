/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.testSudeep;

public class ConfigMapperMock implements IconfigMapper {

  @Override
  public boolean containsKey(String parameterName) {

    return false;
  }

  @Override
  public String get(String parameterName) {
    return null;
  }

}
