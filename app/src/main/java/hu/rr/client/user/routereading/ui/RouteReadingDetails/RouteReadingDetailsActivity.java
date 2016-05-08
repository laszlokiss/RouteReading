package hu.rr.client.user.routereading.ui.RouteReadingDetails;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import hu.rr.client.user.routereading.RouteReadingApplication;

/**
 * Created by Laci on 2016.04.25..
 */
public class RouteReadingDetailsActivity extends AppCompatActivity implements RouteReadingDetailsScreen {

    @Inject
    RouteReadingDetailsPresenter routeReadingDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RouteReadingApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        routeReadingDetailsPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        routeReadingDetailsPresenter.detachScreen();
    }

}
