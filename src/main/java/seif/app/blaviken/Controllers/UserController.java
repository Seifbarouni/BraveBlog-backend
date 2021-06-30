package seif.app.blaviken.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import seif.app.blaviken.Models.AuthenticationRequest;
import seif.app.blaviken.Models.AuthenticationResponse;
import seif.app.blaviken.Models.MyUserDetails;
import seif.app.blaviken.Models.User;
import seif.app.blaviken.Models.UserRegisterModel;
import seif.app.blaviken.Services.MyUserDetailsService;
import seif.app.blaviken.Services.UserService;
import seif.app.blaviken.Utils.Utils;

@RestController
public class UserController {
    @Autowired
    private Utils jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService customUserDetailsService;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public AuthenticationResponse register(@RequestBody UserRegisterModel userRegisterModel) {
        Optional<User> us = userService.getUserByUsername(userRegisterModel.getUsername());
        if (us.isPresent())
            return new AuthenticationResponse("username already exists", "", "", "", "", 0L);
        try {
            User user = new User(userRegisterModel.getUsername(), userRegisterModel.getEmail(),
                    passwordEncoder.encode(userRegisterModel.getPassword()), 0L, userRegisterModel.getPicUrl());
            userService.addUser(user);
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        } catch (Exception e) {
        }
        final MyUserDetails userDetails = customUserDetailsService.loadUserByUsername(userRegisterModel.getUsername());
        return new AuthenticationResponse("Success",
                jwtUtil.generateToken(userRegisterModel.getUsername(), userDetails), userDetails.getUsername(),
                userDetails.getEmail(), userDetails.getPicUrl(), userDetails.getId());

    }

    @PostMapping("/auth")
    public AuthenticationResponse auth(@RequestBody AuthenticationRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (Exception ex) {
            return new AuthenticationResponse("Error : invalid username or password", "", "", "", "", 0L);
        }
        final MyUserDetails userDetails = customUserDetailsService.loadUserByUsername(authRequest.getUsername());
        return new AuthenticationResponse("Success", jwtUtil.generateToken(authRequest.getUsername(), userDetails),
                userDetails.getUsername(), userDetails.getEmail(), userDetails.getPicUrl(), userDetails.getId());
    }
}
