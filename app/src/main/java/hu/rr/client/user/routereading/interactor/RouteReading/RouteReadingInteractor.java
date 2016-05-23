package hu.rr.client.user.routereading.interactor.RouteReading;

import javax.inject.Inject;

import hu.rr.client.user.routereading.RouteReadingApplication;
import hu.rr.client.user.routereading.model.RouteReading;
import hu.rr.client.user.routereading.network.RoutereadingApi;
import hu.rr.client.user.routereading.repository.Repository;
import retrofit2.Response;

/**
 * Created by Laci on 2016.05.08..
 */
public class RouteReadingInteractor {

    @Inject
    RoutereadingApi routeReadingApi;

    @Inject
    Repository repository;

    public RouteReadingInteractor() {
        RouteReadingApplication.injector.inject(this);
    }


    public void deleteRouteReadingNetwork(RouteReading selectedItem) throws Exception {
        Response<Void> response;
        try {
            response = routeReadingApi.routereadingDelete(selectedItem.getRouteReadingId()).execute();
        } catch (Exception e) {
            throw new Exception("Network error!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error!");
        }
    }

    public void deleteRouteReadingDB(RouteReading selectedItem) {
        repository.deleteRouteReading(selectedItem.getRouteReadingId());
    }

    public void addRouteReadingNetwork(RouteReading routeReading) throws Exception {
        Response<RouteReading> response;
        try {
            response = routeReadingApi.routereadingPost(routeReading).execute();
        } catch (Exception e) {
            throw new Exception("Network error!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error!");
        }
    }

    public void addRouteReadingDB(RouteReading routeReading) {
        repository.addRouteReading(routeReading);
    }

    public void modifyRouteReadingNetwork(RouteReading routeReading) throws Exception {
        Response<RouteReading> response;
        try {
            response = routeReadingApi.routereadingPost(routeReading).execute();
        } catch (Exception e) {
            throw new Exception("Network error!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error!");
        }
    }

    public void modifyRouteReadingDB(RouteReading routeReading) {
        repository.modifyRouteReading(routeReading);
    }
}
