package com.example.angele.exercicio3;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by angele on 06/04/18.
 */


public class detalhes_tweet extends Activity {
    Tweet tweet;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_tweet);
        Log.d("ciclovida", "onCreate");

        TextView detalhes_autor = (TextView) findViewById(R.id.detalhes_autor);
        TextView detalhes_email = (TextView) findViewById(R.id.detalhes_email);
        TextView detalhes_telefone = (TextView) findViewById(R.id.detalhes_telefone);
        TextView detalhes_texto = (TextView) findViewById(R.id.detalhes_texto);
        TextView detalhes_data = (TextView) findViewById(R.id.detalhes_data);

        Intent intent = getIntent();
        tweet = (Tweet) intent.getExtras().get(Tweet.TWEET_INFO);

        detalhes_autor.setText(tweet.getAutor().getNome());
        detalhes_email.setText(tweet.getAutor().getEmail());
        detalhes_telefone.setText(tweet.getAutor().getTelefone());
        detalhes_texto.setText(tweet.getTexto());
        detalhes_data.setText(tweet.getData().toGMTString());

    }
    public void telefonar(View v){
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        callIntent.setData(Uri.parse("tel:" + tweet.getAutor().getTelefone()));

        if (checkSelfPermission(android.Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        startActivity(callIntent);
    }
    public void Voltar(View v){
       finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ciclovida", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ciclovida", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ciclovida", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ciclovida", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ciclovida", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ciclovida", "onDestroy");
    }
}
