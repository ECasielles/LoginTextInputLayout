package com.mercacortex.logintextinputlayout;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginRelative_Act extends AppCompatActivity implements ILoginMvp.View {

    private ILoginMvp.Presenter loginMvp;
    private EditText mEdtPwd, mEdtUsr;
    private Button mBtnLogin;
    private final String TAG = "logintextinputlayout";
    private TextInputLayout tilUser, tilPwd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_relative_);
        loginMvp = new LoginPresenter(this);
        mEdtUsr = (EditText) findViewById(R.id.edtUser);
        mEdtPwd = (EditText) findViewById(R.id.edtPwd);

        tilUser = (TextInputLayout) findViewById(R.id.tilUsr);
        tilPwd = (TextInputLayout) findViewById(R.id.tilPwd);

        mBtnLogin = (Button) findViewById(R.id.btnLogin);

        mBtnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                loginMvp.validateCredentials(mEdtUsr.getText().toString(), mEdtPwd.getText().toString());
            }
        });

        mEdtUsr.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Así se borra el error si volvemos a escribir
                tilUser.setError(null);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mEdtPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Así se borra el error si volvemos a escribir
                tilPwd.setError(null);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        // Comprobar la persistencia del objeto Application
        if (((LoginApplication)getApplicationContext()).getUser() != null)
            Log.d(TAG, ((LoginApplication)getApplicationContext()).getUser().toString());


        Log.d(TAG,"Actividad creada con éxito");
    }

    /*
    private void resetvalues() {
        mEdtPwd.setText("");
        mEdtUsr.setText("");
    }
    */

    @Override
    public void setMessageError(String messageError, int idView) {
        //Toast.makeText(this, messageError, Toast.LENGTH_SHORT).show();
        switch (idView){
            // Cambiamos para que salga en el TableInputLayout en vez del EditText
            // aunque también se podría usar, pero suele aparecer cuando no debe
            case R.id.edtUser:
                tilUser.setError(messageError);
                break;
            case R.id.edtPwd:
                tilPwd.setError(messageError);
                break;
        }
    }



    @Override
    protected void onDestroy() {
        super.onStop();
        Log.d(TAG,"Actividad destruida");
    }
}
