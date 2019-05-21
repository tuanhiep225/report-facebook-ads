/**
 * 
 */
package mmo.facebook.ads.report.controller;

import org.springframework.social.facebook.connect.FacebookAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Admin
 *
 */
@RestController
@RequestMapping("/report/demo")
public class DemoAPI {
	@GetMapping("/get-name")
	public String getName() {
		return "Hello";
	}
}
