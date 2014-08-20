package com.example.sandeep.webservice;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.apache.http.client.ResponseHandler;
import org.json.JSONObject;


public class MyActivity extends Activity{
    EditText inputData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        inputData=(EditText)findViewById(R.id.editText);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void getValue(View view){
         String input=inputData.getText().toString();
        RequestParams requestParams=new RequestParams();
        if((input!=null)||(!input.isEmpty())){
            requestParams.add("data",input);
            invokeWS(requestParams);
            Toast.makeText(getApplicationContext(),input,Toast.LENGTH_LONG);

       }


    }

    public void invokeWS(RequestParams params){
        AsyncHttpClient client=new AsyncHttpClient();
        client.get("https://service21test.herokuapp.com/data",params,new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String responseBody) {

                try {
                    JSONObject json=new JSONObject(responseBody);
                    String data=json.getString("data");
                    Toast.makeText(getApplicationContext(),data,Toast.LENGTH_LONG).show();


                }
                catch (Exception EX){
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                }
            }
        });
}
}

