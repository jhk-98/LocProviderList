package com.example.locproviderlist;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class LocProviderListActivity extends AppCompatActivity {
    TextView mTextView;
    LocationManager locMgr;
    List<String> locProvList;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.txtOutput);
        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locMgr = (LocationManager) getSystemService(LOCATION_SERVICE);

                locProvList = locMgr.getAllProviders();

                String s = "";
                int [] a = new int [locProvList.size()];

                for (int i : a){
                    s += "Loc. Provider: " + locProvList.get(i) + "\n" + "Status:"
                            + locMgr.isProviderEnabled(locProvList.get(i)) + "\n\n";

                }
                mTextView.setText(s);

            }
        });


    }
}