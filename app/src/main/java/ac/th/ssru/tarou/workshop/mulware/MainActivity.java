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

import ac.th.ssru.tarou.workshop.mulware.R;

public class MainActivity extends AppCompatActivity {
    Button btnregister, btnlogin;
    EditText edtmail, edtpass;

    FirebaseAuth firebaseAuth;
    FirebaseAuth.AuthStateListener authlisten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        btnregister = (Button) findViewById(R.id.btnregis);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        edtmail = (EditText) findViewById(R.id.logmail);
        edtpass = (EditText) findViewById(R.id.logpass);

        authlisten = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    startActivity(new Intent(MainActivity.this, UserActivity.class));
                }
            }
        };

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Signin();
            }
        });
    }

    private void Signin() {
        final String mail, pass;
        mail = edtmail.getText().toString();
        pass = edtpass.getText().toString();
        if (TextUtils.isEmpty(mail)||TextUtils.isEmpty(pass)) {
            Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
            return;
        }



        firebaseAuth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, UserActivity.class);
                    startActivity(i);

                }
                else {
                    Toast.makeText(MainActivity.this, "LOG IN ERROR", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}

