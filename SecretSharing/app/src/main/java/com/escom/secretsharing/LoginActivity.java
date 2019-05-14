package com.escom.secretsharing;

import android.app.ProgressDialog;
import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnFocusChange;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.et_email) TextInputEditText email;
    @BindView(R.id.et_password) TextInputEditText password;
    @BindString(R.string.hint_email) String hEmail;
    @BindString(R.string.hint_password) String hPassword;
    @BindString(R.string.hint_password) String fingerprintDialogTitle;
    @BindString(R.string.fingerTitle) String fingerprintDialogSubtitle;
    @BindString(R.string.fingerDescription) String fingerprintDialogDescription;
    @BindString(R.string.fingerButton) String fingerprintDialogNegativeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnFocusChange({R.id.et_email, R.id.et_password})
    public void placeHolderTrick(boolean focus, TextInputEditText textInputEditText){
        if(focus){
            if(textInputEditText == password){
                textInputEditText.setHint(hPassword);
            }else{
                textInputEditText.setHint(hEmail);
            }
        }else{
            textInputEditText.setHint("");
        }
    }

    @OnClick(R.id.btn_login)
    public void login(){

        if(!validate()){
            //failed
            return;
        }

        final ProgressDialog progressDialog = new ProgressDialog(this, R.style.AppTheme_Dialog);
        progressDialog.setIndeterminate(true);



    }

    private boolean validate(){
        boolean valid = true;

        String email = this.email.getText().toString();
        String password = this.password.getText().toString();

        if(email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            this.email.setError("Email invalido");
            valid = false;
        }else{
            this.email.setError(null);
        }

        if(password.isEmpty()){
            this.password.setError("Campo vacio");
        }

        return valid;
    }
}
