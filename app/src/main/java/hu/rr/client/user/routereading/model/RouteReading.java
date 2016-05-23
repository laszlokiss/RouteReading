package hu.rr.client.user.routereading.model;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Laci on 2016.04.25..
 */
public class RouteReading extends SugarRecord implements Serializable {
    @SerializedName("id")
    private String routeReadingId = null;

    @SerializedName("driverid")
    private User driver = null;

    @SerializedName("vehicleid")
    private Vehicle vehicle = null;

    @SerializedName("date")
    private Date date = null;

    @SerializedName("from")
    private String from = null;

    @SerializedName("destination")
    private String destination = null;

    @SerializedName("routereading")
    private Integer routereading = null;

    public RouteReading() {

    }

    public RouteReading(String id, User driver, Vehicle vehicle, Date date, String from, String dest, Integer routereading) {
        this.routeReadingId = id;
        this.driver = driver;
        this.vehicle = vehicle;
        this.date = date;
        this.from = from;
        this.destination = dest;
        this.routereading = routereading;
    }

    /**
     **/
    public String getRouteReadingId() {
        return routeReadingId;
    }

    public void setRouteReadingId(String id) {
        this.routeReadingId = id;
    }


    /**
     **/
    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }


    /**
     **/
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    /**
     **/
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    /**
     **/
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }


    /**
     **/
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


    /**
     **/
    public Integer getRoutereading() {
        return routereading;
    }

    public void setRoutereading(Integer routereading) {
        this.routereading = routereading;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RouteReading routereading = (RouteReading) o;
        return routeReadingId.equals(routereading.getRouteReadingId());
    }

    @Override
    public int hashCode() {
        return routeReadingId.hashCode();
    }
}
