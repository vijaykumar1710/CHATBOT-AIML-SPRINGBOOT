/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.chatbot;

import static com.jayway.restassured.RestAssured.given;
import org.junit.Test;

public class ChatBotControllerTest {

  @Test
  public void testGetBotReply() {
    given().when().get("http://localhost:8085/chat?username=vijay&message=hi").then().statusCode(200);
  }

}
