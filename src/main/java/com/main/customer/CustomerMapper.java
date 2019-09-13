/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper implements RowMapper<Customer> {

  @Override
  public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
    final Customer customerDetails = new Customer();
    customerDetails.setName(rs.getString(1));
    customerDetails.setContact(rs.getString(2));
    customerDetails.setHospitalType(rs.getString(3));
    customerDetails.setEmail(rs.getString(4));
    return customerDetails;

  }
}
