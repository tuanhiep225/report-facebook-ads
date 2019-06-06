package mmo.facebook.ads.report.security.oauth2.user;

import java.util.Map;

import org.springframework.security.oauth2.core.OAuth2AccessToken;

public abstract class OAuth2UserInfo {
    protected Map<String, Object> attributes;
    protected OAuth2AccessToken accessToken;
    
    public OAuth2UserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public OAuth2UserInfo(Map<String, Object> attributes, OAuth2AccessToken accessToken) {
    	 this.attributes = attributes;
    	 this.accessToken = accessToken;
	}

	public Map<String, Object> getAttributes() {
        return attributes;
    }

    public abstract String getId();

    public abstract String getName();

    public abstract String getEmail();

    public abstract String getImageUrl();
    
    public OAuth2AccessToken getAccessToken() {
    	return accessToken;
    }
}
