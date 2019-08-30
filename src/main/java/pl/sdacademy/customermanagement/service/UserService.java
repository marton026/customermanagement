package pl.sdacademy.customermanagement.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdacademy.customermanagement.dto.UserDto;
import pl.sdacademy.customermanagement.model.User;
import pl.sdacademy.customermanagement.repository.UserRepository;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;



    public void createOrUpdate(UserDto dto) {
        User user = User.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .street(dto.getStreet())
                .city(dto.getCity())
                .zipCode(dto.getZipCode())
                .company(dto.getCompany())
                .idNumber(dto.getIdNumber())
                .phoneNumber(dto.getPhoneNumber())
                .email(dto.getEmail())
                .state(dto.getState())
                .createDate(dto.getCreateDate())
                .contractExpDate(dto.getContractExpDate())
                .build();
        userRepository.save(user);
    }

    public UserDto findById(Long id) {
        return userRepository.findById(id)
                .map(User::toDto)
                .orElseThrow(() -> new IllegalStateException("nie ma takiego użytkownika"));
    }


    public void delete(Long id) {
        userRepository.deleteById(id);

    }

    public List<UserDto> findAll() {
        List<User> list = (List<User>) userRepository.findAll();
        return list.stream()
                .map(User::toDto)
                .collect(Collectors.toList());
    }


}
