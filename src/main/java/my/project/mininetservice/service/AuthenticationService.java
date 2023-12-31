package my.project.mininetservice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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

    public AuthenticationResponse login (User user) {
        User sourceUser = userRepository.findByUsername(user.getUsername()).get();
        
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
            user.getUsername(), user.getPassword()
        ); //Authencate just username and password.
        authenticationManager.authenticate(authToken);
    
        SecurityContextHolder.getContext().setAuthentication(authToken);
        String jwt = jwtService.generateToken(sourceUser, generateExtraClaims(sourceUser));
        
        return new AuthenticationResponse(jwt);
    }

    private Map<String, Object> generateExtraClaims (User user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("user_role", user.getUser_role().name());
        extraClaims.put("permissions", user.getAuthorities());

        return extraClaims;
    }

}
