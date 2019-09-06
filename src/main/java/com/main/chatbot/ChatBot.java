/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.chatbot;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import com.main.util.ResourcePath;

public class ChatBot {

  static String botName = "super";

  public static String getBotReply(String clientmsg) {

    final String resourcesPath = ResourcePath.getResourcesPath();
    final Bot bot = new Bot("super", resourcesPath);
    final Chat chatSession = new Chat(bot);
    bot.brain.nodeStats();
    final String textLine = clientmsg;

    if (textLine.isEmpty()) {
      return null;
    } else {
      final String request = clientmsg;
      return chatSession.multisentenceRespond(request);

    }
  }

  private ChatBot() {}

}
