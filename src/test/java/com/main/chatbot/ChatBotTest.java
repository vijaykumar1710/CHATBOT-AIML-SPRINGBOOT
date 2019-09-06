/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.chatbot;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ChatBotTest {

  @Test
  public void testGetBotReply() {
    final String expected = "I can help you in suggesting appropriate patient monitoring device as per your preferences. What type of care do you provide? <br/> Hospital tier 1<br/> Hospital tier 2<br/> Nursing Home <br/>Please type...";
    final String actual = ChatBot.getBotReply("philips products");
    assertEquals(expected, actual);
  }

  @Test
  public void testGetBotReply1() {
    final String expected = null;
    final String actual = ChatBot.getBotReply("");
    assertEquals(expected, actual);
  }

}
