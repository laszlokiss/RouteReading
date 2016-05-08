package hu.rr.client.user.routereading.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by Laci on 2016.04.18..
 */
public class Project extends SugarRecord {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("startdate")
    @Expose
    private Date startDate;

    @SerializedName("enddate")
    @Expose
    private Date endDate;

    public Project() {

    }

    public Project(String name, Date startDate, Date endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
