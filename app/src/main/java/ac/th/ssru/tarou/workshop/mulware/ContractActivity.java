package ac.th.ssru.tarou.workshop.mulware;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContractActivity extends AppCompatActivity {

    Button tata,aek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract);


        tata = (Button) findViewById(R.id.fbtata);
        aek = (Button) findViewById(R.id.fbaek);

        tata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://www.facebook.com/tarouz59"));
                startActivity(myWebLink);
            }
        });

        aek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://www.facebook.com/Aekky59"));
                startActivity(myWebLink);
            }
        });


    }

}
