package com.example.ldap.controller;

import com.example.ldap.dto.request.LdapLoginRequest;
import com.example.ldap.dto.response.LdapLoginInfoResponse;
import com.example.ldap.service.service.business.LdapServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.net.InetSocketAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
@RequestScope
public class RestController {

@Autowired
    private LdapServiceImp ldapServiceImp;


    @GetMapping("/ldap")
    public Optional<LdapLoginInfoResponse> userRequestInfo (@RequestHeader HttpHeaders headers){

        InetSocketAddress host = headers.getHost();
        ldapServiceImp.createHeadInfo(host);

        return  ldapServiceImp.createHeadInfo(host);

    }



    /*@GetMapping("/ldap")
    public ResponseEntity<String> multiValue(
            @RequestHeader(value = "Accept") MultiValueMap<String, String> headers) {

        Map<String,String> list = new HashMap<>();
        headers.forEach((key, value) -> {

            System.out.println(String.format(
                    "Header '%s' = %s", key, value.stream().collect(Collectors.joining("|"))));

        list.put(key, value.toString());
    }
        );

        return new ResponseEntity<String>(
                String.format("Listed %s headers", list.keySet()), HttpStatus.OK);

    }*/



}
