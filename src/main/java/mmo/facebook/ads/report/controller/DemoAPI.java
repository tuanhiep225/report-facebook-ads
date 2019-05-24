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
            "EAAFFPnlEU54BADA8aaSPxc7OVpU5bOeC0WZBVpVCPnmFZCtRp1ubZAvVLCQdp7RKTUMEZABeQwDQZCjCJJeopxMyVjx8ECtwQRqZCgc1MstkrHaVrLG8pC4judfQiRv5AR7R9lZAOhFm1VdyLajYBvEQjWHRCu5tpX4lBKgwfoghZAeunoA3MjKbj4FrNPenUHy6jKuh33Yg27TVMgvTd615",
            "1d14f0ebfd6a22ac3aa94ab91dcd1b55"
    );

	@GetMapping("/get-account-ads")
	public Object getName() throws APIException, JsonProcessingException {
		 AdAccount account = new AdAccount("1574106749485060", context);
	            APINodeList<Campaign> campaigns = account.getCampaigns().requestAllFields().execute();
//	            for(Campaign a: campaigns) {
//	            	
//	            }
	            Campaign a = campaigns.get(0);
	            a.getRawResponseAsJsonObject();
	    		List<Campaign> list = campaigns.stream().collect(Collectors.toList());
	    		
	    		ObjectMapper objectMapper = new ObjectMapper();
				objectMapper.setSerializationInclusion(Include.NON_NULL);
				objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);


	    		// Java object to JSON string
	    		String jsonString = objectMapper.writeValueAsString(a);
		return list.get(0);
	}
	
	@GetMapping("/test")
	public Object test() {
		String name ="{\r\n" + 
				"  \"account_id\": \"1574106749485060\",\r\n" + 
				"  \"budget_rebalance_flag\": false,\r\n" + 
				"  \"budget_remaining\": \"0\",\r\n" + 
				"  \"buying_type\": \"AUCTION\",\r\n" + 
				"  \"can_create_brand_lift_study\": false,\r\n" + 
				"  \"can_use_spend_cap\": true,\r\n" + 
				"  \"configured_status\": \"ACTIVE\",\r\n" + 
				"  \"created_time\": \"2019-05-17T16:50:44+0700\",\r\n" + 
				"  \"effective_status\": \"ACTIVE\",\r\n" + 
				"  \"id\": \"23843557155990563\",\r\n" + 
				"  \"name\": \"ABR -> Đạo mèo -> Thích trang\",\r\n" + 
				"  \"objective\": \"PAGE_LIKES\",\r\n" + 
				"  \"source_campaign_id\": \"0\",\r\n" + 
				"  \"start_time\": \"2019-05-17T16:50:45+0700\",\r\n" + 
				"  \"status\": \"ACTIVE\",\r\n" + 
				"  \"topline_id\": \"0\",\r\n" + 
				"  \"updated_time\": \"2019-05-17T16:50:44+0700\"\r\n" + 
				"}";
		Gson gson = new Gson();
		Campaign camp = gson.fromJson(name, Campaign.class);
		return camp;
	}
	
	
	

}
