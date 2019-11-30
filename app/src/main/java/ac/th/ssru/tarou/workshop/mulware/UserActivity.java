package ac.th.ssru.tarou.workshop.mulware;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserActivity extends AppCompatActivity {

    Button btnlogout, btncontact, btnlesson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        btnlogout = (Button) findViewById(R.id.btnlogout);
        btncontact = (Button) findViewById(R.id.contact);
        btnlesson = (Button) findViewById(R.id.lesson);

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btncontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserActivity.this, ContractActivity.class);
                startActivity(i);
            }
        });
        btnlesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserActivity.this, LessonActivity.class);
                startActivity(i);
            }
        });

    }
}
