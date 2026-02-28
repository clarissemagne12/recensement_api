package org.example.recensement.services;

import org.example.recensement.UserDetails;
import org.example.recensement.entities.Role;
import org.example.recensement.entities.User;
import org.example.recensement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements UserDetails {

    private final UserRepository userRepository;

    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//     @Autowired
//    privatePasswordEncoder passwordEncoder;

    public User createUser(String username, String password, Role role) {
        User user = new User();
        user.setUsername(username);
//        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);
        return userRepository.save(user);
    }

    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));

        // Retourne un UserDetails pour Spring Security
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword()) // mot de passe encodé
                .roles(user.getRole().getLibelle()) // récupère le rôle
                .build();
    }
}