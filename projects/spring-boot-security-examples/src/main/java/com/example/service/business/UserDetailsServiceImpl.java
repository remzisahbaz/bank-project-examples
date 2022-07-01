package com.example.service.business;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.security.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRepository.findByUserName(username);
        if(user != null) {
            return JwtUserDetails.creae(user);
        }
        else {
            return null;
        }
    }

    public UserDetails loadUserById(Long id){
        User user = userRepository.findById(id).get();
        if(user != null) {
            return JwtUserDetails.creae(user);
        }
        else {
            return null;
        }

    }
}
