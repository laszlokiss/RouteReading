package hu.rr.client.user.routereading.ui.RouteReadingDetails;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import hu.rr.client.user.routereading.R;
import hu.rr.client.user.routereading.RouteReadingApplication;
import hu.rr.client.user.routereading.model.Project;
import hu.rr.client.user.routereading.model.RouteReading;
import hu.rr.client.user.routereading.model.User;
import hu.rr.client.user.routereading.model.Vehicle;

/**
 * Created by Laci on 2016.04.25..
 */
public class RouteReadingDetailsFragment extends Fragment implements RouteReadingDetailsScreen {

    private RouteReading routeReading;
    private Project project;
    @Inject
    RouteReadingDetailsPresenter routeReadingDetailsPresenter;

    public RouteReadingDetailsFragment() {
        RouteReadingApplication.injector.inject(this);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle inState) {
        View view = inflater.inflate(R.layout.routereading_details, container, false);
        routeReading = ((RouteReading) this.getArguments().getSerializable("routereading"));
        project = (Project) this.getArguments().getSerializable("project");

        // User lista
        final Spinner userSpinner = (Spinner) view.findViewById(R.id.userSpinner);
        List<String> names = new ArrayList<>();
        for (User user : project.getUsers()) {
            names.add(user.getName());
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, names);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userSpinner.setAdapter(dataAdapter);

        // Jármű lista
        final Spinner vehicleSpinner = (Spinner) view.findViewById(R.id.vehicleSpinner);
        List<String> platenumbers = new ArrayList<>();
        for (Vehicle vehicle : project.getVehicles()) {
            platenumbers.add(vehicle.getPlateNumber());
        }
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, platenumbers);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vehicleSpinner.setAdapter(dataAdapter2);

        final EditText actDate = (EditText) view.findViewById(R.id.actDate);
        actDate.setText(
                routeReading.getDate() != null ?
                        routeReading.getDate().toString() :
                        new Date().toString()
        );

        final EditText origin = (EditText) view.findViewById(R.id.origin);
        origin.setText(routeReading.getFrom());

        final EditText dest = (EditText) view.findViewById(R.id.destination);
        dest.setText(routeReading.getDestination());

        final EditText routereading = (EditText) view.findViewById(R.id.routeReading);
        routereading.setText(routeReading.getRoutereading());

        Button doneButton = (Button) view.findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    routeReading.setDate(df.parse(actDate.getText().toString()));
                } catch (Exception e) {
                    routeReading.setDate(new Date());
                }
                routeReading.setDestination(dest.toString());
                routeReading.setDriver((User) userSpinner.getSelectedItem());
                routeReading.setVehicle((Vehicle) vehicleSpinner.getSelectedItem());
                routeReading.setFrom(origin.toString());
                routeReading.setRoutereading(Integer.parseInt(routereading.toString()));
                if (routeReading.getId() == null) {
                    routeReadingDetailsPresenter.addRouteReading(routeReading);
                } else {
                    routeReadingDetailsPresenter.modifyRouteReading(routeReading);
                }
            }
        });

        Button deleteButton = (Button) view.findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                routeReadingDetailsPresenter.deleteRouteReading(routeReading);
            }
        });

        return view;
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        routeReadingDetailsPresenter.attachScreen(this);
    }

    @Override
    public void onDetach() {
        routeReadingDetailsPresenter.detachScreen();
        super.onDetach();
    }

}
