package hu.rr.client.user.routereading.repository.mock;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hu.rr.client.user.routereading.model.Project;
import hu.rr.client.user.routereading.model.RouteReading;
import hu.rr.client.user.routereading.model.User;
import hu.rr.client.user.routereading.model.Vehicle;
import hu.rr.client.user.routereading.repository.Repository;

/**
 * Created by Laci on 2016.05.08..
 */
public class MockRepository implements Repository {

    List<User> users;

    List<Project> projects;

    List<Vehicle> vehicles;

    List<RouteReading> routeReadings;

    public void initialize(Context context) {
        users = new ArrayList<User>();
        users.add(new User("userId1", "user1", "pass1"));
        users.add(new User("userId2", "user2", "pass2"));
        users.add(new User("userId3", "user3", "pass3"));
        users.add(new User("userId4", "user4", "pass4"));
        users.add(new User("userId5", "user5", "pass5"));

        vehicles = new ArrayList<Vehicle>();
        vehicles.add(new Vehicle("vehicleId1", "ABC123"));
        vehicles.add(new Vehicle("vehicleId2", "CBX111"));
        vehicles.add(new Vehicle("vehicleId3", "QDG444"));
        vehicles.add(new Vehicle("vehicleId4", "DIW653"));

        routeReadings = new ArrayList<RouteReading>();
        routeReadings.add(new RouteReading("rrId1", users.get(0), vehicles.get(0), new Date(), "Budapest", "Pécs", 150));
        routeReadings.add(new RouteReading("rrId2", users.get(1), vehicles.get(1), new Date(), "Debrecen", "Miskolc", 100));
        routeReadings.add(new RouteReading("rrId3", users.get(2), vehicles.get(2), new Date(), "Győr", "Kecskemét", 250));

        projects = new ArrayList<Project>();
        projects.add(new Project("projectId", "projectName", new Date(), new Date(), vehicles, users, routeReadings));
    }

    public void terminate() {
        // Nothing to do
    }

    public User login(User user) {
        for (User item : users) {
            if (item.getName().equals(user.getName()) && item.getPassword().equals(user.getPassword())) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<Project> getProjects() {
        return projects;
    }

    @Override
    public void deleteRouteReading(String routeReadingId) {
        for (RouteReading rr : routeReadings) {
            if (rr.getRouteReadingId().equals(routeReadingId)) {
                routeReadings.remove(rr);
            }
        }
    }

    @Override
    public void addRouteReading(RouteReading routeReading) {
        routeReadings.add(routeReading);
    }

    @Override
    public void modifyRouteReading(RouteReading routeReading) {
        for (RouteReading rr : routeReadings) {
            if (rr.getRouteReadingId().equals(routeReading.getRouteReadingId())) {
                rr = routeReading;
            }
        }
    }

}
