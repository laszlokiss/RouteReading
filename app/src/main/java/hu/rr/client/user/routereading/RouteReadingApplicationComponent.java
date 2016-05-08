package hu.rr.client.user.routereading;

import javax.inject.Singleton;

import dagger.Component;
import hu.rr.client.user.routereading.interactor.Auth.AuthInteractor;
import hu.rr.client.user.routereading.interactor.InteractorModule;
import hu.rr.client.user.routereading.interactor.Project.ProjectsInteractor;
import hu.rr.client.user.routereading.interactor.RouteReading.RouteReadingInteractor;
import hu.rr.client.user.routereading.network.NetworkModule;
import hu.rr.client.user.routereading.repository.prod.ProdRepositoryModule;
import hu.rr.client.user.routereading.ui.Login.LoginActivity;
import hu.rr.client.user.routereading.ui.Login.LoginPresenter;
import hu.rr.client.user.routereading.ui.Projects.ProjectsActivity;
import hu.rr.client.user.routereading.ui.RouteReadingDetails.RouteReadingDetailsActivity;
import hu.rr.client.user.routereading.ui.RouteReadingList.RouteReadingListActivity;
import hu.rr.client.user.routereading.ui.UIModule;

/**
 * Created by Laci on 2016.04.18..
 */
@Singleton
@Component(modules = {UIModule.class, NetworkModule.class, ProdRepositoryModule.class, InteractorModule.class})
public interface RouteReadingApplicationComponent {

    void inject(RouteReadingApplication routeReadingApplication);

    void inject(ProjectsInteractor projectsInteractor);

    void inject(LoginActivity loginActivity);

    void inject(RouteReadingListActivity routeReadingListActivity);

    void inject(RouteReadingDetailsActivity routeReadingDetailsActivity);

    void inject(AuthInteractor authInteractor);

    void inject(RouteReadingInteractor routeReadingInteractor);

    void inject(LoginPresenter loginPresenter);

    void inject(ProjectsActivity projectsActivity);
}
