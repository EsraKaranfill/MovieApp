package com.esra.mapper;

import com.esra.dto.request.RegisterRequestDto;
import com.esra.dto.response.LoginResponceDto;
import com.esra.dto.response.RegisterResponceDto;
import com.esra.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    LoginResponceDto fromUserToLoginResponceDto(final User user);

    User fromRegisterRequestDtoToUser(final RegisterRequestDto dto);

    RegisterResponceDto fromUserToRegisterResponceDto(final User user);

}
