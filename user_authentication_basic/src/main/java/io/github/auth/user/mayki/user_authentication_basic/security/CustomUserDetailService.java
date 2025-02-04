package io.github.auth.user.mayki.user_authentication_basic.security;

import io.github.auth.user.mayki.user_authentication_basic.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private UserRepository repository;

    public CustomUserDetailService(UserRepository userRepository){
        this.repository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return repository.findByLogin(login).orElseThrow(()
                -> new UsernameNotFoundException("Usuário não encontrado"));
    }
}
