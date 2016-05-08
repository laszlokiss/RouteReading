package hu.rr.client.user.routereading.repository.prod;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.rr.client.user.routereading.repository.Repository;

/**
 * Created by Laci on 2016.05.08..
 */
@Module
public class ProdRepositoryModule {

    @Provides
    @Singleton
    public Repository providesProdRepository(Context context) {
        ProdRepository prodRepository = new ProdRepository();
        prodRepository.initialize(context);
        return prodRepository;
    }

}
