/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.device;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import com.main.util.ConvertToJSON;

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

  public JSONObject getDeviceInfo(String username) {
    final SqlRowSet requirement = jdbcTemplate.queryForRowSet("select * from deviceinfo where username= ?", username);
    return ConvertToJSON.convertToJSON(requirement);
  }

  public SqlRowSet getDevice(String username) {
    return jdbcTemplate.queryForRowSet("select * from deviceinfo where username=?",username);
  }

}
