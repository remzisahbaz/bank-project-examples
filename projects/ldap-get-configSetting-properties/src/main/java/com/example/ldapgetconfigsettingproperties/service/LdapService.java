package com.example.ldapgetconfigsettingproperties.service;

import com.example.ldapgetconfigsettingproperties.dto.response.LdapLoginInfoResponse;
import org.springframework.stereotype.Service;

import java.net.InetSocketAddress;
import java.util.Optional;

@Service
public interface LdapService {

    public Optional<LdapLoginInfoResponse> createHeadInfo(InetSocketAddress host);
;
}
