package com.cassiomolin.example.user.api.model;

import com.cassiomolin.example.security.domain.Authority;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * API model for returning user details.
 */
@JsonInclude(Include.NON_NULL)
public class QueryUserResult {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private Set<Authority> authorities;

    public QueryUserResult() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

}