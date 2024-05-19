package com.wishlistService.filter;

import io.jsonwebtoken.*;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class AuthFilter extends OncePerRequestFilter {
@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
		throws ServletException, IOException {
	
	HttpServletRequest httpreq = (HttpServletRequest) request;
	HttpServletResponse httpres = (HttpServletResponse) response;
	
	httpres.setHeader("Access-Control-Allow-Origin", "*");
	httpres.setHeader("Access-Control-Allow-Headers", "*");
	httpres.setHeader("Access-Control-Allow-Credentials", "true");
	httpres.setHeader("Access-Control-Allow-Methods", "GET");
	
	if (httpreq.getMethod().equals(HttpMethod.OPTIONS.name())) {
		filterChain.doFilter(httpreq, httpres);
	} else {
		
		String headerinfo = httpreq.getHeader("Authorization");
		
		System.out.println(headerinfo);
		
		if ((headerinfo == null) || (!headerinfo.startsWith("Bearer"))) {
			throw new ServletException("JWT Token is missing");
		}
		
		String mytoken = headerinfo.substring(7);
		
		try {
			JwtParser jwtparser = Jwts.parser().setSigningKey("secret");
			
			Jwt jwtobj = jwtparser.parse(mytoken);
			Claims claimobj = (Claims) jwtobj.getBody();
			
			String userEmail = claimobj.get("id", String.class);
			System.out.println("User logged in " + userEmail);
			
			HttpSession sess = httpreq.getSession();
			sess.setAttribute("useremail", claimobj.getSubject());			
		} catch (MalformedJwtException e) {
			throw new ServletException("Something went wrong!");
			
		}
		
		filterChain.doFilter(httpreq, httpres);
	}
	
}

}

	
	