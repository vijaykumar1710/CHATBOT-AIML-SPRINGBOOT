/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.chatbot;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChatbotController {

  @Autowired
  DeviceController deviceUtility;

  @Autowired
  ProductSuggestionController productSuggestion;

  @GetMapping(value = "/chat")
  public String getBotReply(@RequestParam("message") String clientmsg, @RequestParam("username") String username, Model model) throws SQLException{

    final ChatBot chatBot = new ChatBot();
    if(clientmsg.contains("end") || clientmsg.contains("bye")) {
      System.exit(0);
    }else if(clientmsg.contains("ok show the product")) {
      try {
        model.addAttribute("devices",productSuggestion.compareProduct(username));
        model.addAttribute("username",username);

      } catch (final FileNotFoundException e) {
        e.printStackTrace();
      } catch (final IOException e) {
        e.printStackTrace();
      } catch (final ParseException e) {
        e.printStackTrace();
      }
      return "result";
    }
    else {

      deviceUtility.util(clientmsg, username);
      model.addAttribute("respond",chatBot.getBotReply(clientmsg));
      model.addAttribute("received",clientmsg);
      model.addAttribute("username",username);
    }

    return "chatpage";
  }
}
