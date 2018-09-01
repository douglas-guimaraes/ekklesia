package br.com.ipsamambaia.cadastromembrosserver.security;

import br.com.ipsamambaia.cadastromembrosserver.util.Loggable;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Stream;

import static br.com.ipsamambaia.cadastromembrosserver.security.TokenProvider.HEADER_STRING;
import static br.com.ipsamambaia.cadastromembrosserver.security.TokenProvider.TOKEN_PREFIX;

public class JWTAuthenticationFilter extends OncePerRequestFilter implements Loggable {

    private static final PathMatcher pathMatcher = new AntPathMatcher();

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private TokenProvider tokenProvider;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return Stream.of(WebSecurityConfig.EXCLUDED_PATTERNS)
                .anyMatch(p -> pathMatcher.match(p, request.getServletPath()));
    }

    @Override
	public void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        try {
            String jwt = this.resolveToken(req);
            if (StringUtils.hasText(jwt)) {
                if (this.tokenProvider.validateToken(jwt)) {
                    String username = this.tokenProvider.getUsernameFromToken(jwt);
                    UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
                    Authentication authentication = this.tokenProvider.getAuthentication(userDetails);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
            filterChain.doFilter(req, resp);
            this.resetAuthenticationAfterRequest();
        } catch (ExpiredJwtException eje) {
            getLogger().info(String.format("Security exception for user %s - %s", eje.getClaims().getSubject(), eje.getMessage()));
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            getLogger().debug("Exception " + eje.getMessage(), eje);
        }
    }

    private void resetAuthenticationAfterRequest() {
        SecurityContextHolder.getContext().setAuthentication(null);
    }

    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(HEADER_STRING);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(TOKEN_PREFIX)) {
            String jwt = bearerToken.replace(TOKEN_PREFIX,"").trim();
            return jwt;
        }
        return null;
    }
	
}
