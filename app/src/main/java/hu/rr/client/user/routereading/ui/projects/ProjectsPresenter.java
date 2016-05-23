package hu.rr.client.user.routereading.ui.Projects;

import java.util.List;

import javax.inject.Inject;

import hu.rr.client.user.routereading.RouteReadingApplication;
import hu.rr.client.user.routereading.interactor.Project.ProjectsInteractor;
import hu.rr.client.user.routereading.model.Project;
import hu.rr.client.user.routereading.ui.Presenter;

/**
 * Created by Laci on 2016.04.24..
 */
public class ProjectsPresenter extends Presenter<ProjectsScreen> {

    @Inject
    protected ProjectsInteractor projectsInteractor;

    public ProjectsPresenter() {
        RouteReadingApplication.injector.inject(this);
    }

    public void getAllProjects() {
        List<Project> projects;
        try {
            projects = projectsInteractor.getProjectsFromNetwork();
        } catch (Exception e) {
            projects = projectsInteractor.getProjectsFromDB();
        }
        screen.showProjectsList(projects);
    }
}
