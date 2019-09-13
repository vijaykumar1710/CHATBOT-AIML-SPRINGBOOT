/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main;

import org.alicebot.ab.Bot;
import com.main.util.ResourcePath;

public class AddAiml {

  static final String BOTNAME = "super";

  public static boolean updateAiml() {

    final String resourcesPath = ResourcePath.getResourcesPath();
    final Bot bot = new Bot(BOTNAME, resourcesPath);
    bot.writeAIMLFiles();
    return true;
  }

  public static void main(String[] args) {
    updateAiml();
  }


}

