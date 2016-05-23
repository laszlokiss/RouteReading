package hu.rr.client.user.routereading.network;

import java.util.List;

import hu.rr.client.user.routereading.model.Project;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ProjectApi {

    /**
     * Projects.
     * All projects.
     *
     * @return Call<List<Project>>
     */

    @GET("projects")
    Call<List<Project>> projectsGet();

}
