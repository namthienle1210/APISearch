package com.root.status;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Display extends AppCompatActivity {
    
    TextView serviceKey,pageNo,numOfRows,period,zcode;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        pd = new ProgressDialog(Display.this);
        pd.setMessage("Loading . . .");

        serviceKey=(TextView)findViewById(R.id.serviceKey);
        pageNo=(TextView)findViewById(R.id.pageNo);
        numOfRows=(TextView)findViewById(R.id.numOfRows);
        period=(TextView)findViewById(R.id.period);
        zcode=(TextView)findViewById(R.id.zcode);

        station=getIntent().getStringExtra("station");



      
        String url= "http://apis.data.go.kr/B552584/EvCharger/getChargerStatus";
            pd.show();
            StringRequest stringRequest = new StringRequest(Request.Method.GET,
                    url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            
                            JSONObject jObject  = null;
                            try {
                                jObject = new JSONObject(response);
                                JSONObject jsonObject = jObject.getJSONObject("station");                                
                                pageNo.setText(jsonObject.getString("page-number").toString());
                                numOfRows.setText(jsonObject.getString("number-of-rows").toString());
                                JSONArray jsonarray = new JSONArray(jsonObject.getString("serviceKey"));
                                for(int i=0; i < jsonarray.length(); i++) {

                                    JSONObject jsonobject = jsonarray.getJSONObject(i);
                                    String zcode       = jsonobject.getString("zcode");
                                    String serviceKey       = jsonobject.getString("Service Key");


                                    
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                                pd.hide();
                            }




                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            if(error != null){
                                Log.d(TAG, error.toString());
                                Toast.makeText(getApplicationContext(), "Something went wrong.", Toast.LENGTH_LONG).show();
                            }
                        }
                    }

            );

            MySingelton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

        }

    }

