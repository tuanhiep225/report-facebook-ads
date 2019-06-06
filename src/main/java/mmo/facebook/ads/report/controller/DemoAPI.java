/**
 * 
 */
package mmo.facebook.ads.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.api.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINodeList;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.Campaign;
import com.fasterxml.jackson.core.JsonProcessingException;



/**
 * @author Admin
 *
 */
@RestController
@RequestMapping("/report/demo")
public class DemoAPI {
	private Facebook facebook;
    private ConnectionRepository connectionRepository;

    public DemoAPI(Facebook facebook, ConnectionRepository connectionRepository) {
        this.connectionRepository = connectionRepository;
    }

    @RequestMapping(value = "/feed", method = RequestMethod.GET)
    public String feed() {

        if(connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }

        User userProfile = facebook.userOperations().getUserProfile();
        PagedList<Post> userFeed = facebook.feedOperations().getFeed();
        return "feed";
    }
}
