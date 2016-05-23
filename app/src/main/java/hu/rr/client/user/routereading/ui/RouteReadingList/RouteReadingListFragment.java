package hu.rr.client.user.routereading.ui.RouteReadingList;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import javax.inject.Inject;

import hu.rr.client.user.routereading.R;
import hu.rr.client.user.routereading.RouteReadingApplication;
import hu.rr.client.user.routereading.model.Project;
import hu.rr.client.user.routereading.model.RouteReading;
import hu.rr.client.user.routereading.ui.RouteReadingDetails.RouteReadingDetailsFragment;

/**
 * Created by Laci on 2016.04.25..
 */
public class RouteReadingListFragment extends Fragment implements RouteReadingListScreen {

    private ListView listView;
    private Project project;
    private List<RouteReading> routeReadings;

    @Inject
    RouteReadingListPresenter routeReadingListPresenter;

    public RouteReadingListFragment() {
        RouteReadingApplication.injector.inject(this);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle inState) {
        View view = inflater.inflate(R.layout.routereading_list, container, false);
        project = (Project) this.getArguments().getSerializable("project");
        routeReadings = project.getRoutereadings();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onItemClicked(position);
            }
        });

        Button newButton = (Button) view.findViewById(R.id.newButton);
        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNewButtonClicked();
            }
        });


        listView.setAdapter(new RouteReadingsAdapter(getContext(), routeReadings));
        return view;
    }


    private void onNewButtonClicked() {
        RouteReading newItem = new RouteReading();
        this.navigateToDetailsFragment(newItem);
    }

    private void onItemClicked(int position) {
        RouteReading selectedItem = routeReadings.get(position);
        this.navigateToDetailsFragment(selectedItem);
    }

    private void navigateToDetailsFragment(RouteReading routeReading) {
        Fragment fragment = new RouteReadingDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("routereading", routeReading);
        bundle.putSerializable("project", project);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainContent, fragment).commit();
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        routeReadingListPresenter.attachScreen(this);
    }

    @Override
    public void onDetach() {
        routeReadingListPresenter.detachScreen();
        super.onDetach();
    }
}
