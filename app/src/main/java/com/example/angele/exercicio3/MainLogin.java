package com.example.angele.exercicio3;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by angele on 07/04/18.
 */

public class MainLogin extends Activity {
    private String user;
    private String password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView usuario = findViewById(R.id.usuario);
        TextView senha = findViewById(R.id.senha);

        SharedPreferences settings = getPreferences(Activity.MODE_PRIVATE);
        user = settings.getString("user","");
        password = settings.getString("password","");

        usuario.setText(user);
    }

    public void logar(View view){
        TextView usuario = findViewById(R.id.usuario);
        TextView senha = findViewById(R.id.senha);
        user= usuario.getText().toString();
        password = senha.getText().toString();

        SharedPreferences settings = getPreferences(Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        editor.putString("user",user);
        editor.putString("password",password);

        editor.commit();

        Intent intent = new Intent(MainLogin.this, MainActivity.class);
        startActivity(intent);
    }

}
