package hu.rr.client.user.routereading.interactor.Auth;

import javax.inject.Inject;

import hu.rr.client.user.routereading.RouteReadingApplication;
import hu.rr.client.user.routereading.model.User;
import hu.rr.client.user.routereading.repository.Repository;

/**
 * Created by Laci on 2016.05.08..
 */
public class AuthInteractor {

    @Inject
    Repository repository;

    public AuthInteractor() {
        RouteReadingApplication.injector.inject(this);
    }

    public void login(User user) {
        repository.login(user);
    }
}
