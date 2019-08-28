/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main;

import java.io.File;
import org.alicebot.ab.Bot;
import org.alicebot.ab.MagicBooleans;

public class AddAiml {

  private static final boolean TRACE_MODE = false;
  static final String botName = "super";

  public static void main(String[] args) {
    try {

      final String resourcesPath = getResourcesPath();
      System.out.println(resourcesPath);
      MagicBooleans.trace_mode = TRACE_MODE;
      final Bot bot = new Bot("super", resourcesPath);

      bot.writeAIMLFiles();

    } catch (final Exception e) {
      e.printStackTrace();
    }
  }

  private static final String getResourcesPath() {
    final File currDir = new File(".");
    String path = currDir.getAbsolutePath();
    path = path.substring(0, path.length() - 2);
    System.out.println(path);
    final String resourcesPath = path + File.separator + "src" + File.separator + "main" + File.separator + "resources";
    return resourcesPath;
  }
}

