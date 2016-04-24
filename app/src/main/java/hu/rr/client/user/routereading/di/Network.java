package hu.rr.client.user.routereading.di;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Laci on 2016.04.18..
 */
@Qualifier
@Retention(RUNTIME)
public @interface Network {
}
