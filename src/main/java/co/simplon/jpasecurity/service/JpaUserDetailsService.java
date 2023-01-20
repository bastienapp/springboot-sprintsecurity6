package co.simplon.jpasecurity.service;

import co.simplon.jpasecurity.entity.User;
import co.simplon.jpasecurity.model.SecurityUser;
import co.simplon.jpasecurity.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public JpaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(username)
                .map((User user) -> new SecurityUser(user))
                .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));
    }
}
