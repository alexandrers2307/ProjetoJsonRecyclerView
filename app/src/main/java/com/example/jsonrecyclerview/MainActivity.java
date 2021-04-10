package com.example.jsonrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private static  String JSON_URL= "http://run.mocy.io/v3/79f722b0-a730-42a0-99aa-36029861f115";
    List<Filme_Classe> classes;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        classes = new ArrayList<>();
        recyclerView= findViewById(R.id.recyclerView);

        GetData getData= new GetData();
        getData.execute();
    }
    public  class GetData extends AsyncTask<String,String,String> {


        @Override
        protected String doInBackground(String... strings) {

            String current = "";

            try {
                URL url;
                HttpURLConnection urlConnection = null;
                try {

                    url = new URL(JSON_URL);
                    urlConnection= (HttpURLConnection)url.openConnection();

                    InputStream is= urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    int data=isr.read();
                    while (data!= -1){

                        current+=(char ) data;
                        data= isr.read();

                    }
                    return  current;



                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                }finally {
                    if (urlConnection!= null){
                        urlConnection.disconnect();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }





            return current;
        }
        @Override
        protected  void onPostExecute(String s){

            try {
                JSONObject jsonObject = new JSONObject(s);

                JSONArray jsonArray = jsonObject.getJSONArray("moviz");

                for (int i=0;i<jsonArray.length();i++){


                    JSONObject jsonObject1= jsonArray.getJSONObject(i);

                    Filme_Classe model = new Filme_Classe();
                    model.setId(jsonObject1.getString("id"));
                    model.setId((jsonObject1.getString("nome")));
                    model.setId((jsonObject1.getString("image")));
                    classes.add(model);
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

            PutDataIntoRecyclerView(classes);
        }

    }

    private void PutDataIntoRecyclerView(List<Filme_Classe> classeList) {
        Filme_Adapter filme_adapter= new Filme_Adapter(this,classeList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(filme_adapter);

    }

}