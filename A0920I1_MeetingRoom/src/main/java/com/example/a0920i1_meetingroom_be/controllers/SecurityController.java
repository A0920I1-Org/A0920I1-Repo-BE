package com.example.a0920i1_meetingroom_be.controllers;

import com.example.a0920i1_meetingroom_be.config.CustomUserDetailsService;
import com.example.a0920i1_meetingroom_be.jwt.JwtUtil;
import com.example.a0920i1_meetingroom_be.models.dto.AuthenticationRequest;
import com.example.a0920i1_meetingroom_be.models.dto.AuthenticationResponse;
import com.example.a0920i1_meetingroom_be.models.entity.Account;
import com.example.a0920i1_meetingroom_be.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
public class SecurityController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);
        final String role = String.valueOf(userDetails.getAuthorities());

        return ResponseEntity.ok(new AuthenticationResponse(token, role));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> saveUser(@RequestBody Account account) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(account));
    }

    @GetMapping(value = "/findAccount")
    public ResponseEntity<?> findAccountByUser(@RequestParam String username){
        Account account = accountService.findAccountByUsername(username);

        if(account != null){
            return ResponseEntity.ok(account);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
