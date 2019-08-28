/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.chatbot;

import java.io.File;
import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.MagicBooleans;

public class ChatBot {

  private static final boolean TRACE_MODE = false;
  static String botName = "super";

  public String getBotReply(String clientmsg) {

    final String resourcesPath = getResourcesPath();
    MagicBooleans.trace_mode = TRACE_MODE;
    final Bot bot = new Bot("super", resourcesPath);
    final Chat chatSession = new Chat(bot);
    bot.brain.nodeStats();
    final String textLine = clientmsg;

    if (textLine.isEmpty()) {
      return null;
    } else {

      final String request = clientmsg;

      String response = chatSession.multisentenceRespond(request);
      while (response.contains("&lt;")) {
        response = response.replace("&lt;", "<");
      }
      while (response.contains("&gt;")) {
        response = response.replace("&gt;", ">");
      }
      return response;
    }
  }

  private String getResourcesPath() {
    final File currDir = new File(".");
    String path = currDir.getAbsolutePath();
    path = path.substring(0, path.length() - 2);
    final String resourcesPath = path + File.separator + "src" + File.separator + "main" + File.separator + "resources";
    return resourcesPath;
  }

}
