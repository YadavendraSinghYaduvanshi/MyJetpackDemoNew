package com.yadu.myjetpackdemonew;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.yadu.myjetpackdemonew.room_data.DatabaseActivity;

public class ViewModelActivity extends AppCompatActivity {

    int count = 0;
    TextView tv_t_count;
    MyCountViewModel provider;

    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);

        tv_t_count = (TextView) findViewById(R.id.tv_t_count);

        floatingActionButton =(FloatingActionButton) findViewById(R.id.fab_add);

        provider = ViewModelProviders.of(this).get(MyCountViewModel.class);

        LiveData<String> mycount = provider.getCount();
        mycount.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tv_t_count.setText("Total count "+ s);
            }
        });

        tv_t_count.setText("Total count "+ mycount.getValue());

        ((Button)findViewById(R.id.btn_t_count)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCount();
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), DatabaseActivity.class);
                startActivity(in);
            }
        });

    }

    void setCount(){

        provider.count.setValue((Integer.parseInt(provider.getCount().getValue()) + 1)+"");

    }
}
