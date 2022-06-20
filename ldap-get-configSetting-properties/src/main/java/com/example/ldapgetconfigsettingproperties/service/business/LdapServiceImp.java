package com.example.ldapgetconfigsettingproperties.service.business;


import com.example.ldapgetconfigsettingproperties.dto.response.LdapLoginInfoResponse;
import com.example.ldapgetconfigsettingproperties.service.LdapService;
import org.springframework.stereotype.Service;

import java.net.InetSocketAddress;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

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
