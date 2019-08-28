/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.chatbot;

public class Utility {

  public Boolean checkPercentage(double percentage) {

    if(percentage >= 0.75) {
      return true;
    }else {
      return false;
    }
  }

}
