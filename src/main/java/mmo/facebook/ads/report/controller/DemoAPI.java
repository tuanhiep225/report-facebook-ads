/**
 * 
 */
package mmo.facebook.ads.report.controller;

import org.springframework.social.facebook.connect.FacebookAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.User;

/**
 * @author Admin
 *
 */
@RestController
@RequestMapping("/report/demo")
public class DemoAPI {
	final String MY_ACCESS_TOKEN = "EAACtyQLitBYBAJzCeMABmqM91ZCvnShRnxaZAZAcxICbsGffQZBeGuNdMgKafLwyIYZBSLQAau8KpADCrPC6eTds83kpwMTSQBZC1jm826FfUcWx9CZBtO6jLktpiDzHWIePJpq5OynRe5NZCpaIsDXEfDRGKjaZBVLJnbx5BvpMjtLrdZAluqsGXJMAE6bxZCURZCt3bWNJFE2QLXDEc9MGEV0x";
	@GetMapping("/get-name")
	public User getName() {
		FacebookClient facebookClient = new DefaultFacebookClient(MY_ACCESS_TOKEN, Version.VERSION_3_1);
		 User user = facebookClient.fetchObject("me", User.class);
         
	        System.out.println("User="+ user);
	        System.out.println("UserName= "+ user.getUsername());
	        System.out.println("Birthday= "+ user.getBirthday());
	        return user;
	}
}
