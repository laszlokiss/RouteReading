package hu.rr.client.user.routereading;

import javax.inject.Singleton;

import dagger.Component;
import hu.rr.client.user.routereading.interactor.InteractorModule;
import hu.rr.client.user.routereading.interactor.projects.ProjectsInteractor;
import hu.rr.client.user.routereading.network.NetworkModule;
import hu.rr.client.user.routereading.ui.Login.LoginActivity;
import hu.rr.client.user.routereading.ui.UIModule;

/**
 * Created by Laci on 2016.04.18..
 */
@Singleton
@Component(modules = {UIModule.class, NetworkModule.class, InteractorModule.class})
public interface RouteReadingApplicationComponent {

    void inject(ProjectsInteractor projectsInteractor);

    void inject(LoginActivity loginActivity);

}
