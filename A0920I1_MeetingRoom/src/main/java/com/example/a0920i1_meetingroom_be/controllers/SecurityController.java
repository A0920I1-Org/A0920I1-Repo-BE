package com.example.a0920i1_meetingroom_be.controllers;

import com.example.a0920i1_meetingroom_be.config.CustomUserDetailsService;
import com.example.a0920i1_meetingroom_be.jwt.JwtUtil;
import com.example.a0920i1_meetingroom_be.models.dto.AuthenticationRequest;
import com.example.a0920i1_meetingroom_be.models.dto.AuthenticationResponse;
import com.example.a0920i1_meetingroom_be.models.entity.Account;
import com.example.a0920i1_meetingroom_be.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api")
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

    //    xac thuc dang nhap - TuHC
    @PostMapping(value = "/authenticate")
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (DisabledException e) {
//            throw new Exception("USER_DISABLED", e);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(token, "OK"));

    }

    //Lay account dua theo username - TuHC
    @GetMapping(value = "/findAccount")
    public ResponseEntity<?> findAccountByUser(@RequestParam String username) {
        Account account = accountService.findAccountByUsername(username);
        if (account != null) {
            return ResponseEntity.ok(account);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/getAllAccount")
    public ResponseEntity<?> getAllAccount() {
        return ResponseEntity.ok(accountService.getAllAccount());
    }

}
