package instagram.project.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import instagram.project.entity.User;
import instagram.project.repository.UserRepository;
import instagram.project.response.PagedResponse;
import instagram.project.response.UserResponse;
import instagram.project.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserRepository userRepository;

	@SuppressWarnings("unused")
	@Override
	public void updateImageProfile(String urlImage, String username) {
		String url = "https://spring-api-test.s3.ap-southeast-1.amazonaws.com/";
		Optional<User> user = userRepository.findByUsername(username);
		userRepository.save(user.get());
	}

	@Override
	public void save(long id) {
		Optional<User> user = userRepository.findById(id);
		if(user.get().isActive()==1) {
			user.get().setActive(2);
		}else {
			user.get().setActive(1);
		}
		userRepository.save(user.get());
	}

	@Override
	public void delete(long id) {
	userRepository.deleteById(id);
	}

	@Override
	public Boolean existsById(long id) {
		
		return userRepository.existsById(id);
	}

	@Override
	public PagedResponse<UserResponse> findAll(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<User> users = userRepository.findAllByOrderByIdDesc(pageable);
		
		List<UserResponse> userResponses = new ArrayList<>(users.getContent().size());
		
		for (User user : users.getContent()) {
			userResponses.add(new UserResponse(
					user.getId(),
					user.getFullName(),
					user.getUsername(),
					user.getEmail(),
					user.isActive(),
					user.getLastUpdatedDate().toString()));
		}
		
		return new PagedResponse<>(userResponses, users.getNumber(), users.getSize(), users.getTotalElements(),
				users.getTotalPages(), users.isLast());
	}

	
	
}
