package mmo.facebook.ads.report.security.oauth2.user;

import java.util.Map;

import org.springframework.security.oauth2.core.OAuth2AccessToken;

public class GithubOAuth2UserInfo extends OAuth2UserInfo {

    public GithubOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    public GithubOAuth2UserInfo(Map<String, Object> attributes, OAuth2AccessToken accessToken) {
    	super(attributes, accessToken);
	}

	@Override
    public String getId() {
        return ((Integer) attributes.get("id")).toString();
    }

    @Override
    public String getName() {
        return (String) attributes.get("name");
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getImageUrl() {
        return (String) attributes.get("avatar_url");
    }
}
