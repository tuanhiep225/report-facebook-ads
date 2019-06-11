package mmo.facebook.ads.report.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mmo.facebook.ads.report.model.AccessToken;
import mmo.facebook.ads.report.model.User;

@Repository
public interface AccessTokenRepository extends JpaRepository<AccessToken, Long>{
	Optional<AccessToken> findByUserEmail(String email);
}
