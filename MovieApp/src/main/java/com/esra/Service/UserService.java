package com.esra.Service;

import com.esra.dto.request.LoginRequestDto;
import com.esra.dto.request.RegisterRequestDto;
import com.esra.dto.response.LoginResponceDto;
import com.esra.dto.response.RegisterResponceDto;
import com.esra.entity.User;
import com.esra.mapper.UserMapper;
import com.esra.repository.UserRepository;
import com.esra.utility.ICrudService;
import com.esra.utility.enums.EStatus;
import com.esra.utility.enums.EUserType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements ICrudService<User,Long> {
    private final UserRepository userRepository;

    public User register(String name, String surname, String email,String password ,String rePassword){
            User user = User.builder()
                    .name(name)
                    .surname(surname)
                    .email(email)
                    .password(password)
                    .rePassword(rePassword)
                    .build();
            if(!password.equals(rePassword) || password.isBlank()) {
                throw new RuntimeException("Şifreler uyuşmuyor");
            }else{
                return userRepository.save(user);
            }
    }

    public User login(String email, String password){
        Optional<User> user =userRepository.findOptionalByEmailAndPassword(email,password);
        if(user.isPresent()){
            throw new RuntimeException("Böyle bir kullanıcı bulunamadı...");
        }
        return user.get();
    }


    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public Iterable<User> saveAll(Iterable<User> t) {
        return null;
    }

    @Override
    public User deleteById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            user.get().setStatus(EStatus.INACTIVE);
            return  userRepository.save(user.get());
        }else {
            throw new NullPointerException("Böyle bir kullanıcı bulunamadı...");
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user;
        }else{
            throw new NullPointerException("Böyle bir kullanıcı bulunamadı...");
        }

    }

    @Override
    public boolean existById(Long aLong) {
        return false;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = userRepository.findAll();
        if(userList.isEmpty()){
            throw new NullPointerException("Liste boş");
        }
        return userList;
    }

    @Override
    public List<User> findByColumnAndValue(String columnName, Object value) {
        return null;
    }


    public Optional<User> findOptionalByEmailAndPassword(String email, String password) {
        return userRepository.findOptionalByEmailAndPassword(email,password);
    }

    public RegisterResponceDto registerDto(RegisterRequestDto dto) {
        User user = User.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .rePassword(dto.getRePassword())
                .build();
        if(!user.getPassword().equals(user.getRePassword()) || user.getPassword().isBlank()) {
            throw new RuntimeException("Şifreler uyuşmuyor");
        }
        userRepository.save(user);
        return RegisterResponceDto.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .status(user.getStatus())
                .build();

    }

    public LoginResponceDto loginDto(LoginRequestDto dto) {
        User user = User.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
        if(!user.getPassword().equals(dto.getPassword())){
            throw new RuntimeException("Böyle bir kullanıcı bulunamadı..");
        }
        return LoginResponceDto.builder()
                .email(user.getEmail())
                .build();
    }
    public Optional<User> loginDto2(LoginRequestDto dto) {
        Optional<User> user =userRepository.findOptionalByEmailAndPassword(dto.getEmail(),dto.getPassword());
        if(user.isEmpty()){
            throw new RuntimeException("Email veya şifre hatalı..");
        }
        return user;
    }


    public LoginResponceDto loginMapper(LoginRequestDto dto) {
        Optional<User> user =userRepository.findOptionalByEmailAndPassword(dto.getEmail(),dto.getPassword());
        if(user.isEmpty()){
            throw new RuntimeException("Email veya şifre hatalı.");
        }
        return UserMapper.INSTANCE.fromUserToLoginResponceDto(user.get());
    }

    public RegisterResponceDto registerMapper(RegisterRequestDto dto) {
        User user = UserMapper.INSTANCE.fromRegisterRequestDtoToUser(dto);
        if(!user.getPassword().equals(user.getRePassword()) || user.getPassword().isBlank()) {
            throw new RuntimeException("Şifreler uyuşmuyor");
        }
        userRepository.save(user);
        return UserMapper.INSTANCE.fromUserToRegisterResponceDto(user);
    }

    // buradan sonrası commit 2
    public RegisterResponceDto checkAndRegisterUniqueEmail(RegisterRequestDto dto) {
        User user = UserMapper.INSTANCE.fromRegisterRequestDtoToUser(dto);
        if(!user.getPassword().equals(user.getRePassword()) || user.getPassword().isBlank()) {
            throw new RuntimeException("Şifreler uyuşmuyor");
        }
        Optional<User> user1 =userRepository.findByEmail(dto.getEmail());
        if(user1.isPresent()){
            throw new RuntimeException("Email daha önce kaydedilmiş. Başka bir email giriniz...");
        }
        if(dto.getEmail().equals(("ba.admin@email.com"))){
            user.setStatus(EStatus.ACTIVE);
            user.setUserType(EUserType.ADMIN);
        }
            userRepository.save(user);
        return UserMapper.INSTANCE.fromUserToRegisterResponceDto(user);
    }

    public List<User> findAllByOrderByName(){
        return userRepository.findAllByOrderByName();
    }


    public Boolean existsByNameIgnoreCase(String name) {
        return userRepository.existsByNameIgnoreCase(name);
    }

    public List<User> findAllByNameContainingIgnoreCase(String name) {
        return userRepository.findAllByNameContainingIgnoreCase(name);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // buradan sonrası commit 3
    public List<User> findUsersWithLongPasswordNative(Integer length) {
        return userRepository.findUsersWithLongPasswordNative(length);
    }

    public List<User> findUsersWithLongPasswordJPQL(int passwordLength) {
        return userRepository.findUsersWithLongPasswordJPQL(passwordLength);
    }

    public List<User> findAllByEmailEndsWithIgnoreCase(String name) {
        return userRepository.findAllByEmailEndsWithIgnoreCase(name);
    }


}
