package hu.rr.client.user.routereading.ui.RouteReadingList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hu.rr.client.user.routereading.R;
import hu.rr.client.user.routereading.model.RouteReading;

/**
 * Created by Laci on 2016.05.23..
 */
public class RouteReadingsAdapter extends BaseAdapter {

    private Context context;
    private List<RouteReading> routeReadingList;
    private static LayoutInflater inflater;

    public RouteReadingsAdapter(Context context, List<RouteReading> routeReadings) {
        this.context = context;
        this.routeReadingList = routeReadings;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return routeReadingList.size();
    }

    @Override
    public Object getItem(int position) {
        return routeReadingList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return routeReadingList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            inflater.inflate(R.layout.routereading_list_item, null);
        }

        TextView originAndDest = (TextView) view.findViewById(R.id.originAndDest);
        TextView driverName = (TextView) view.findViewById(R.id.driverName);
        TextView travelDate = (TextView) view.findViewById(R.id.travelDate);

        RouteReading currentItem = routeReadingList.get(position);

        originAndDest.setText(currentItem.getFrom() + "->" + currentItem.getDestination());
        driverName.setText(currentItem.getDriver().getName());
        travelDate.setText(currentItem.getDate().toString());
        return view;
    }
}
