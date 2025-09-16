package com.bookrental.bboky.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bookrental.bboky.repository.UserRepository;

@Service
public class CustomUsersDetailService implements UserDetailsService {
    
    @Autowired
    private UserRepository usersRepository ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<com.bookrental.bboky.model.User> user = usersRepository.findByUsername(username);
        if (user.isPresent()){
            var userObj = user.get();

            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .roles(getRole(userObj))
                    .build();
        }
        else {
            throw new UsernameNotFoundException(username);
        }
    }

    private String getRole(com.bookrental.bboky.model.User user){
        if(user.getRole().name() != null){
            return "USER";
        }
        return user.getRole().name();
    }
}
