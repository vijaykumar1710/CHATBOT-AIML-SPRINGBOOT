/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.result;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

public class DetailsToSalesPeople {

  final static Logger logger =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


  public static void addDetailsToCSV(String name,JSONObject jsonObject) throws IOException {
    try(final FileWriter pw = new FileWriter("src/main/resources/data.csv",true)){
      pw.append(name);
      pw.append(",");
      pw.append(jsonObject.toJSONString());
      pw.append("\n");
      pw.flush();
    }catch(final IOException e) {
      logger.log(Level.WARNING, "file write not closed",e);
    }
  }

  private DetailsToSalesPeople() {}
}
