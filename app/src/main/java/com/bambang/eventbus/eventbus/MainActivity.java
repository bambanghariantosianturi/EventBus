package com.bambang.eventbus.eventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);


    }
    //method mengecek kalo event jalan;
    @Subscribe
    public void OnEvent(MyCustomEvent event) {
        Log.d("Event", "event fired");
        ((TextView)findViewById(R.id.textView_event)).setText(event.getEventText());

    }
    //button ke activity lain
    public void eventCaller (View view) {
        Intent intent = new Intent(this, EventCallActivity.class);

        //ini cara manual
        Bundle bundle = new Bundle();
        bundle.putString("arg1", " Ini String dari MainActivity");
        intent.putExtras(bundle);
        startActivityForResult(intent, 232);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 232) {
            String text = data.getStringExtra("text");

            ((TextView) findViewById(R.id.textView_event)).setText(text);
            Toast.makeText(this, "hasil dari activity EventCallerActivity "  + text, Toast.LENGTH_SHORT).show();
        }
    }

}
