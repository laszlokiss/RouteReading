package hu.rr.client.user.routereading;

import android.app.Application;

import hu.rr.client.user.routereading.ui.UIModule;

/**
 * Created by Laci on 2016.04.18..
 */
public class RouteReadingApplication extends Application {

    public static RouteReadingApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerRouteReadingApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }

}
