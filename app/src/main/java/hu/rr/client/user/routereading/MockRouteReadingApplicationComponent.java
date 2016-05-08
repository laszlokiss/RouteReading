package hu.rr.client.user.routereading;

import javax.inject.Singleton;

import dagger.Component;
import hu.rr.client.user.routereading.interactor.InteractorModule;
import hu.rr.client.user.routereading.network.NetworkModule;
import hu.rr.client.user.routereading.repository.mock.MockRepositoryModule;
import hu.rr.client.user.routereading.ui.UIModule;

/**
 * Created by Laci on 2016.05.08..
 */
@Singleton
@Component(modules = {UIModule.class, NetworkModule.class, MockRepositoryModule.class, InteractorModule.class})
public interface MockRouteReadingApplicationComponent extends RouteReadingApplicationComponent {
}
