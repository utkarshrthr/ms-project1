package com.utkarshrthr.app.user.controller;

import com.utkarshrthr.app.user.dto.UserRequest;
import com.utkarshrthr.app.user.dto.UserResponse;
import com.utkarshrthr.app.user.service.UserService;
import com.utkarshrthr.app.util.ApiResponse;
import com.utkarshrthr.app.util.AppConstants;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AppConstants.API_VERSION + "/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserRequest request){
        String message = service.createUser(request);

        // TODO -> Add HATEOAS

        return ApiResponse.getResponse(HttpStatus.CREATED, message);
    }

    @PutMapping("{username}")
    public ResponseEntity<Object> updateUser(@RequestBody @Valid UserRequest request, @PathVariable String username){
        // Locale can be received by @RequestHeader(name = "Accept-Language") OR LocaleContextHolder.getLocale
        String message = service.updateUser(request);
        return ApiResponse.getResponse(HttpStatus.OK, message);
    }

    @GetMapping(value = "{username}", params = "version=1", headers = "X-API-VERSION=1", produces = "application/vnd.company.app-v1+json")
    public ResponseEntity<Object> getUserV1(@PathVariable String username){
        UserResponse user = service.getUserById(username);
        return ApiResponse.getResponse(HttpStatus.OK, user);
    }

    @GetMapping(value = "{username}", params = "version=2", headers = "X-API-VERSION=2", produces = "application/vnd.company.app-v1+json")  // this value can be received in request-parameters
    public ResponseEntity<Object> getUserV2(@PathVariable String username){

        // TODO -> Versioning:
        /*
        * Create 2 APIs, each representing a different version.
        *   URI versioning: Used by twitter
        *        @GetMapping(value = "/v1/{username}")  -> Call different version through different end-points.
        *   Parameter versioning: Used by amazon
        *        @GetMapping(value = "{username}", params = "version=1") -> Call different version through request param values.
        *   (Custom) Header Versioning: Used by Microsoft
        *        @GetMapping(value = "{username}", headers = "X-API-VERSION=1") -> Call different version through setting values for 'X-API-VERSION' header.
        *   Accept Header Versioning OR Mime-type versioning OR Media-type Versioning: Used by Github
        *        @GetMapping(value = "{username}", produces = "application/vnd.company.app-v1+json") -> Call different version through setting values (application/vnd.company.app-v1+json) for 'Accept' header.
        *
        *   1. URI Pollution: uri/request-param versioning
        *   2. Http Headers misuse
        *   3. Caching is difficult for header versioning because URL will be same for different versions
        *   4. Also in header-based versioning request can not be executed on browser, as we can't update header values.
        *   5. Complex API documentation
        * */

        UserResponse user = service.getUserById(username);
        return ApiResponse.getResponse(HttpStatus.OK, user);
    }

    @GetMapping
    public ResponseEntity<Object> getAllUser(){
        // TODO -> Provide implementation to return both XML & JSON response
        List<UserResponse> users = service.getAllUsers();
        return ApiResponse.getResponse(HttpStatus.OK, users);
    }

    @GetMapping("search")
    public ResponseEntity<Object> searchUser(@RequestParam String query){
        List<UserResponse> users = service.searchUsers(query);
        return ApiResponse.getResponse(HttpStatus.OK, users);
    }

    @DeleteMapping("{username}")
    public ResponseEntity<Object> deleteUser(@PathVariable String username){
        String message = service.deleteUser(username);
        return ApiResponse.getResponse(HttpStatus.OK, message);
    }
}
