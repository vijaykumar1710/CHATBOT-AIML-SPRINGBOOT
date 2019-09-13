/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeviceUtil {

  @Autowired
  DeviceDAO deviceDAO;

  public void util(String clientmsg,String username) {

    clientmsg = clientmsg.toLowerCase();
    addAcuity(clientmsg, username);
    updateScreenType(clientmsg, username);
    updateScreenSize(clientmsg, username);
    updateAddons(clientmsg, username);

  }

  public void addAcuity(String clientmsg,String username) {
    if(clientmsg.contains("acuity")){
      deviceDAO.addDeviceAcuity(clientmsg, username);
    }
  }

  public void updateScreenType(String clientmsg,String username) {
    if(clientmsg.contains("screen")){
      deviceDAO.addDeviceScreenType(clientmsg, username);
    }
  }

  public void updateScreenSize(String clientmsg,String username) {
    if(clientmsg.contains("inch")){
      deviceDAO.addDeviceScreenSize(clientmsg, username);
    }

  }

  public void updateAddons(String clientmsg,String username) {
    if(clientmsg.contains("addons")){
      deviceDAO.addDeviceAddons(clientmsg, username);
    }
  }

}
