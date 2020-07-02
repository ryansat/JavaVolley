package com.example.java_volley;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;

public class CRUD extends AppCompatActivity {
    private Button save;
    private Button update;
    private Button delete;
    private String url = "https://satriaworld.xyz/api/bean/testcrud/";
    private EditText id;
    private EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        id = findViewById(R.id.idTxt);
        name = findViewById(R.id.nameTxt);

        save = findViewById(R.id.savebtn);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
              RequestQueue queue = Volley.newRequestQueue(CRUD.this);
              //for POST requests, only the following line should be changed to

              StringRequest sr = new StringRequest(Request.Method.POST, url+"/tambah.php",
                      new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                          Log.e("HttpClient", "success! response: " + response.toString());
                        }
                      },
                      new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                          Log.e("HttpClient", "error: " + error.toString());
                        }
                      })
              {
                @Override
                protected Map<String,String> getParams(){
                  Map<String,String> params = new HashMap<String, String>();
                  params.put("id", id.getText().toString());
                  params.put("name", name.getText().toString());
                  return params;
                }
//                @Override
//                public Map<String, String> getHeaders() throws AuthFailureError {
//                  Map<String,String> params = new HashMap<String, String>();
//                  String creds = String.format("%s:%s","admin_lpm","admin123");
//                  String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
//                  params.put("Content-Type","application/x-www-form-urlencoded");
//                  params.put("Authorization", auth);
//                  return params;
//                }
              };
              queue.add(sr);
            }
        });
        update = findViewById(R.id.updatebtn);
        update.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
              RequestQueue queue = Volley.newRequestQueue(CRUD.this);
              //for POST requests, only the following line should be changed to

              StringRequest sr = new StringRequest(Request.Method.POST, url+"/update.php",
                      new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                          Log.e("HttpClient", "success! response: " + response.toString());
                        }
                      },
                      new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                          Log.e("HttpClient", "error: " + error.toString());
                        }
                      })
              {
                @Override
                protected Map<String,String> getParams(){
                  Map<String,String> params = new HashMap<String, String>();
                  params.put("id", id.getText().toString());
                  params.put("name", name.getText().toString());
                  return params;
                }
//                @Override
//                public Map<String, String> getHeaders() throws AuthFailureError {
//                  Map<String,String> params = new HashMap<String, String>();
//                  String creds = String.format("%s:%s","admin_lpm","admin123");
//                  String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
//                  params.put("Content-Type","application/x-www-form-urlencoded");
//                  params.put("Authorization", auth);
//                  return params;
//                }
              };
              queue.add(sr);
            }
        });
        delete = findViewById(R.id.deletebtn);
        delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
              RequestQueue queue = Volley.newRequestQueue(CRUD.this);
              //for POST requests, only the following line should be changed to

              StringRequest sr = new StringRequest(Request.Method.POST, url+"/hapus.php",
                      new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                          Log.e("HttpClient", "success! response: " + response.toString());
                        }
                      },
                      new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                          Log.e("HttpClient", "error: " + error.toString());
                        }
                      })
              {
                @Override
                protected Map<String,String> getParams(){
                  Map<String,String> params = new HashMap<String, String>();
                  params.put("id", id.getText().toString());
                  params.put("name", name.getText().toString());
                  return params;
                }
//                @Override
//                public Map<String, String> getHeaders() throws AuthFailureError {
//                  Map<String,String> params = new HashMap<String, String>();
//                  String creds = String.format("%s:%s","admin_lpm","admin123");
//                  String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
//                  params.put("Content-Type","application/x-www-form-urlencoded");
//                  params.put("Authorization", auth);
//                  return params;
//                }
              };
              queue.add(sr);
            }
        });
    }
}