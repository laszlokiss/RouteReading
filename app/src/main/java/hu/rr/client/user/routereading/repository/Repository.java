package hu.rr.client.user.routereading.repository;

import android.content.Context;

import java.util.List;

import hu.rr.client.user.routereading.model.Project;
import hu.rr.client.user.routereading.model.RouteReading;
import hu.rr.client.user.routereading.model.User;

/**
 * Created by Laci on 2016.05.08..
 */
public interface Repository {

    void initialize(Context context);

    void terminate();

    User login(User user);

    List<Project> getProjects();

    void deleteRouteReading(String routeReadingId);

    void addRouteReading(RouteReading routeReading);

    void modifyRouteReading(RouteReading routeReading);
}
