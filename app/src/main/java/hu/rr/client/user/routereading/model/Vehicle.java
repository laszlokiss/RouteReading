package hu.rr.client.user.routereading.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Laci on 2016.05.18..
 */
public class Vehicle {

    @SerializedName("id")
    private String vehicleId = null;

    @SerializedName("platenumber")
    private String plateNumber = null;

    public Vehicle(String id, String plateNumber) {
        this.vehicleId = id;
        this.plateNumber = plateNumber;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
