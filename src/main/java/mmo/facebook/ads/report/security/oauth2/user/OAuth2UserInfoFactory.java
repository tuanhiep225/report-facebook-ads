package mmo.facebook.ads.report.security.oauth2.user;

import java.util.Map;

import org.springframework.security.oauth2.core.OAuth2AccessToken;

import mmo.facebook.ads.report.exception.OAuth2AuthenticationProcessingException;
import mmo.facebook.ads.report.model.AuthProvider;

public class OAuth2UserInfoFactory {
	public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes,
			OAuth2AccessToken accessToken) {
		if(registrationId.equalsIgnoreCase(AuthProvider.google.toString())) {
            return new GoogleOAuth2UserInfo(attributes, accessToken);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.facebook.toString())) {
            return new FacebookOAuth2UserInfo(attributes, accessToken);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.github.toString())) {
            return new GithubOAuth2UserInfo(attributes, accessToken);
        } else {
            throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
	}
}
