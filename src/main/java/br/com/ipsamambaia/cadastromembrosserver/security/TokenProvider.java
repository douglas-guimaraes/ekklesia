package br.com.ipsamambaia.cadastromembrosserver.security;

import br.com.ipsamambaia.cadastromembrosserver.dto.seguranca.Token;
import br.com.ipsamambaia.cadastromembrosserver.util.Loggable;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenProvider implements Loggable {

	public static final String HEADER_STRING = "Authorization";
	public static final String TOKEN_PREFIX = "Bearer";

	@Value("${jwt.expiration.time}")
	private long exprirationTime;

	@Value("${jwt.token.prefix}")
	private String tokenPrefix;

	@Value("${jwt.header.string}")
	private String headerString;

	@Value("${jwt.secret}")
	private String secret;
	
	public Token generateToken(Authentication auth) {
		String token = Jwts.builder()
			.setSubject(auth.getName())
			.setIssuedAt(new Date())
			.setExpiration(new Date(System.currentTimeMillis() + exprirationTime))
			.signWith(SignatureAlgorithm.HS512, secret)
			.compact();

		return new Token(token);
	}

	public UsernamePasswordAuthenticationToken getAuthentication(final UserDetails userDetails) {
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
	}

	public String getUsernameFromToken(String authToken) {
		return Jwts.parser()
					.setSigningKey(secret)
					.parseClaimsJws(authToken.replace(TOKEN_PREFIX, ""))
					.getBody()
					.getSubject();
	}

	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			getLogger().info("Invalid JWT signature: " + e.getMessage());
			getLogger().debug("Exception " + e.getMessage(), e);
			return false;
		}
	}
}
