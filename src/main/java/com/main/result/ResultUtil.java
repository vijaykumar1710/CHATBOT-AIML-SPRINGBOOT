/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.result;

import java.io.IOException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.main.customer.CustomerDAO;
import com.main.device.DeviceDAO;

@Component
public class ResultUtil {

  @Autowired
  DeviceDAO deviceDAO;

  @Autowired
  CustomerDAO customerDAO;

  public void deleteFromDB(String username,String msg) throws IOException {

    final JSONObject jsonObject = deviceDAO.getDeviceInfo(username);
    deviceDAO.deleteDeviceRowSet(username);
    customerDAO.deleteCustomerRowSet(username);
    DetailsToSalesPeople.addDetailsToCSV(username,msg,jsonObject);
  }
}
