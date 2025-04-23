//package org.example.ecommerce.Common;
//
//
//import org.example.ecommerce.DTO.UserDto;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//@Component
//
//public class AuthCommon {
//    private RestTemplate restTemplate;
//
//    public AuthCommon (RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    public UserDto validateToken(String tokenValue) {
//        ResponseEntity<UserDto> userDtoResponseEntity=
//                restTemplate.getForEntity("http://localhost:8080/users/validate/"+tokenValue,
//                        UserDto.class);
//        if(userDtoResponseEntity.getBody()==null){
//            throw new RuntimeException("Invalid Token");
//        }
//        return userDtoResponseEntity.getBody();
//    }
//}
