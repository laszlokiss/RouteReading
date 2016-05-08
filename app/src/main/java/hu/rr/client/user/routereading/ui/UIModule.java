package hu.rr.client.user.routereading.ui;

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.rr.client.user.routereading.di.Database;
import hu.rr.client.user.routereading.di.Network;
import hu.rr.client.user.routereading.ui.Login.LoginPresenter;
import hu.rr.client.user.routereading.ui.Projects.ProjectsPresenter;
import hu.rr.client.user.routereading.ui.RouteReadingDetails.RouteReadingDetailsPresenter;
import hu.rr.client.user.routereading.ui.RouteReadingList.RouteReadingListPresenter;

/**
 * Created by Laci on 2016.04.19..
 */
@Module
public class UIModule {

    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    @Network
    public Executor provideNetworkExecutor() {
        return Executors.newFixedThreadPool(1);
    }

    @Provides
    @Singleton
    @Database
    public Executor provideDatabaseExecutor() {
        return Executors.newFixedThreadPool(1);
    }

    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter() {
        return new LoginPresenter();
    }

    @Provides
    @Singleton
    public RouteReadingListPresenter provideRouteReadingListPresenter() {
        return new RouteReadingListPresenter();
    }

    @Provides
    @Singleton
    public RouteReadingDetailsPresenter provideRouteReadingDetailsPresenter() {
        return new RouteReadingDetailsPresenter();
    }

    @Provides
    @Singleton
    public ProjectsPresenter provideProjectsPresenter() {
        return new ProjectsPresenter();
    }


}
