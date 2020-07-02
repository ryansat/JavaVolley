package com.example.java_volley;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.java_volley.R.layout.simple_list_item_1;

public class ShowData extends AppCompatActivity {
  private ArrayList<HashMap<String,String>> listData= new ArrayList<>();
  private RequestQueue requestQueue;
  private ListView lv_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        lv_user = findViewById(R.id.lv_user);
        loadData();
    }

    private void loadData() {
      String url ="https://satriaworld.xyz/api/bean/testcrud/user.php";

      JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
          @Override
          public void onResponse(JSONObject response) {
            try{
              JSONArray jsonArray =  response.getJSONArray("name");
              for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject employee = jsonArray.getJSONObject(i);
                HashMap<String, String> contact =  new HashMap<>();
                contact.put("id",employee.getString("id"));
                contact.put("name",employee.getString("name"));
                listData.add(contact);
              }
              ListAdapter adapter = new SimpleAdapter(ShowData.this, listData, simple_list_item_1, new String[]{"id", "name"},
                      new int[] {R.id.identity, R.id.name});
              lv_user.setAdapter(adapter);
            }catch (JSONException e){
              Toast.makeText(ShowData.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
          }
        }, new Response.ErrorListener() {

          @Override
          public void onErrorResponse(VolleyError error) {
            // TODO: Handle error
            Toast.makeText(ShowData.this, error.toString(), Toast.LENGTH_SHORT).show();
          }
        });
      requestQueue = Volley.newRequestQueue(this);
      requestQueue.add(jsonObjectRequest);
    }
}