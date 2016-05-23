package hu.rr.client.user.routereading.ui.RouteReadingList;

import javax.inject.Inject;

import hu.rr.client.user.routereading.RouteReadingApplication;
import hu.rr.client.user.routereading.interactor.RouteReading.RouteReadingInteractor;
import hu.rr.client.user.routereading.ui.Presenter;

/**
 * Created by Laci on 2016.04.25..
 */
public class RouteReadingListPresenter extends Presenter<RouteReadingListScreen> {

    @Inject
    protected RouteReadingInteractor routeReadingInteractor;

    public RouteReadingListPresenter() {
        RouteReadingApplication.injector.inject(this);
    }


}
