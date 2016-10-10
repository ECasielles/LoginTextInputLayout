package com.mercacortex.logintextinputlayout;

/**
 * Interfaz modelo vista-presentador
 */

public interface ILoginMvp {

    int PASSWORD_DIGIT = 1;
    int PASSWORD_CASE =  2;
    int PASSWORD_LENGTH = 3;
    int DATA_EMPTY = 4;

    // Composición de interfaces
    interface View {
        public void setMessageError(String error, int edtUser);
    }

    interface Presenter {
        public void validateCredentials(String usr, String pwd);
    }
}
