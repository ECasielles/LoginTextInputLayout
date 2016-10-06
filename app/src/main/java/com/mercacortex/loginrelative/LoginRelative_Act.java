package com.mercacortex.loginrelative;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginRelative_Act extends AppCompatActivity implements ILoginMvp.View {

    private ILoginMvp.Presenter loginMvp;
    private EditText mEdtPwd, mEdtUsr;
    private Button mBtnOk, mBtnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_relative_);
        loginMvp = new LoginPresenter(this);
        mEdtUsr = (EditText) findViewById(R.id.edtUser);
        mEdtPwd = (EditText) findViewById(R.id.edtPwd);
        mBtnOk = (Button) findViewById(R.id.btnOK);
        mBtnCancel = (Button) findViewById(R.id.btnCancel);

        mBtnOk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                loginMvp.validateCredentials(mEdtUsr.getText().toString(), mEdtPwd.getText().toString());
            }
        });
    }

    @Override
    public void setMessageError(String messageError) {
        Toast.makeText(this, messageError, Toast.LENGTH_SHORT).show();
    }
}
