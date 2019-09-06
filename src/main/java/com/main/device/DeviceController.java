/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DeviceController {

  @Autowired
  DeviceDAO deviceDAO;

  public void util(String clientmsg,String username) {

    clientmsg = clientmsg.toLowerCase();

    if(clientmsg.contains("acuity")){
      deviceDAO.addDeviceAcuity(clientmsg, username);
    }else if(clientmsg.contains("screen")){
      deviceDAO.addDeviceScreenType(clientmsg, username);
    }else if(clientmsg.contains("inch")){
      deviceDAO.addDeviceScreenSize(clientmsg, username);
    }else if(clientmsg.contains("addons")){
      deviceDAO.addDeviceAddons(clientmsg, username);
    }

  }

}
