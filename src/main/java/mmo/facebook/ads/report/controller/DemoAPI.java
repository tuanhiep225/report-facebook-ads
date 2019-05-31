/**
 * 
 */
package mmo.facebook.ads.report.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINodeList;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.Campaign;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



/**
 * @author Admin
 *
 */
@RestController
@RequestMapping("/report/demo")
public class DemoAPI {
	public static final APIContext context = new APIContext(
            "EAAFFPnlEU54BAOdZAT7YoSHak0BEMDr9zC3F8RijlrQ34v07R9Rvf3661Wsz2QcMgdI4rIGdGCQK4wTprzQqFZARDoVrHeRHF9s7rQzS9bNLm8HsQ5L81kJmn4fB6MzoCYiApc1ZBZBv1mWUhlQWuO0jVcxeG2ZBUNbBoeviTxgDRj3kLUz7SMkH39C1m5jALr6FmEEWs0JjqjaUovtlX",
            "1d14f0ebfd6a22ac3aa94ab91dcd1b55"
    );

	@GetMapping("/get-account-ads")
	public Object getName() throws APIException, JsonProcessingException {
		 AdAccount account = new AdAccount("1574106749485060", context);
	            APINodeList<Campaign> campaigns = account.getCampaigns().requestAllFields().execute();
	            
		return campaigns;
	}	
}
