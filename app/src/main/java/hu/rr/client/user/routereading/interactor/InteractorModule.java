package hu.rr.client.user.routereading.interactor;

import dagger.Module;
import dagger.Provides;
import hu.rr.client.user.routereading.interactor.Auth.AuthInteractor;
import hu.rr.client.user.routereading.interactor.Project.ProjectsInteractor;
import hu.rr.client.user.routereading.interactor.RouteReading.RouteReadingInteractor;

/**
 * Created by Laci on 2016.04.18..
 */
@Module
public class InteractorModule {

    @Provides
    public AuthInteractor provideAuthInteractor() {
        return new AuthInteractor();
    }

    @Provides
    public ProjectsInteractor provideProjectsInteractor() {
        return new ProjectsInteractor();
    }

    @Provides
    public RouteReadingInteractor provideRouteReadingInteractor() {
        return new RouteReadingInteractor();
    }
}
