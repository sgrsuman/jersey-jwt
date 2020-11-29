package com.cassiomolin.example.common.api.config;

import com.cassiomolin.example.common.api.provider.ObjectMapperProvider;
import com.cassiomolin.example.security.api.exeptionmapper.AccessDeniedExceptionMapper;
import com.cassiomolin.example.security.api.exeptionmapper.AuthenticationExceptionMapper;
import com.cassiomolin.example.security.api.exeptionmapper.AuthenticationTokenRefreshmentExceptionMapper;
import com.cassiomolin.example.security.api.filter.AuthenticationFilter;
import com.cassiomolin.example.security.api.filter.AuthorizationFilter;
import com.cassiomolin.example.security.api.resource.AuthenticationResource;
import com.cassiomolin.example.user.api.resource.AccountResource;
import com.cassiomolin.example.user.api.resource.AddUser;
import com.cassiomolin.example.user.api.resource.AuthResource;
import com.cassiomolin.example.user.api.resource.CreateAccount;
import com.cassiomolin.example.user.api.resource.DeleteUser;
import com.cassiomolin.example.user.api.resource.FindBalance;
import com.cassiomolin.example.user.api.resource.Interest;
import com.cassiomolin.example.user.api.resource.TransferMoney;
import com.cassiomolin.example.user.api.resource.UpdateBalance;
import com.cassiomolin.example.user.api.resource.UpdateKYC;
import com.cassiomolin.example.user.api.resource.UserResource;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Jersey configuration class.
*/
@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {

        register(AuthenticationResource.class);
        register(UserResource.class);
        register(AccountResource.class);
        register(DeleteUser.class);
        register(AddUser.class);
        register(FindBalance.class);
        register(Interest.class);
        register(UpdateBalance.class);
        register(UpdateKYC.class);
        register(TransferMoney.class);
        register(CreateAccount.class);
        register(AuthResource.class);
        register(AuthenticationFilter.class);
        register(AuthorizationFilter.class);

        register(AccessDeniedExceptionMapper.class);
        register(AuthenticationExceptionMapper.class);
        register(AuthenticationTokenRefreshmentExceptionMapper.class);

        register(ObjectMapperProvider.class);
    }
}