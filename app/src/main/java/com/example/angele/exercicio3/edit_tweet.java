package com.example.angele.exercicio3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by angele on 07/04/18.
 */

public class edit_tweet extends Activity {
    private Tweet tweet;
    private TextView edit_tweet;
    private TextView salvar_tweet;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);

        edit_tweet = findViewById(R.id.edit_tweet);

        Intent intent = getIntent();

        tweet = (Tweet)intent.getSerializableExtra(Tweet.TWEET_INFO);

        edit_tweet.setText(tweet.getTexto());

    }

    public void salvar (View view){
        tweet.setTexto(edit_tweet.getText().toString());

        Intent result = new Intent();
        result.putExtra(Tweet.TWEET_INFO, tweet);

        setResult(RESULT_OK, result);
        finish();

    }
}
