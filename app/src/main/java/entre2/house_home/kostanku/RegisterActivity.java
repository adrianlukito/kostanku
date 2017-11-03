package entre2.house_home.kostanku;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import entre2.house_home.kostanku.controllers.UserController;
import entre2.house_home.kostanku.models.User;
import entre2.house_home.kostanku.utilities.Session;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    EditText txtName, txtEmail, txtPhone, txtPassword, txtConfirm;
    TextView alreadyHaveAccount, linkSignin, tvSignup;
    Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Typeface quicksand = Typeface.createFromAsset(getAssets(), "Quicksand-Regular.ttf");

        txtName = (EditText) findViewById(R.id.txtName);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPhone = (EditText) findViewById(R.id.txtPhone);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtConfirm = (EditText) findViewById(R.id.txtConfirm);

        alreadyHaveAccount = (TextView) findViewById(R.id.alreadyHaveAccount);
        linkSignin = (TextView) findViewById(R.id.linkSignin);
        tvSignup = (TextView) findViewById(R.id.tvSignup);

        btnSignup = (Button) findViewById(R.id.btnSignup);

        txtName.setTypeface(quicksand);
        txtEmail.setTypeface(quicksand);
        txtPhone.setTypeface(quicksand);
        txtPassword.setTypeface(quicksand);
        txtConfirm.setTypeface(quicksand);

        alreadyHaveAccount.setTypeface(quicksand);
        linkSignin.setTypeface(quicksand, Typeface.BOLD);
        linkSignin.setOnClickListener(this);
        tvSignup.setTypeface(quicksand);

        btnSignup.setTypeface(quicksand);
        btnSignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == linkSignin){
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }
        else if(v == btnSignup){
            String email = txtEmail.getText().toString();
            String name = txtName.getText().toString();
            String password = txtPassword.getText().toString();
            String phone = txtPhone.getText().toString();
            String confirm = txtConfirm.getText().toString();

            User user = new User("",name,email,password,phone);

            String err = UserController.validateRegister(user,confirm);
            if(!err.equals("")){
                Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
            }
            else{
                if(UserController.getUser(email) == null) {
                    UserController.insertUser(user);
                    Session session = new Session(getApplicationContext());
                    session.setUser(user);
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(this, "email is already used", Toast.LENGTH_SHORT).show();
                }
            }


        }
    }
}
