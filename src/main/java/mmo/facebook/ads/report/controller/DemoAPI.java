/**
 * 
 */
package mmo.facebook.ads.report.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.User;
import com.restfb.types.ads.AdAccount;
import com.restfb.types.ads.Business;
import com.restfb.types.ads.Campaign;

/**
 * @author Admin
 *
 */
@RestController
@RequestMapping("/report/demo")
public class DemoAPI {
	final String MY_ACCESS_TOKEN = "EAAGNO4a7r2wBAHMJdOVyjROdVNSTe5lH5INaq7r1GfFO2IUwZBDtbDgbN5tnaw5mZCinzzcgxnMWu0e74RwbBhCx7fdsILbOPKn9ZBD1LdAzsuHisqWU6zxmttZC0eX6WyLkYNNGY6Dw6u3bqenGVejwxIsUgSt1NiV4Myf3xQZDZD\r\n" + "";
	@GetMapping("/get-account-ads")
	public List<AdAccount> getName() {
		 List<AdAccount> adAccounts = new ArrayList<>();
		FacebookClient facebookClient = new DefaultFacebookClient(MY_ACCESS_TOKEN, Version.VERSION_3_1);
		 Connection<AdAccount> connAdAccount = facebookClient.fetchConnection("me/adaccounts", AdAccount.class);
	        for (List<AdAccount> adAccountList : connAdAccount) {
	            adAccounts.addAll(adAccountList);
	        }
	        return adAccounts;
	}
}
