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
import hu.rr.client.user.routereading.ui.Projects.ProjectsPresenter;
import hu.rr.client.user.routereading.ui.RouteReadingDetails.RouteReadingDetailsFragment;
import hu.rr.client.user.routereading.ui.RouteReadingDetails.RouteReadingDetailsPresenter;
import hu.rr.client.user.routereading.ui.RouteReadingList.RouteReadingListFragment;
import hu.rr.client.user.routereading.ui.RouteReadingList.RouteReadingListPresenter;
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

    void inject(RouteReadingListFragment routeReadingListFragment);

    void inject(RouteReadingDetailsFragment routeReadingDetailsFragment);

    void inject(AuthInteractor authInteractor);

    void inject(RouteReadingInteractor routeReadingInteractor);

    void inject(LoginPresenter loginPresenter);

    void inject(ProjectsActivity projectsActivity);

    void inject(ProjectsPresenter projectsPresenter);

    void inject(RouteReadingListPresenter routeReadingListPresenter);

    void inject(RouteReadingDetailsPresenter routeReadingDetailsPresenter);
}
