/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.chatbot;

import java.sql.SQLException;
import java.util.logging.Logger;
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

  private static Logger logger =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

  @ApiOperation(value = "Returns PROPER REPLY OR NEXT PAGE")
  @GetMapping(value = "/chat")
  public ChatClass getBotReply(@RequestParam("message") String clientmsg, @RequestParam("username") String username) throws SQLException{

    final ChatClass chat = new ChatClass();
    chat.setUsername(username);
    chat.setClientmsg(clientmsg);
    chat.setBotReply(ChatBot.getBotReply(clientmsg));
    deviceUtility.util(clientmsg, username);

    //    }else if(clientmsg.contains("ok show the product")) {
    //      try {
    //        //
    //        //        model.addAttribute("devices",ProductSuggestion.compareProduct(productPreferences.getPreferences(username)));
    //        //        model.addAttribute("username",username);
    //
    //      } catch (final FileNotFoundException e) {
    //        logger.log(Level.INFO,"FileNotFoundException",e);
    //      } catch (final IOException e) {
    //        logger.log(Level.INFO,"IOException",e);
    //      } catch (final ParseException e) {
    //        logger.log(Level.INFO,"ParseException",e);
    //      }
    //      return "result";
    //    }
    //    else {
    //
    //      deviceUtility.util(clientmsg, username);
    //      model.addAttribute("respond",ChatBot.getBotReply(clientmsg));
    //      model.addAttribute("received",clientmsg);
    //      model.addAttribute("username",username);
    //    }
    //
    return chat;
  }
}
