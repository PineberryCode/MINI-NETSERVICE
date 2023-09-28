package my.project.mininetservice.controller.PRIVATE;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import my.project.mininetservice.dto.AuthenticationRequest;
import my.project.mininetservice.dto.AuthenticationResponse;
import my.project.mininetservice.model.TokenJWT;
import my.project.mininetservice.routes.Router;
import my.project.mininetservice.service.AuthenticationService;

@Controller
@RequestMapping("/restricted")
public class LoginController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private AuthenticationService authenticationService;

    @PreAuthorize("permitAll")
    @GetMapping("/admin")
    public String login () {
        return Router.LOG_IN;
    }

    @PreAuthorize("permitAll")
    @PostMapping("/admin/login")
    public ResponseEntity<AuthenticationResponse> validate (@RequestBody @Valid AuthenticationRequest authenticationRequest) {
        AuthenticationResponse jwt = authenticationService.login(authenticationRequest);
        return ResponseEntity.ok(jwt);
    }
}