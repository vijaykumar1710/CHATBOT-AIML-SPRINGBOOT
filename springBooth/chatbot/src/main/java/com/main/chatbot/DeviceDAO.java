/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.chatbot;

import java.sql.SQLException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class DeviceDAO {

  @Autowired
  JdbcTemplate jdbcTemplate;

  public void addDeviceAcuity(String acuity,String username) {

    jdbcTemplate.update("insert into deviceinfo values(?,?,?,?,?)",username,acuity,null,null,null);
  }

  public void addDeviceScreenType(String screenType,String username) {
    jdbcTemplate.update("UPDATE deviceinfo SET SCREENTYPE = ? where username = ?",screenType,username);
  }

  public void addDeviceScreenSize(String screenSize,String username) {
    jdbcTemplate.update("UPDATE deviceinfo SET SCREENSIZE = ? where username = ?",screenSize,username);
  }

  public void addDeviceAddons(String addons,String username) {
    jdbcTemplate.update("UPDATE deviceinfo SET ADDONS = ? where username = ?", addons,username);
  }

  public JSONObject getDeviceInfo(String username) throws SQLException {
    final SqlRowSet requirement = jdbcTemplate.queryForRowSet("select * from deviceinfo where username= ?", username);
    final ConvertToJSON convert = new ConvertToJSON();
    return convert.convertToJSON(requirement);
  }

  public Device createObject(JSONObject jsonObject,double percentage) {

    final Device device = new Device();
    device.setAcuity(jsonObject.get("acuity").toString());
    device.setProductName(jsonObject.get("name").toString());
    device.setScreenType(jsonObject.get("screen_type").toString());
    device.setScreenSize(jsonObject.get("screen_size").toString());
    device.setBasicfeatures(jsonObject.get("basic_features").toString());
    device.setAddons(jsonObject.get("add_ons").toString());
    device.setPercentage(percentage);

    return device;

  }

}
