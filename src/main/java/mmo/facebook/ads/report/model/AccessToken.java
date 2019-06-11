package mmo.facebook.ads.report.model;

import java.time.Instant;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken.TokenType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import mmo.facebook.ads.report.util.StringListConverter;


@Entity
@Table(name = "access_token")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
	private  String tokenValue;
    
    @Column
    @Basic
	private  Instant issuedAt;
    
    @Column
    @Basic
	private  Instant expiresAt;
	
	@Column
	@Convert(converter = StringListConverter.class)
	private  Set<String> scopes;
	
	@OneToOne
	@JoinColumn(name = "user_id", nullable = false,updatable = true, insertable = true)
	private User user;
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTokenValue() {
		return tokenValue;
	}

	public void setTokenValue(String tokenValue) {
		this.tokenValue = tokenValue;
	}

	public Instant getIssuedAt() {
		return issuedAt;
	}

	public void setIssuedAt(Instant issuedAt) {
		this.issuedAt = issuedAt;
	}

	public Instant getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Instant expiresAt) {
		this.expiresAt = expiresAt;
	}

	public Set<String> getScopes() {
		return scopes;
	}

	public void setScopes(Set<String> scopes) {
		this.scopes = scopes;
	}

	
}
