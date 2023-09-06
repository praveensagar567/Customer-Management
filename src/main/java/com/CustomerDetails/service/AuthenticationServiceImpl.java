package com.CustomerDetails.service;

import com.CustomerDetails.entity.Authentication;
import com.CustomerDetails.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AuthenticationRepository authenticationRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public String authenticateUser(AuthenticationRequest request) {
        Optional<Authentication> authentication = authenticationRepository.findByLoginIdAndPassword(
                request.getLoginId(),
                request.getPassword()
        );

        if (authentication.isPresent()) {
            // Authentication successful, generate and return the bearer token
            String bearerToken = jwtTokenUtil.generateToken(request.getLoginId());
            authentication.get().setBearerToken(bearerToken);
            authenticationRepository.save(authentication.get());
            return bearerToken;
        } else {
            // Handle authentication failure (e.g., throw an exception)
            return null;
        }
    }
}
