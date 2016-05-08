package hu.rr.client.user.routereading;

import android.app.Application;

import javax.inject.Inject;

import hu.rr.client.user.routereading.repository.Repository;
import hu.rr.client.user.routereading.ui.UIModule;

/**
 * Created by Laci on 2016.04.18..
 */
public class RouteReadingApplication extends Application {

    @Inject
    Repository repository;

    public static RouteReadingApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.MOCK) {
            injector = DaggerMockRouteReadingApplicationComponent.builder().uIModule(
                    new UIModule(this)
            ).build();
        } else {
            injector = DaggerRouteReadingApplicationComponent.builder().uIModule(
                    new UIModule(this)
            ).build();
        }
        injector.inject(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        repository.terminate();
    }
}
