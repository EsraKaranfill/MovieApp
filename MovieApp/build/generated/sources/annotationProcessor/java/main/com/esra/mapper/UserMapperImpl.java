package com.esra.mapper;

import com.esra.dto.request.RegisterRequestDto;
import com.esra.dto.response.LoginResponceDto;
import com.esra.dto.response.RegisterResponceDto;
import com.esra.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-29T02:18:55+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 21 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public LoginResponceDto fromUserToLoginResponceDto(User user) {
        if ( user == null ) {
            return null;
        }

        LoginResponceDto.LoginResponceDtoBuilder loginResponceDto = LoginResponceDto.builder();

        loginResponceDto.email( user.getEmail() );

        return loginResponceDto.build();
    }

    @Override
    public User fromRegisterRequestDtoToUser(RegisterRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.name( dto.getName() );
        user.surname( dto.getSurname() );
        user.email( dto.getEmail() );
        user.password( dto.getPassword() );
        user.rePassword( dto.getRePassword() );

        return user.build();
    }

    @Override
    public RegisterResponceDto fromUserToRegisterResponceDto(User user) {
        if ( user == null ) {
            return null;
        }

        RegisterResponceDto.RegisterResponceDtoBuilder registerResponceDto = RegisterResponceDto.builder();

        registerResponceDto.name( user.getName() );
        registerResponceDto.surname( user.getSurname() );
        registerResponceDto.email( user.getEmail() );
        registerResponceDto.status( user.getStatus() );

        return registerResponceDto.build();
    }
}
