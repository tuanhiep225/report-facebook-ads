package mmo.facebook.ads.report.controller;


import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINodeList;
import com.facebook.ads.sdk.AdAccount;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import mmo.facebook.ads.report.exception.ResourceNotFoundException;
import mmo.facebook.ads.report.model.User;
import mmo.facebook.ads.report.repository.UserRepository;
import mmo.facebook.ads.report.security.CurrentUser;
import mmo.facebook.ads.report.security.UserPrincipal;
import net.minidev.json.parser.ParseException;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ObjectMapper mapper;

    @GetMapping("/user/me")
   // @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
    
    @GetMapping("/user/account-ads")
    public Object loadAccoutAds (@CurrentUser UserPrincipal userPrincipal) throws APIException, ParseException, JsonParseException, JsonMappingException, IOException {
    	User currentUser = userRepository.findById(userPrincipal.getId())
        .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    	APIContext context = new APIContext(currentUser.getAccessToken().getTokenValue());
    	APINodeList<AdAccount> user = new com.facebook.ads.sdk.User("me", context).getAdAccounts().requestField("name").requestField("balance").execute();

    		Gson gson = new Gson();
    		List<AdAccount> adAccounts = gson.fromJson(user.getRawResponseAsJsonObject().get("data"), new TypeToken<Collection<AdAccount>>(){}.getType());
    	return adAccounts;
    }
}
