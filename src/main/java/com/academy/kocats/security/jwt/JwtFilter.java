package com.academy.kocats.security.jwt;

import com.academy.kocats.security.dto.ExpiredJwtDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {


    private final JwtTokenProvider jwtTokenProvider;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
        try
        {
            String jwt = resolveToken(request); // null
            if (StringUtils.isNotBlank(jwt) && jwtTokenProvider.validateToken(jwt))
            {
                Authentication authentication = jwtTokenProvider.getAuthentication(jwt);
                SecurityContextHolder.getContext().setAuthentication(authentication); // thread local!!!
            }
            filterChain.doFilter(request, response);
        }
        catch (SignatureException | MalformedJwtException
               | UnsupportedJwtException
               | IllegalArgumentException | IOException | ServletException e)
        {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
        catch (ExpiredJwtException e) {
            prepareExpiredJwtResponse(response, e);
        }
    }


    /**
     * Resolving token from HttpServletRequest
     *
     * @param request http servlet request
     * @return token as string | null
     */
    private String resolveToken(HttpServletRequest request)
    {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.isNotEmpty(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    private void prepareExpiredJwtResponse(HttpServletResponse response, ExpiredJwtException e) throws IOException
    {
        ExpiredJwtDTO expiredJwtDTO = new ExpiredJwtDTO(e.getMessage());

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(
                new ObjectMapper().writeValueAsString(expiredJwtDTO)
        );
    }


}
