package instagram.project.jwt.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import instagram.project.entity.User;
import instagram.project.repository.UserRepository;


@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
    	
        User user = userRepository.findByUsername(username)
                	.orElseThrow(() -> 
                        new UsernameNotFoundException("User Not Found with -> username or email : " + username)
        );

        return JwtUserDetails.build(user);
    }

}


