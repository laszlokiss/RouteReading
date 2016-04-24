package hu.rr.client.user.routereading.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Laci on 2016.04.18..
 */
public class Projects {

    @SerializedName("name")
    @Expose
    private String name;

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
