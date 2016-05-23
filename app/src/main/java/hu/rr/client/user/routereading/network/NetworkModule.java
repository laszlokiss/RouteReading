package hu.rr.client.user.routereading.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Laci on 2016.04.19..
 */
@Module
public class NetworkModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(NetworkConfig.ENDPOINT_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public ProjectApi provideProjectsApi(Retrofit retrofit) {
        return retrofit.create(ProjectApi.class);
    }

    @Provides
    @Singleton
    public AuthApi provideAuthApi(Retrofit retrofit) {
        return retrofit.create(AuthApi.class);
    }

    @Provides
    @Singleton
    public RoutereadingApi provideRouteReadingApi(Retrofit retrofit) {
        return retrofit.create(RoutereadingApi.class);
    }
}
