package hu.rr.client.user.routereading.interactor.projects;

import javax.inject.Inject;

import hu.rr.client.user.routereading.RouteReadingApplication;
import hu.rr.client.user.routereading.network.ProjectsApi;

/**
 * Created by Laci on 2016.04.24..
 */
public class ProjectsInteractor {

    @Inject
    ProjectsApi projectsApi;

    public ProjectsInteractor() {
        RouteReadingApplication.injector.inject(this);
    }

    public void getProjects() {
        // TODO
    }

}
