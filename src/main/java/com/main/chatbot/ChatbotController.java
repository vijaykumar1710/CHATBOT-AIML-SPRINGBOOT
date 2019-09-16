/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.chatbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.main.device.DeviceUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "CHATBOT")
@RestController
public class ChatbotController {

  @Autowired
  DeviceUtil deviceUtility;

  @ApiOperation(value = "Returns PROPER REPLY OR NEXT PAGE")
  @GetMapping(value = "/chat")
  public ChatClass getBotReply(@RequestParam("message") String clientmsg, @RequestParam("username") String username){

    final ChatClass chat = new ChatClass();
    chat.setUsername(username);
    chat.setClientmsg(clientmsg);
    chat.setBotReply(ChatBot.getBotReply(clientmsg));
    deviceUtility.util(clientmsg, username);

    return chat;
  }
}
