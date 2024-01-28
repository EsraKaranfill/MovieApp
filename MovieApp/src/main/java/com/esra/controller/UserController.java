package com.esra.controller;

import com.esra.Service.UserService;
import com.esra.dto.request.LoginRequestDto;
import com.esra.dto.request.RegisterRequestDto;
import com.esra.dto.response.LoginResponceDto;
import com.esra.dto.response.RegisterResponceDto;
import com.esra.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;



    @GetMapping("/find-by-id")
    public ResponseEntity<Optional<User>> findById(Long id){
        return ResponseEntity.ok( userService.findById(id));
    }

    @GetMapping("find-all")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }
    @DeleteMapping("/delete-by-id")
    public ResponseEntity<User> deleteById(Long id){
        return ResponseEntity.ok(userService.deleteById(id));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(String email,String password){
        return ResponseEntity.ok(userService.login(email,password));
    }

    @PostMapping("/login-dto")
    public ResponseEntity<LoginResponceDto> loginDto(@RequestBody LoginRequestDto dto){
        return ResponseEntity.ok(userService.loginDto(dto));
    }

    @PostMapping("/login-dto2")
    public ResponseEntity<Boolean> loginDto2(@RequestBody LoginRequestDto dto){
        Optional<User> user = userService.loginDto2(dto);
        if(user.isPresent()){
            return ResponseEntity.ok(true);
        }else {
            return ResponseEntity.ok(false);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(String name, String surname, String email,String password ,String rePassword){
        return ResponseEntity.ok(userService.register(name,surname,email,password,rePassword));
    }

    @PostMapping("/register-dto")
    public ResponseEntity<RegisterResponceDto> registerDto(@RequestBody RegisterRequestDto dto){
        return ResponseEntity.ok(userService.registerDto(dto));
    }

    @PostMapping("/login-mapper")
    public ResponseEntity<LoginResponceDto> loginMapper(@RequestBody LoginRequestDto dto){
        return ResponseEntity.ok(userService.loginMapper(dto));
    }

    @PostMapping("/register-mapper")
    public ResponseEntity<RegisterResponceDto> registerMapper(@RequestBody RegisterRequestDto dto){
        return ResponseEntity.ok(userService.registerMapper(dto));
    }

    @PostMapping("/do-login")
    public ResponseEntity<Boolean> doLogin(String email,String password){
        Optional<User> user = userService.findOptionalByEmailAndPassword(email, password);
        if(user.isPresent()){
            return ResponseEntity.ok(true);
        }else {
            return ResponseEntity.ok(false);
        }
    }

    @GetMapping("/find-all-by-order-by-name")
    public ResponseEntity<List<User>> findAllByOrderByName(){
        return ResponseEntity.ok(userService.findAllByOrderByName());
    }

    @GetMapping("/exists-by-name-ignore-case")
    public ResponseEntity<Boolean> existsByNameIgnoreCase(String name){
        return ResponseEntity.ok(userService.existsByNameIgnoreCase(name));
    }

    @GetMapping("/find-all-by-name-containing-ignore-case")
    public ResponseEntity<List<User>> findAllByNameContainingIgnoreCase(String name){
        return ResponseEntity.ok(userService.findAllByNameContainingIgnoreCase(name));
    }

    @GetMapping("/find-by-email")
    public ResponseEntity<Optional<User>> findByEmail(String email){
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @PostMapping("/check-and-register-unique-email")
    public ResponseEntity<RegisterResponceDto> checkAndRegisterUniqueEmail(@RequestBody RegisterRequestDto dto){
        return ResponseEntity.ok(userService.checkAndRegisterUniqueEmail(dto));
    }

    @GetMapping("/find-user-with-long-password-native")
    public ResponseEntity<List<User>> findUsersWithLongPasswordNative(Integer length){
        return ResponseEntity.ok(userService.findUsersWithLongPasswordNative(length));
    }



    @GetMapping("/find-user-with-long-password-jpql")
    public ResponseEntity<List<User>> findUsersWithLongPasswordJPQL(int passwordLength){
        return ResponseEntity.ok(userService.findUsersWithLongPasswordJPQL(passwordLength));
    }


    @GetMapping("/find-all-by-email-ends-with-ignore-case")
    public  ResponseEntity<List<User>> findAllByEmailEndsWithIgnoreCase(String name){
        return ResponseEntity.ok(userService.findAllByEmailEndsWithIgnoreCase(name));
    }



}
