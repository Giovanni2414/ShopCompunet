/*
 * BrightInsight CONFIDENTIAL

 * Copyright (c) 2019-2021 BrightInsight, All Rights Reserved.
 * NOTICE: These materials, together with all information, code, and other content contained herein (all of the
 * foregoing, collectively, this “Content”) is, and remains the property of BrightInsight, Inc. (“BrightInsight”), and
 * BrightInsight reserves all rights in and related to this Content. This Content is confidential and proprietary to
 * BrightInsight and may be covered by U.S. and/or foreign registered intellectual property or proprietary rights and/or
 * laws, including without limitation trade secret and copyright laws. Dissemination or reproduction of or access to
 * this Content, in whole or in part, is strictly forbidden unless prior written permission is obtained from
 * BrightInsight. The copyright notice above does not evidence any actual or intended publication or disclosure of this
 * Content, and this Content may be a trade secret of BrightInsight.

 * ANY USE, REPRODUCTION, MODIFICATION, DISTRIBUTION, PUBLIC PERFORMANCE, OR PUBLIC DISPLAY OF THIS CONTENT OR THROUGH
 * USE OF ANY SOFTWARE THAT IS PART OF THIS CONTENT (REGARDLESS OF WHETHER IN SOURCE OR OBJECT CODE), IN WHOLE OR IN
 * PART, IS STRICTLY PROHIBITED OTHER THAN AS EXPRESSLY AUTHORIZED BY BRIGHTINSIGHT IN WRITING, AND MAY BE IN VIOLATION
 * OF APPLICABLE LAWS AND INTERNATIONAL TREATIES. THE RECEIPT OR POSSESSION OF THIS CONTENT AND/OR RELATED INFORMATION
 * DOES NOT CONVEY OR IMPLY ANY RIGHT TO REPRODUCE, DISCLOSE, DISTRIBUTE OR OTHERWISE USE IT, OR TO MANUFACTURE, USE, OR
 * SELL ANYTHING THAT IT MAY DESCRIBE, IN WHOLE OR IN PART.
 */

package com.icesi.edu.Shop.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icesi.edu.Shop.error.exception.ShopError;
import com.icesi.edu.Shop.error.exception.ShopException;
import com.icesi.edu.Shop.utils.JWTParser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.MalformedJwtException;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import static com.icesi.edu.Shop.constants.ErrorCodes.CODE_UD_01;
import static com.icesi.edu.Shop.constants.ErrorCodes.CODE_UD_02;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
@Order(1)
public class JWTAuthorizationTokenFilter extends OncePerRequestFilter {
    
   private static final String AUTHORIZATION_HEADER = "Authorization";
   private static final String TOKEN_PREFIX = "Bearer ";

   private static final String USER_ID_CLAIM_NAME = "userId";

   private static final String[] excludedPaths = {"POST /login", "POST /users"};


    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        try {
            if (containsToken(request)) {
                String jwtToken = request.getHeader(AUTHORIZATION_HEADER).replace(TOKEN_PREFIX, StringUtils.EMPTY);
                Claims claims = JWTParser.decodeJWT(jwtToken);
                SecurityContext context = parseClaims(jwtToken, claims); System.out.println("filterChain");
                SecurityContextHolder.setUserContext(context);

                filterChain.doFilter(request, response);

            } else {
                createUnauthorizedFilter(new ShopException(HttpStatus.UNAUTHORIZED, new ShopError(CODE_UD_01, CODE_UD_01.getMessage())), response);
            }
        } catch (JwtException e) {
            createUnauthorizedFilter(new ShopException(HttpStatus.UNAUTHORIZED, new ShopError(CODE_UD_02, CODE_UD_02.getMessage())), response);
        } finally {
            SecurityContextHolder.clearContext();
        }
    }

    @SneakyThrows
    private void createUnauthorizedFilter(ShopException userDemoException, HttpServletResponse response) {

        ObjectMapper objectMapper = new ObjectMapper();

        ShopError userDemoError = userDemoException.getError();

        String message = objectMapper.writeValueAsString(userDemoError);

        response.setStatus(401);
        response.setHeader(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_VALUE);
        response.getWriter().write(message);
        response.getWriter().flush();
    }

    private SecurityContext parseClaims(String jwtToken, Claims claims) {
        String userId = claimKey(claims, USER_ID_CLAIM_NAME);

        SecurityContext context = new SecurityContext();
        try {
            context.setUserId(UUID.fromString(userId));
            context.setToken(jwtToken);
        } catch (IllegalArgumentException e) {
            throw new MalformedJwtException("Error parsing jwt");
        }
        return context;
    }

    private String claimKey(Claims claims, String key) {
        String value = (String) claims.get(key);
        return Optional.ofNullable(value).orElseThrow();
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String methodPlusPath = request.getMethod() + " " + request.getRequestURI();
        if(request.getMethod().equalsIgnoreCase("options")){
            return true;
        }
        System.out.println(methodPlusPath);
        return Arrays.stream(excludedPaths).anyMatch(path -> path.equalsIgnoreCase(methodPlusPath));
    }

    private boolean containsToken(HttpServletRequest request) {
        String authenticationHeader = request.getHeader(AUTHORIZATION_HEADER);
        return authenticationHeader != null && authenticationHeader.startsWith(TOKEN_PREFIX);
    }



}
