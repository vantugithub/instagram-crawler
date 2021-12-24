package instagram.project.jwt.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import instagram.project.repository.UserRepository;


@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  

	@Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
    	
        instagram.project.entity.User user = userRepository.findByUsernameAndActive(username,1)
                	.orElseThrow(() -> 
                        new UsernameNotFoundException("User Not Found with -> username or email : " + username)
        );

        return JwtUserDetails.build(user);
    }

}


