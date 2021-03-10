package spring.cloud.order.util;

import java.security.Key;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil {

	@Value("${jwt.secret.key}")
	private String secretKey;
	@Value("${jwt.secret.accesstoken_timeout}")
	private String accesstokenTimeout;

	private Key key;

	@PostConstruct
	public void init() {
		this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
	}

	public Claims getAllClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
	}

	public String getUserNumber(String token) {
		return getAllClaims(token).getSubject();
	}

	public Date getExpirationDate(String token) {
		return getAllClaims(token).getExpiration();
	}

	private Boolean isTokenExpired(String token) {
		boolean invalid = false;

		final Date expiration = getExpirationDate(token);
		invalid = expiration.before(new Date());

		if (invalid) {
			throw new ExpiredJwtException(null, null, null);
		}
		return true;

	}

	public Boolean validateToken(String token) {
		return !isTokenExpired(token);
	}

}