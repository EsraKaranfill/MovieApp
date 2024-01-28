package com.esra.dto.response;


import com.esra.utility.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponceDto {
    String name;
    String surname;
    String email;
    EStatus status;
}
