package com.bambang.eventbus.eventbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * Created by bambanghs on 5/14/2017.
 */

public class EventCallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_caller);

        //Mengambil Value Dari Activity Sebelumnya (Main Activity)
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("arg1");
        Log.d("Message", "from mainactivity = "+message);
    }

    public void JalankanEvent(View view) {
        EditText inputEditText = (EditText)findViewById(R.id.editText_inputeEvent);
        String input = String.valueOf(inputEditText.getText());

        Intent returnIntent = new Intent();
        returnIntent.putExtra("text", input);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();

        /*Post input : cara EventBus
          MyCustomEvent event = new MyCustomEvent();
          event.setEventText(input);
          EventBus.getDefault().post(event);
         */
    }

}
