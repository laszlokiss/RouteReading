package hu.rr.client.user.routereading.repository.mock;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.rr.client.user.routereading.repository.Repository;

/**
 * Created by Laci on 2016.05.08..
 */
@Module
public class MockRepositoryModule {

    @Provides
    @Singleton
    public Repository providesMockRepository(Context context) {
        MockRepository mockRepository = new MockRepository();
        mockRepository.initialize(context);
        return mockRepository;
    }

}
