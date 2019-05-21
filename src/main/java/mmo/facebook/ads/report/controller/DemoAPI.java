/**
 * 
 */
package mmo.facebook.ads.report.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINodeList;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.Campaign;
import com.facebook.ads.sdk.Page;
import com.facebook.ads.sdk.User;



/**
 * @author Admin
 *
 */
@RestController
@RequestMapping("/report/demo")
public class DemoAPI {
	public static final APIContext context = new APIContext(
            "EAAFFPnlEU54BAN2iCMAMDbt9aw9Ku9EQ5ktDDppnwBr9FbqF8MfiHyHbZANrn46t9GZBfiItgowM9ZAzP7ZBZBp7vZC0sFZA6AogbWptM34ZCe8vIAUjG0ub5HditsUvxtDtwZBunpLkZBC1fqD3nMW7AQnL5fstR3Vx4FeNQUzAsEwvpK623CZCzZC3SnFvdle4tqGX7OfUq4M3NoWdHiXOAwLT",
            "1d14f0ebfd6a22ac3aa94ab91dcd1b55"
    );
//	final String MY_ACCESS_TOKEN = "EAAFFPnlEU54BAGreyZCBfsi22yfhFC2zNbWLIGZAy8EwoKJSVEH5CAFusKTzqceJTuTdzunuzZBVO8qlE3OI6c8yZAx8xz2pI65U2eQxseycIW5HegelPxDbT1WOLIJNv1PU44W2QGZAovZCZBaEP0YHwYIdF4mTuguE7hIM83tlZBZCdt1l01sSPcR8e6hqxHbhTSA0JSqjwX80L5aGZB8w12";
	@GetMapping("/get-account-ads")
	public List<Campaign> getName() throws APIException {
		 AdAccount account = new AdAccount("1574106749485060", context);
	            APINodeList<Campaign> campaigns = account.getCampaigns().requestAllFields().execute();
		return campaigns;
	}
	

}
