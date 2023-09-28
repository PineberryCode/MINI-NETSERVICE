package my.project.mininetservice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import my.project.mininetservice.dto.AuthenticationRequest;
import my.project.mininetservice.dto.AuthenticationResponse;
import my.project.mininetservice.model.User;
import my.project.mininetservice.model.repository.UserRepository;

@Service
public class AuthenticationService {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTService jwtService;

    public AuthenticationResponse login (AuthenticationRequest authenticationRequest) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
            authenticationRequest.getUsername(), authenticationRequest.getPassword()
        ); //Authencate just username and password.
        authenticationManager.authenticate(authToken);

        User user = userRepository.findByUsername(authenticationRequest.getUsername()).get();
        String jwt = jwtService.generateToken(user, generateExtraClaims(user));

        return new AuthenticationResponse(jwt);
    }

    private Map<String, Object> generateExtraClaims (User user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("username", user.getUsername());
        extraClaims.put("role", user.getRole().name());
        extraClaims.put("permissions", user.getAuthorities());

        return extraClaims;
    }

}
