
package com.stucho.addservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/add-service")
public class AddController {
 
 @ResponseBody
 @RequestMapping(value = "/add", method = RequestMethod.GET)
 public int pay(@RequestParam(value = "num1") int num1,
		 @RequestParam(value = "num2") int num2) {
    	 
  return num1+num2; 
 }
 
}
