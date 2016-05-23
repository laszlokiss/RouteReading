package hu.rr.client.user.routereading.ui.Projects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hu.rr.client.user.routereading.R;
import hu.rr.client.user.routereading.model.Project;

/**
 * Created by Laci on 2016.04.24..
 */
public class ProjectsAdapter extends BaseAdapter {

    private Context context;
    private List<Project> projectList;
    private static LayoutInflater inflater;

    public ProjectsAdapter(Context context, List<Project> projects) {
        this.context = context;
        this.projectList = projects;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return projectList.size();
    }

    @Override
    public Object getItem(int position) {
        return projectList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return projectList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view==null) {
            inflater.inflate(R.layout.project_list_item, null);
        }

        TextView projectName = (TextView) view.findViewById(R.id.projectName);
        TextView startDate = (TextView) view.findViewById(R.id.startDate);
        TextView endDate = (TextView) view.findViewById(R.id.endDate);

        Project currentItem = projectList.get(position);

        projectName.setText(currentItem.getName());
        startDate.setText(currentItem.getStartdate().toString());
        endDate.setText(currentItem.getEnddate().toString());

        return view;
    }
}
