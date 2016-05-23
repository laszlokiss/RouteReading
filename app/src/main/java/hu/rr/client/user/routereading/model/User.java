package hu.rr.client.user.routereading.model;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

/**
 * Created by Laci on 2016.04.25..
 */
public class User extends SugarRecord {

    @SerializedName("id")
    private String userId = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("password")
    private String password = null;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String id, String name, String password) {
        this.userId = id;
        this.name = name;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String id) {
        this.userId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
