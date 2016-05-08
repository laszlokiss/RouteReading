package hu.rr.client.user.routereading.interactor.RouteReading;

import hu.rr.client.user.routereading.RouteReadingApplication;

/**
 * Created by Laci on 2016.05.08..
 */
public class RouteReadingInteractor {

    public RouteReadingInteractor() {
        RouteReadingApplication.injector.inject(this);
    }


}
