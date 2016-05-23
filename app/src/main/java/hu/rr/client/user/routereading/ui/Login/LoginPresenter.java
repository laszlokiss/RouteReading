package hu.rr.client.user.routereading.ui.Login;

import javax.inject.Inject;

import hu.rr.client.user.routereading.RouteReadingApplication;
import hu.rr.client.user.routereading.interactor.Auth.AuthInteractor;
import hu.rr.client.user.routereading.model.User;
import hu.rr.client.user.routereading.ui.Presenter;

/**
 * Created by Laci on 2016.04.24..
 */
public class LoginPresenter extends Presenter<LoginScreen> {

    @Inject
    AuthInteractor authInteractor;

    @Override
    public void attachScreen(LoginScreen screen) {
        super.attachScreen(screen);
        RouteReadingApplication.injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void login(String username, String password) {
        User user = new User(username, password);
        User loggedInUser;
        try {
            loggedInUser = authInteractor.login(user);
        } catch (Exception e) {
            loggedInUser = authInteractor.loginFromDB(user);
        }
        if (user != null) {
            screen.navigateToProjectsList();
        }
    }

}
