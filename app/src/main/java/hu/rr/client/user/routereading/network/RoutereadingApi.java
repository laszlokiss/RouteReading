package hu.rr.client.user.routereading.network;

import hu.rr.client.user.routereading.model.RouteReading;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface RoutereadingApi {

    /**
     * Modify an existing routereading.
     * Modify an existing routereading of the choosen project.
     *
     * @param id   Id of the routereading that needs to be modified.
     * @param body Details of the routereading.
     * @return Call<Routereading>
     */

    @PUT("routereading")
    Call<RouteReading> routereadingPut(
            @Query("id") String id, @Body RouteReading body
    );


    /**
     * New routereading.
     * Create a new routereading for the choosen project.
     *
     * @param body Details of the routereading.
     * @return Call<Routereading>
     */

    @POST("routereading")
    Call<RouteReading> routereadingPost(
            @Body RouteReading body
    );


    /**
     * Delete routereading.
     * Delete an existing routereading of the choosen project.
     *
     * @param id Id of the routereading that needs to be deleted.
     * @return Call<Void>
     */

    @DELETE("routereading")
    Call<Void> routereadingDelete(
            @Query("id") String id
    );


}
