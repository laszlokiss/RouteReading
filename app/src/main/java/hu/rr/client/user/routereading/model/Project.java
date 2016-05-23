package hu.rr.client.user.routereading.model;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Laci on 2016.04.18..
 */
public class Project extends SugarRecord implements Serializable {
    @SerializedName("id")
    private String projectId = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("startdate")
    private Date startdate = null;

    @SerializedName("enddate")
    private Date enddate = null;

    @SerializedName("vehicles")
    private List<Vehicle> vehicles = new ArrayList<Vehicle>();

    @SerializedName("users")
    private List<User> users = new ArrayList<User>();

    @SerializedName("routereadings")
    private List<RouteReading> routereadings = new ArrayList<RouteReading>();

    public Project(String projectId, String name, Date startdate, Date enddate, List<Vehicle> vehicles, List<User> users, List<RouteReading> routeReadings) {
        this.projectId = projectId;
        this.name = name;
        this.startdate = startdate;
        this.enddate = enddate;
        this.vehicles = vehicles;
        this.users = users;
        this.routereadings = routeReadings;
    }

    /**
     **/
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }


    /**
     **/
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    /**
     **/
    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }


    /**
     **/
    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }


    /**
     **/
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }


    /**
     **/
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


    /**
     **/
    public List<RouteReading> getRoutereadings() {
        return routereadings;
    }

    public void setRoutereadings(List<RouteReading> routereadings) {
        this.routereadings = routereadings;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Project project = (Project) o;
        return projectId.equals(project.projectId) &&
                name.equals(project.name) &&
                startdate.equals(project.startdate) &&
                enddate.equals(project.enddate) &&
                vehicles.equals(project.vehicles) &&
                users.equals(project.users) &&
                routereadings.equals(project.routereadings);
    }

    @Override
    public int hashCode() {
        return projectId.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Project {\n");

        sb.append("    id: ").append(toIndentedString(projectId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    startdate: ").append(toIndentedString(startdate)).append("\n");
        sb.append("    enddate: ").append(toIndentedString(enddate)).append("\n");
        sb.append("    vehicles: ").append(toIndentedString(vehicles)).append("\n");
        sb.append("    users: ").append(toIndentedString(users)).append("\n");
        sb.append("    routereadings: ").append(toIndentedString(routereadings)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
