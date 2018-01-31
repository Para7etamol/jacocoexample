
package com.stucho.addservice;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/add-service")
public class AddController {
 private final String sharedKey = "SHARED_KEY";
 private static final String SUCCESS_STATUS = "success";
 private static final String ERROR_STATUS = "error";
 private static final int CODE_SUCCESS = 100;
 private static final int AUTH_FAILURE = 102;
 
 @ResponseBody
 @RequestMapping(value = "/add", method = RequestMethod.POST)
 public int pay(@RequestParam(value = "num1") int num1,
		 @RequestParam(value = "num2") int num2) {
    	 
  return num1+num2; 
 }
 
}
