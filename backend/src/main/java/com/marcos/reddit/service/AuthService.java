package com.marcos.reddit.service;

import java.time.Instant;
import java.util.UUID;

import javax.transaction.Transactional;

import com.marcos.reddit.dto.RegisterRequest;
import com.marcos.reddit.model.User;
import com.marcos.reddit.model.VerificationToken;
import com.marcos.reddit.repository.UserRespository;
import com.marcos.reddit.repository.VerificationTokenRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService {
  private final PasswordEncoder passwordEncoder;

  private final UserRespository userRespository;

  private final VerificationTokenRepository verificationTokenRepository;

  @Transactional
  public void signup(RegisterRequest registerRequest){
    User user = new User();
    user.setUserName(registerRequest.getUserName());
    user.setEmail(registerRequest.getEmail());
    user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
    user.setCreated(Instant.now());
    user.setEnabled(false);
    userRespository.save(user);
    String token = generateVerificationToken(user);
  }

  private String generateVerificationToken(User user) {
    String token = UUID.randomUUID().toString();
    VerificationToken verificationToken = new VerificationToken();
    verificationToken.setToken(token);
    verificationToken.setUser(user);
    verificationTokenRepository.save(verificationToken);
    return token;
  }
}
