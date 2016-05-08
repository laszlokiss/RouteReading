package hu.rr.client.user.routereading.repository.mock;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import hu.rr.client.user.routereading.model.User;
import hu.rr.client.user.routereading.repository.Repository;

/**
 * Created by Laci on 2016.05.08..
 */
public class MockRepository implements Repository {

    List<User> users;

    public void initialize(Context context) {
        users = new ArrayList<User>();

        users.add(new User("user1", "pass1"));
        users.add(new User("user2", "pass2"));
        users.add(new User("user3", "pass3"));
        users.add(new User("user4", "pass4"));
        users.add(new User("user5", "pass5"));
    }

    public void terminate() {
        // Nothing to do
    }

    public void login(User user) {
        users.add(user);
    }

}
