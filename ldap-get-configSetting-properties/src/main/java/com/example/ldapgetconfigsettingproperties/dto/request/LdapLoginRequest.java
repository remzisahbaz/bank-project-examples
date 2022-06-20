package com.example.ldapgetconfigsettingproperties.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LdapLoginRequest {

    private String userName;
    private String password;
}
