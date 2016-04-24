package hu.rr.client.user.routereading.ui.Login;

import hu.rr.client.user.routereading.ui.Presenter;

/**
 * Created by Laci on 2016.04.24..
 */
public class LoginPresenter extends Presenter<LoginScreen> {

    public void login(String username, String password) {
        screen.navigateToProjectsList();
        //TODO
    }

}
