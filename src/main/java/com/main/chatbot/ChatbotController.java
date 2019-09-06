/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.chatbot;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.main.device.DeviceController;
import com.main.product.ProductPreferences;
import com.main.product.ProductSuggestion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "CHATBOT")
@Controller
public class ChatbotController {

  @Autowired
  DeviceController deviceUtility;

  @Autowired
  ProductPreferences productPreferences;

  private static Logger logger =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

  @ApiOperation(value = "Returns PROPER REPLY OR NEXT PAGE")
  @GetMapping(value = "/chat")
  public String getBotReply(@RequestParam("message") String clientmsg, @RequestParam("username") String username, Model model) throws SQLException{

    if(clientmsg.contains("end") || clientmsg.contains("bye")) {
      System.exit(0);
    }else if(clientmsg.contains("ok show the product")) {
      try {

        model.addAttribute("devices",ProductSuggestion.compareProduct(productPreferences.getPreferences(username)));
        model.addAttribute("username",username);

      } catch (final FileNotFoundException e) {
        logger.log(Level.INFO,"FileNotFoundException",e);
      } catch (final IOException e) {
        logger.log(Level.INFO,"IOException",e);
      } catch (final ParseException e) {
        logger.log(Level.INFO,"ParseException",e);
      }
      return "result";
    }
    else {

      deviceUtility.util(clientmsg, username);
      model.addAttribute("respond",ChatBot.getBotReply(clientmsg));
      model.addAttribute("received",clientmsg);
      model.addAttribute("username",username);
    }

    return "chatpage";
  }
}
