package hu.rr.client.user.routereading.ui.Projects;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import hu.rr.client.user.routereading.R;
import hu.rr.client.user.routereading.RouteReadingApplication;
import hu.rr.client.user.routereading.model.Project;
import hu.rr.client.user.routereading.ui.RouteReadingList.RouteReadingListFragment;

public class ProjectsActivity extends AppCompatActivity implements ProjectsScreen {

    @Inject
    ProjectsPresenter projectsPresenter;

    @Bind(R.id.projectList)
    ListView listView;

    List<Project> projectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        RouteReadingApplication.injector.inject(this);
        ButterKnife.bind(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onItemClicked(position);
            }
        });
        this.projectList = new ArrayList<Project>();
        this.fillProjectsList();
    }

    private void onItemClicked(int position) {
        Fragment fragment = new RouteReadingListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("project", projectList.get(position));
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainContent, fragment).commit();
        this.setTitle(projectList.get(position).getName());
    }

    private void fillProjectsList() {
        projectsPresenter.getAllProjects();
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

    @Override
    public void showProjectsList(List<Project> projects) {
        projectList = projects;
        listView.setAdapter(new ProjectsAdapter(getApplicationContext(), projects));
    }
}
