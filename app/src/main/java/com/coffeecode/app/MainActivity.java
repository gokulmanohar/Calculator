package com.coffeecode.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etFirst;
    EditText etSecond;
    Button btnAdd;
    Button btnMinus;
    Button btnMultiply;
    Button btnDivide;
    TextView vtResult;
    Button btnClear;
    Button btnTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//gives the layout on screen
        etFirst=findViewById(R.id.et_first);
        etSecond=findViewById(R.id.et_second);
        btnAdd=findViewById(R.id.btn_add);
        btnMinus=findViewById(R.id.btn_minus);
        btnMultiply=findViewById(R.id.btn_multiply);
        btnDivide=findViewById(R.id.btn_divide);
        vtResult=findViewById(R.id.vt_result);
        btnClear=findViewById(R.id.btn_clear);
        btnTime=findViewById(R.id.btn_time);


        //addition
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //new AddTask().execute();
                    int numa = Integer.parseInt(etFirst.getText().toString());
                    int numb = Integer.parseInt(etSecond.getText().toString());
                    int res = numa+numb;

                    vtResult.setText(String.valueOf(res));
                    //new AddTask().execute();
                }catch (Exception e){
                    showErrorToast();
                }
            }
        });

        //subtraction
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int numa = Integer.parseInt(etFirst.getText().toString());
                    int numb = Integer.parseInt(etSecond.getText().toString());
                    int res = numa - numb;

                    vtResult.setText(String.valueOf(res));
                }catch (Exception e) {
                    showErrorToast();
                }
            }
        });

        //multiplication
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int numa = Integer.parseInt(etFirst.getText().toString());
                    int numb = Integer.parseInt(etSecond.getText().toString());
                    int res = numa * numb;

                    vtResult.setText(String.valueOf(res));
                }catch (Exception e){
                    showErrorToast();
                }
            }
        });

        //division
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int numa = Integer.parseInt(etFirst.getText().toString());
                    int numb = Integer.parseInt(etSecond.getText().toString());
                    int res = numa / numb;

                    vtResult.setText(String.valueOf(res));
                }catch (Exception e){
                    showErrorToast();
                }
            }
        });

        //clearing
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vtResult.setText("");
                etFirst.setText("");
                etSecond.setText("");
            }

            });
        //time
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    new AddTask().execute();
                }catch (Exception e){
                    showErrorToast();
                }
            }
        });



    }
    public void showErrorToast(){
        Toast.makeText(this, "Enter a Number", Toast.LENGTH_SHORT).show();
    }
    public int add(int a,int b){
        return a+b;
    }
    class AddTask extends AsyncTask {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            vtResult.setText("PLEASE WAIT ");
        }

        @Override
        protected Object doInBackground(Object[] objects)
        {
        try{
            Thread.sleep(3000);}
        catch (Exception e) {

        }
            String epoch = String.valueOf(System.currentTimeMillis());
        return epoch;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            vtResult.setText((String)o);
        }
    }
}