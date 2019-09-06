/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.util;

import java.io.File;

public class ResourcePath {

  public static final String getResourcesPath() {
    final File currDir = new File(".");
    String path = currDir.getAbsolutePath();
    path = path.substring(0, path.length() - 2);
    return path + File.separator + "src" + File.separator + "main" + File.separator + "resources";
  }

  private ResourcePath() {}
}
