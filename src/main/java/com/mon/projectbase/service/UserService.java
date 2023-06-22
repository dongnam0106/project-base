package com.mon.projectbase.service;

import com.mon.projectbase.dto.UserDTO;
import com.mon.projectbase.mapper.UserMapper;
import com.mon.projectbase.model.User;
import com.mon.projectbase.repository.UserRepository;
import com.mon.projectbase.security.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService extends BaseService<UserRepository, UserDTO, User> implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper mapper;

    @Override
    public UserDTO create(UserDTO dto) {
        return null;
    }

    @Override
    public UserDTO update(UserDTO dto) {
        return null;
    }

    @Override
    public Optional<UserDTO> getDetails(Long id) {
        return Optional.empty();
    }

    @Override
    public UserDTO delete(UserDTO dto) {
        return null;
    }

    @Override
    public List<UserDTO> findAll() {
        return null;
    }

    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = repository.findByUsername(username);
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        return UserPrinciple.build(userOptional.get());
    }

    public UserDTO findByUsername(String username) {
        Optional<User> userOptional = repository.findByUsername(username);
        return mapper.toDto(userOptional.get());
    }

}
