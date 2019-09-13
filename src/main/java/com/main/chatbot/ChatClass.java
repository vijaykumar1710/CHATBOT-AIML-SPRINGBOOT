/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.chatbot;

public class ChatClass {
  String username;
  String clientmsg;
  String botReply;
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getClientmsg() {
    return clientmsg;
  }
  public void setClientmsg(String clientmsg) {
    this.clientmsg = clientmsg;
  }
  public String getBotReply() {
    return botReply;
  }
  public void setBotReply(String botReply) {
    this.botReply = botReply;
  }
  public ChatClass(String username, String clientmsg, String botReply) {
    super();
    this.username = username;
    this.clientmsg = clientmsg;
    this.botReply = botReply;
  }
  public ChatClass() {
    super();
  }


}
