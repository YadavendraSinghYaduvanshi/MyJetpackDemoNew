package com.yadu.myjetpackdemonew;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), ViewModelActivity.class);
                startActivity(in);
            }
        });

        Log.i(TAG, "Owner On Create");

         getLifecycle().addObserver(new MainActivityObserver());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Owner On Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Owner On Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Owner On Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Owner On Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Owner On Destroy");
    }
}
