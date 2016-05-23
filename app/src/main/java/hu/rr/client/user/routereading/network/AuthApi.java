package hu.rr.client.user.routereading.network;

import hu.rr.client.user.routereading.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthApi {

    /**
     * Login
     * Provides Login function to the application.
     *
     * @param body Login credentials of the user
     * @return Call<User>
     */

    @POST("login")
    Call<User> loginPost(
            @Body User body
    );


}
