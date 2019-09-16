/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.chatbot;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ChatClassTest {

  @Test
  public void testGetUsername() {
    final ChatClass chatClass = new ChatClass("test", "Hi", "Hello");
    final String expected = "test";
    final String actual = chatClass.getUsername();
    assertEquals(expected, actual);
  }

  @Test
  public void testSetUsername() {
    final ChatClass chatClass = new ChatClass();
    chatClass.setUsername("test");
    final String expected = "test";
    final String actual = chatClass.getUsername();
    assertEquals(expected, actual);
  }

  @Test
  public void testGetClientmsg() {
    final ChatClass chatClass = new ChatClass("test", "Hi", "Hello");
    final String expected = "Hi";
    final String actual = chatClass.getClientmsg();
    assertEquals(expected, actual);
  }

  @Test
  public void testSetClientmsg() {
    final ChatClass chatClass = new ChatClass();
    chatClass.setClientmsg("Hi");
    final String expected = "Hi";
    final String actual = chatClass.getClientmsg();
    assertEquals(expected, actual);
  }

  @Test
  public void testGetBotReply() {
    final ChatClass chatClass = new ChatClass("test", "Hi", "Hello");
    final String expected = "Hello";
    final String actual = chatClass.getBotReply();
    assertEquals(expected, actual);
  }

  @Test
  public void testSetBotReply() {
    final ChatClass chatClass = new ChatClass();
    chatClass.setBotReply("Hello");
    final String expected = "Hello";
    final String actual = chatClass.getBotReply();
    assertEquals(expected, actual);
  }

}
