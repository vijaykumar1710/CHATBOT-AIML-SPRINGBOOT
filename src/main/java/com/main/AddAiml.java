/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.alicebot.ab.Bot;
import com.main.util.ResourcePath;

public class AddAiml {

  static final String BOTNAME = "super";
  private static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

  public static void main(String[] args) {
    updateAiml();
  }
  public static boolean updateAiml() {
    final Bot bot = new Bot(BOTNAME, ResourcePath.getResourcesPath());
    logger.log(Level.INFO, "adding aiml successful");
    bot.writeAIMLFiles();
    return true;
  }
}

