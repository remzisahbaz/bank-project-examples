package com.example.ldapgetconfigsettingproperties.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LdapLoginInfoResponse {

    private String hostName;
    private String port;
    private String method;
    private String date;

}
