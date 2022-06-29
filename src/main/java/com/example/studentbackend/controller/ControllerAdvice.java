package com.example.studentbackend.controller;

import com.example.studentbackend.view.View;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMappingJacksonResponseBodyAdvice;

import java.util.Collection;


@org.springframework.web.bind.annotation.ControllerAdvice(annotations = RestController.class)
public class ControllerAdvice extends AbstractMappingJacksonResponseBodyAdvice {

    @Override
    protected void beforeBodyWriteInternal(MappingJacksonValue bodyContainer, MediaType contentType, MethodParameter returnType, ServerHttpRequest request, ServerHttpResponse response) {
        Class<?> view = View.Student.class;
        if(SecurityContextHolder.getContext().getAuthentication()!=null && SecurityContextHolder.getContext().getAuthentication().getAuthorities()!=null){
            Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();

            if(authorities.stream().anyMatch(auth -> auth.getAuthority().equals("STUDENT"))){
                view = View.Student.class;

            }
            else if(authorities.stream().anyMatch(auth -> auth.getAuthority().equals("ADMIN"))){
                view = View.Admin.class;
            }
        }
        bodyContainer.setSerializationView(view);
    }
}
