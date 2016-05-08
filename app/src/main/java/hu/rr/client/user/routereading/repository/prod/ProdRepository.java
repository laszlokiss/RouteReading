package hu.rr.client.user.routereading.repository.prod;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import hu.rr.client.user.routereading.model.User;
import hu.rr.client.user.routereading.repository.Repository;

/**
 * Created by Laci on 2016.05.08..
 */
public class ProdRepository implements Repository {

    @Override
    public void initialize(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void terminate() {
        SugarContext.terminate();
    }

    @Override
    public void login(User user) {
        SugarRecord.save(user);
    }
}
