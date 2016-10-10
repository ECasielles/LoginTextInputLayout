package com.mercacortex.logintextinputlayout;

import android.app.Application;
import com.mercacortex.logintextinputlayout.model.User;

/**
 * Esta clase existe durante toda la vida de la aplicación.
 * Es un objeto Singleton que hay que declarar en el Manifest.
 */

public class LoginApplication extends Application {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void setUser(String usr, String pwd) {

    }
}
