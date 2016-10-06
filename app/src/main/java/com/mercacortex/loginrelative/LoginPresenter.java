package com.mercacortex.loginrelative;

import android.content.Context;
import android.text.TextUtils;

/**
 * Clase presentador.
 */

public class LoginPresenter implements ILoginMvp.Presenter {

    private ILoginMvp.View view;


    public LoginPresenter(ILoginMvp.View view) {
        this.view = view;
    }

    @Override
    public void validateCredentials(String usr, String pwd) {
        if (TextUtils.isEmpty(usr) || TextUtils.isEmpty(pwd))
            view.setMessageError(((Context)view).getResources().getString(R.string.data_empty));
        else if(!pwd.matches(".*[0-9].*"))
            view.setMessageError(((Context)view).getResources().getString(R.string.password_digit));
        else if(!pwd.matches(".*[a-z].*") || !pwd.matches(".*[A-Z].*"))
            view.setMessageError(((Context)view).getResources().getString(R.string.password_case));
        else if(!pwd.matches(".{8,}"))
            view.setMessageError(((Context)view).getResources().getString(R.string.password_length));
        else {
            // Guardar en la clase Application

            // Convertimos el objeto application en LoginApplication
            ((LoginApplication)((Context)view).getApplicationContext()).setUser(usr, pwd);
            // Como idea inicial está bien, pero la solución final es guardarlo en un XML
        }
    }
}
