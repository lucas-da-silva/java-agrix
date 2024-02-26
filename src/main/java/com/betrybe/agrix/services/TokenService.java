package com.betrybe.agrix.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Service responsible for generating and validating tokens.
 */
@Service
public class TokenService {

  private final Algorithm algorithm;

  public TokenService(@Value("${api.security.token.secret}") String secret) {
    this.algorithm = Algorithm.HMAC256(secret);
  }

  /**
   * Generates a token for the given username.
   *
   * @param username the username to generate the token for.
   * @return the generated token.
   */
  public String generateToken(String username) {
    return JWT.create()
        .withSubject(username)
        .sign(algorithm);
  }

  /**
   * Validates the given token and returns the username if the token is valid.
   *
   * @param token the token to validate.
   * @return the username if the token is valid.
   */
  public String validateToken(String token) {
    return JWT.require(algorithm)
        .build()
        .verify(token)
        .getSubject();
  }

}
