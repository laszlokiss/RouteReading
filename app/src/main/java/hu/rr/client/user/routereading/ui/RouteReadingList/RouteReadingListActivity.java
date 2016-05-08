package hu.rr.client.user.routereading.ui.RouteReadingList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import hu.rr.client.user.routereading.RouteReadingApplication;

/**
 * Created by Laci on 2016.04.25..
 */
public class RouteReadingListActivity extends AppCompatActivity implements RouteReadingListScreen {

    @Inject
    RouteReadingListPresenter routeReadingListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RouteReadingApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        routeReadingListPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        routeReadingListPresenter.detachScreen();
    }
}
