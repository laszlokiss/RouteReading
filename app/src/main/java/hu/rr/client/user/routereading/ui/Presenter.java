package hu.rr.client.user.routereading.ui;

/**
 * Created by Laci on 2016.04.19..
 */
public abstract class Presenter<S> {
    protected S screen;

    public void attachScreen(S screen) {
        this.screen = screen;
    }

    public void detachScreen() {
        this.screen = null;
    }
}
