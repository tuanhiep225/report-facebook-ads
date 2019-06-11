package mmo.facebook.ads.report.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINodeList;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.Page;

import mmo.facebook.ads.report.exception.ResourceNotFoundException;
import mmo.facebook.ads.report.model.User;
import mmo.facebook.ads.report.repository.UserRepository;
import mmo.facebook.ads.report.security.CurrentUser;
import mmo.facebook.ads.report.security.UserPrincipal;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
   // @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
    
    @GetMapping("/user/account-ads")
    public Object loadAccoutAds (@CurrentUser UserPrincipal userPrincipal) throws APIException {
    	User currentUser = userRepository.findById(userPrincipal.getId())
        .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    	APIContext context = new APIContext(currentUser.getAccessToken().getTokenValue());
    	APINodeList<AdAccount> user = new com.facebook.ads.sdk.User("me", context).getAdAccounts().requestField("name").requestField("balance").execute();
    	return user.getRawResponse();
    }
}
