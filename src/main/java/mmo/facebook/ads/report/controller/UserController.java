package mmo.facebook.ads.report.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mmo.facebook.ads.report.exception.ResourceNotFoundException;
import mmo.facebook.ads.report.model.User;
import mmo.facebook.ads.report.repository.UserRepository;
import mmo.facebook.ads.report.security.CurrentUser;
import mmo.facebook.ads.report.security.UserPrincipal;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
