package com.example.ldap.service.service.business;


import com.example.ldap.dto.request.LdapLoginRequest;
import com.example.ldap.dto.response.LdapLoginInfoResponse;
import com.example.ldap.service.service.LdapService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.net.InetSocketAddress;
import java.net.http.HttpHeaders;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class LdapServiceImp implements LdapService {

//    @Autowired
//    private ModelMapper modelMapper;


    public Optional<LdapLoginInfoResponse> createHeadInfo(InetSocketAddress host) {
        Objects.nonNull(host);

        LdapLoginInfoResponse ldapLoginInfoResponse = LdapLoginInfoResponse.builder()
                .port(String
                        .valueOf(host.getPort()))
                .hostName(host.getHostName())
                .date(new Date()
                        .toString())
                .build();

        //  return Optional.ofNullable(modelMapper.map(header));
        return Optional.ofNullable(ldapLoginInfoResponse);
    }

}
