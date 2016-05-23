package hu.rr.client.user.routereading.interactor.Auth;

import javax.inject.Inject;

import hu.rr.client.user.routereading.RouteReadingApplication;
import hu.rr.client.user.routereading.model.User;
import hu.rr.client.user.routereading.network.AuthApi;
import hu.rr.client.user.routereading.repository.Repository;
import retrofit2.Response;

/**
 * Created by Laci on 2016.05.08..
 */
public class AuthInteractor {

    @Inject
    AuthApi authApi;

    @Inject
    Repository repository;

    public AuthInteractor() {
        RouteReadingApplication.injector.inject(this);
    }

    public User login(User user) throws Exception {
        Response<User> response;
        try {
            response = authApi.loginPost(user).execute();
        } catch (Exception e) {
            throw new Exception("Network error!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error!");
        }
        return response.body();
    }

    public User loginFromDB(User user) {
        return repository.login(user);
    }
}
