/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.result;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "RESULT")
@Controller
public class ResultPageController {

  @Autowired
  ResultUtil resultUtil;

  @ApiOperation(value = "Returns NEXT PAGE")
  @GetMapping(value = "/result")
  public String submitDetails(@RequestParam("username") String username, @RequestParam("msg") String comment) throws IOException{
    resultUtil.deleteFromDB(username, comment);
    return "user";
  }
}
