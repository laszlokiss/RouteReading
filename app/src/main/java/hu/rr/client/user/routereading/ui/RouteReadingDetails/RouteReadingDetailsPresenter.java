package hu.rr.client.user.routereading.ui.RouteReadingDetails;

import javax.inject.Inject;

import hu.rr.client.user.routereading.RouteReadingApplication;
import hu.rr.client.user.routereading.interactor.RouteReading.RouteReadingInteractor;
import hu.rr.client.user.routereading.model.RouteReading;
import hu.rr.client.user.routereading.ui.Presenter;

/**
 * Created by Laci on 2016.04.25..
 */
public class RouteReadingDetailsPresenter extends Presenter<RouteReadingDetailsScreen> {

    @Inject
    protected RouteReadingInteractor routeReadingInteractor;

    public RouteReadingDetailsPresenter() {
        RouteReadingApplication.injector.inject(this);
    }

    public void addRouteReading(RouteReading routeReading) {
        try {
            routeReadingInteractor.addRouteReadingNetwork(routeReading);
        } catch (Exception e) {
            routeReadingInteractor.addRouteReadingDB(routeReading);
        }
    }

    public void modifyRouteReading(RouteReading routeReading) {
        try {
            routeReadingInteractor.modifyRouteReadingNetwork(routeReading);
        } catch (Exception e) {
            routeReadingInteractor.modifyRouteReadingDB(routeReading);
        }
    }

    public void deleteRouteReading(RouteReading routeReading) {
        try {
            routeReadingInteractor.deleteRouteReadingNetwork(routeReading);
        } catch (Exception e) {
            routeReadingInteractor.deleteRouteReadingDB(routeReading);
        }
    }
}
