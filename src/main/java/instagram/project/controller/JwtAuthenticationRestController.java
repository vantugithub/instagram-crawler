package instagram.project.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import instagram.project.entity.Role;
import instagram.project.entity.RoleName;
import instagram.project.entity.User;
import instagram.project.exception.AuthenticationException;
import instagram.project.jwt.service.JwtInMemoryUserDetailsService;
import instagram.project.jwt.service.JwtTokenUtil;
import instagram.project.jwt.service.JwtUserDetails;
import instagram.project.repository.RoleRepository;
import instagram.project.repository.UserRepository;
import instagram.project.request.JwtTokenRequest;
import instagram.project.request.SignUpFormRequest;
import instagram.project.request.SignUpUserFormRequest;
import instagram.project.response.JwtTokenResponse;



@RestController
public class JwtAuthenticationRestController {

  @Value("${jwt.http.request.header}")
  private String tokenHeader;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private RoleRepository roleRepository;
  
  @Autowired
  private UserRepository userRepository;
  
  @Autowired
  private JwtTokenUtil jwtTokenUtil;
  
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtInMemoryUserDetailsService jwtInMemoryUserDetailsService;

  
  @RequestMapping(value = "/api/auth/login", method = RequestMethod.POST)
  public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtTokenRequest authenticationRequest)
      throws AuthenticationException {

	  Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), 
						authenticationRequest.getPassword()));
	  
    SecurityContextHolder.getContext().setAuthentication(authentication);
    final UserDetails userDetails = jwtInMemoryUserDetailsService.loadUserByUsername(authenticationRequest
    		.getUsername());

    final String token = jwtTokenUtil.generateToken(userDetails);

    return ResponseEntity.ok(new JwtTokenResponse(token,userDetails.getUsername()));
  }

  @SuppressWarnings("unused")
@RequestMapping(value = "${jwt.refresh.token.uri}", method = RequestMethod.GET)
  public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
    String authToken = request.getHeader(tokenHeader);
    final String token = authToken.substring(7);
    String username = jwtTokenUtil.getUsernameFromToken(token);
    JwtUserDetails user = (JwtUserDetails) jwtInMemoryUserDetailsService.loadUserByUsername(username);

    if (jwtTokenUtil.canTokenBeRefreshed(token)) {
      String refreshedToken = jwtTokenUtil.refreshToken(token);
      return ResponseEntity.ok(new JwtTokenResponse(refreshedToken, refreshedToken));
    } 
    
    else 
    
    {
      return ResponseEntity.badRequest().body(null);
    }
    
  }
  

@SuppressWarnings({ "unchecked", "rawtypes" })
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping(value = "/api/auth/signupforemployee", method = RequestMethod.POST)
  public ResponseEntity registerUserForEmployee(@Validated @RequestBody SignUpFormRequest signUpRequest) {
      if(userRepository.existsByUsername(signUpRequest.getUserName())) {
          return new ResponseEntity("Fail -> Username is already taken!",
                  HttpStatus.BAD_REQUEST);
      }

      if(userRepository.existsByEmail(signUpRequest.getEmail())) {
          return new ResponseEntity("Fail -> Email is already in use!",
                  HttpStatus.BAD_REQUEST);
      }

      // Creating user's account
      User user = new User(signUpRequest.getFullName(),
    		  signUpRequest.getUserName(),
              passwordEncoder.encode(signUpRequest.getPassword()), 
              signUpRequest.getEmail(),2,null);

      Set<String> strRoles = signUpRequest.getRole();
      Set<Role> roles = new HashSet<>();

      strRoles.forEach(role -> {
      	switch(role) {
	    		case "admin":
	    			Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
	                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	    			roles.add(adminRole);
	    			
	    			break;
	    		case "pm":
	            	Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
	                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	            	roles.add(pmRole);
	            	
	    			break;
	    		default:
	        		Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
	                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	        		roles.add(userRole);        			
      	}
      });
      
      user.setRoles(roles);
      userRepository.save(user);

      return ResponseEntity.ok().body("User registered successfully!");
  }
  
@SuppressWarnings({ "unchecked", "rawtypes" })
@RequestMapping(value = "/api/auth/signup", method = RequestMethod.POST)
public ResponseEntity registerUser(@Validated @RequestBody SignUpUserFormRequest signUpRequest) {
    if(userRepository.existsByUsername(signUpRequest.getUsername())) {
        return new ResponseEntity("Fail -> Username is already taken!",
                HttpStatus.BAD_REQUEST);
    }

    if(userRepository.existsByEmail(signUpRequest.getEmail())) {
        return new ResponseEntity("Fail -> Email is already in use!",
                HttpStatus.BAD_REQUEST);
    }

    // Creating user's account
    User user = new User(signUpRequest.getFullName(),
  		  signUpRequest.getUsername(),
            passwordEncoder.encode(signUpRequest.getPassword()), 
            signUpRequest.getEmail(),2,null);

    Set<Role> roles = new HashSet<>();
    Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
    roles.add(userRole);       
    
    user.setRoles(roles);
    userRepository.save(user);
    return ResponseEntity.ok().body("User registered successfully!");
}
  
  

  public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
  }

//  private void authenticate(String username, String password) {
//    Objects.requireNonNull(username);
//    Objects.requireNonNull(password);
//
//    try {
//      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//    } catch (DisabledException e) {
//      throw new AuthenticationException("USER_DISABLED", e);
//    } catch (BadCredentialsException e) {
//      throw new AuthenticationException("INVALID_CREDENTIALS", e);
//    }
//  }
}

