package com.example.ldap.service.service;

import com.example.ldap.dto.request.LdapLoginRequest;
import com.example.ldap.dto.response.LdapLoginInfoResponse;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.net.InetSocketAddress;
import java.net.http.HttpHeaders;
import java.util.Optional;

@Service
public interface LdapService {

    public Optional<LdapLoginInfoResponse> createHeadInfo(InetSocketAddress host);
;
}
