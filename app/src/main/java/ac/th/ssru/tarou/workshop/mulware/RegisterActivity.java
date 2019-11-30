package ac.th.ssru.tarou.workshop.mulware;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText edtmail, edtpass;
    Button btnregisAction;

    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();
        edtmail = (EditText) findViewById(R.id.regismail);
        edtpass = (EditText) findViewById(R.id.regispass);
        btnregisAction = (Button) findViewById(R.id.btnregisyes);
        btnregisAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserRegister();
            }
        });
    }

    private void UserRegister() {


        String mail, pass;
        mail = edtmail.getText().toString();
        pass = edtpass.getText().toString();
        if (TextUtils.isEmpty(mail) || TextUtils.isEmpty(pass)) {
            Toast.makeText(RegisterActivity.this, "It's Empty!!", Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(RegisterActivity.this, "NOT Successful", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
