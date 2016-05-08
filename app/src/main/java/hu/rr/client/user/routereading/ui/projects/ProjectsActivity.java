package hu.rr.client.user.routereading.ui.Projects;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import hu.rr.client.user.routereading.RouteReadingApplication;

/**
 * Created by Laci on 2016.04.24..
 */
public class ProjectsActivity extends AppCompatActivity implements ProjectsScreen {

    @Inject
    ProjectsPresenter projectsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RouteReadingApplication.injector.inject(this);
        // TODO
    }

    @Override
    protected void onStart() {
        super.onStart();
        projectsPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        projectsPresenter.detachScreen();
    }

}
