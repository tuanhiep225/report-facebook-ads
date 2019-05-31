package mmo.facebook.ads.report.payload;

public class AuthResponse {
    private String access_token;
    private String token_type = "Bearer";

    public AuthResponse(String accessToken) {
        this.access_token = accessToken;
    }

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

}
