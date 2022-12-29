package com.m_code.Fawry.Auth.controllers;

import com.m_code.Fawry.Auth.payload.response.UserInfoResponse;
import com.m_code.Fawry.Auth.security.jwt.JwtUtils;
import com.m_code.Fawry.Auth.services.UserDetailsImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {

  @Autowired
  JwtUtils jwtUtils;

  @Autowired
  UserDetailsService userDetailsService;

  @GetMapping("/account")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  public ResponseEntity<?> userAccess(@CookieValue("${com.m_code.Fawry.jwtCookieName}") String jwtToken) {
    String username = jwtUtils.getUserNameFromJwtToken(jwtToken);
    UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(username);
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok()
        .body(new UserInfoResponse(userDetails.getId(),
            userDetails.getUsername(),
            userDetails.getEmail(),
            userDetails.getBalance(),
            roles));
  }

}
