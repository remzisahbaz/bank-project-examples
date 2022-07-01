package com.example.springbootldapsecurityrestapi.security;


import com.example.service.business.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String jwtToken =exractJwtFromRequest(request);
            if(StringUtils.hasText(jwtToken) && jwtTokenProvider.validationToken(jwtToken)){
                Long id= jwtTokenProvider.getUserIdFromJwt(jwtToken);
                UserDetails user=userDetailsService.loadUserById(id);
                if(user !=null){
                    UsernamePasswordAuthenticationToken auth=
                            new UsernamePasswordAuthenticationToken
                                    (user,null,user.getAuthorities());
                    auth.setDetails(new WebAuthenticationDetailsSource()
                            .buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(auth); //local storech gibi davranır . auth. bilglileri tutar
                }
            }

        }
        catch (Exception e){
            return ;
        }
     filterChain.doFilter(request,response);
    }

    private String exractJwtFromRequest(HttpServletRequest request) {
        String bearer=request.getHeader("Authorization");
        if(StringUtils.hasText(bearer) && bearer.startsWith("Bearer ")){
            return bearer.substring("Bearer".length()+1);

        }
        return null;
    }
}
