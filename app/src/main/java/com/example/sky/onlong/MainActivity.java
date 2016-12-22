package com.example.sky.onlong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         text=(TextView)findViewById(R.id.Text);
        EditText etText = (EditText) findViewById(R.id.txtView1);
        btn=(Button)findViewById(R.id.Btn1);
        LinearLayout lineralayout=(LinearLayout)findViewById(R.id.activity_main);
       lineralayout.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View view, MotionEvent motionEvent) {
               Toast.makeText(MainActivity.this,"Touch Here",Toast.LENGTH_SHORT).show();
               int x = (int) motionEvent.getX();
               int y = (int) motionEvent.getY();
               switch (motionEvent.getAction()) {
                   case MotionEvent.ACTION_DOWN:
                       Log.i("TAG", "touched down");
                       break;
                   case MotionEvent.ACTION_MOVE:
                       Log.i("TAG", "moving: (" + x + ", " + y + ")");
                       break;
                   case MotionEvent.ACTION_UP:
                       Log.i("TAG", "touched up");
                       break;
               }


               return true;
           }
       });
        etText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                text.setText(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btn.setOnLongClickListener(new View.OnLongClickListener() {

            @Override

            public boolean onLongClick(View v) {
                Toast toast=Toast.makeText(MainActivity.this,"long press",Toast.LENGTH_LONG);
                toast.show();
                btn.setText("Cool");

                return true;
            }

        });

    }
}
