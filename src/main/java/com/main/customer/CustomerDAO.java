/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class CustomerDAO {

  @Autowired
  JdbcTemplate jdbcTemplate;

  public void addCustomer(CustomerDetails customerDetails) {
    jdbcTemplate.update("insert into client values(?,?,?)",customerDetails.getName(),customerDetails.getContact(),customerDetails.getHospitalType());
  }

  public SqlRowSet getCustomer(String username) {
    return jdbcTemplate.queryForRowSet("select * from client where username=?",username);
  }

  public void deleteCustomerRowSet(String username) {
    jdbcTemplate.update("delete from client where username=?",username);
  }

}
