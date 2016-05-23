package hu.rr.client.user.routereading.interactor.Project;

import java.util.List;

import javax.inject.Inject;

import hu.rr.client.user.routereading.RouteReadingApplication;
import hu.rr.client.user.routereading.model.Project;
import hu.rr.client.user.routereading.network.ProjectApi;
import hu.rr.client.user.routereading.repository.Repository;
import retrofit2.Response;

/**
 * Created by Laci on 2016.04.24..
 */
public class ProjectsInteractor {

    @Inject
    ProjectApi projectsApi;

    @Inject
    Repository repository;

    public ProjectsInteractor() {
        RouteReadingApplication.injector.inject(this);
    }

    public List<Project> getProjectsFromNetwork() throws Exception {
        Response<List<Project>> response;
        try {
            response = projectsApi.projectsGet().execute();
        } catch (Exception e) {
            throw new Exception("Network error!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error!");
        }
        return response.body();
    }

    public List<Project> getProjectsFromDB() {

        return repository.getProjects();
    }
}
