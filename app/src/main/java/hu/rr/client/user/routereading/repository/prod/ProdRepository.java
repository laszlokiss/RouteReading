package hu.rr.client.user.routereading.repository.prod;

import android.content.Context;

import com.orm.SugarContext;

import java.util.List;

import hu.rr.client.user.routereading.model.Project;
import hu.rr.client.user.routereading.model.RouteReading;
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
    public User login(User user) {
        List<User> users = User.find(User.class, "name = ? and password = ?", user.getName(), user.getPassword());
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public List<Project> getProjects() {
        return Project.listAll(Project.class);
    }

    @Override
    public void deleteRouteReading(String routeReadingId) {
        List<RouteReading> routeReadings = RouteReading.find(RouteReading.class, "routeReadingId = ?", routeReadingId);
        for (RouteReading routeReading : routeReadings) {
            routeReading.delete();
        }
    }

    @Override
    public void addRouteReading(RouteReading routeReading) {
        RouteReading.save(routeReading);
    }

    @Override
    public void modifyRouteReading(RouteReading routeReading) {
        RouteReading.save(routeReading);
    }
}
