package hu.rr.client.user.routereading.repository;

import android.content.Context;

import hu.rr.client.user.routereading.model.User;

/**
 * Created by Laci on 2016.05.08..
 */
public interface Repository {

    void initialize(Context context);

    void terminate();

    void login(User user);

}
