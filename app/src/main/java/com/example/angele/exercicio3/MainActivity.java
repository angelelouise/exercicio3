package com.example.angele.exercicio3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends Activity {
    //private ArrayList<String> tweets = new ArrayList<>();
    //private ArrayAdapter<String> adapter;

    private ArrayList<Tweet> tweets = new ArrayList<>();
    //private ArrayAdapter<Tweet> adapter;
    private MeuAdapter adapter; //implementando um adapter customizado

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*savedInstanceState: contém informações da activity quando o android mata o app, por isso deve ter
        um tratamento para resumir as informaçõe perdidas. Implementar um if pois ao iniciar
         ele é nulo.
        OnSaveInstanceState: salva as informações que vc quer, é chamado antes de morrer.*/

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ciclovida", "onCreate");

        if(savedInstanceState != null){
            //tweets = (ArrayList<String>) savedInstanceState.getSerializable("tweets");
            tweets = (ArrayList<Tweet>) savedInstanceState.getSerializable("tweets");
            /*Returns the value associated with the given key, or null if no mapping of the desired
            type exists for the given key or a null value is explicitly associated with the key. */
        }
        //referenciando o listview
        ListView tweetlogs = (ListView) findViewById(R.id.list_log_twt);
        //fazendo a ligação da lista criada ao adapter (this, estilo da lista, arraylist)
        //adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, tweets);
        adapter = new MeuAdapter(getApplicationContext(),tweets);//utilizando meu adapter, precisa do contexto e da lista de arrays
        //fazendo a conexão do listview ao adapter
        tweetlogs.setAdapter(adapter);
        //listener para cliques
        tweetlogs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Tweet tweetSelecionado = tweets.get(i);
                @SuppressLint("WrongConstant") Toast toast = Toast.makeText(MainActivity.this, "Item Selecionado:"+tweetSelecionado,1);
                toast.show();
            }
        });
    }
    /*
    Método para recuperar dados no momento que o android destroy a aplicação
     */
    protected void onSaveInstanceState (Bundle outState ){
        super.onSaveInstanceState(outState);
        //identifico o que eu quero salvar, nesse caso é a lista de tweets
        outState.putSerializable("tweets", tweets);
    }

    @Override
    protected void onStart() {
        /*
        O método onStart é executado depois de a Activity ter sido enviada para o segundo plano. Isso faz
        do método onStart um bom lugar para se certificar de que todos os recursos requeridos continuam
        disponíveis. Por exemplo, se estiver usando o GPS, o onStart é um bom lugar para se certificar de
        que o GPS estará disponível.
         */
        super.onStart();
        Log.d("ciclovida", "onStart");
    }

    @Override
    protected void onResume() {
        /*
        O método onResume é acionado quando a Activity se inicia e quando é reiniciada. Ele é acionado
        sempre que a Activity voltar para o primeiro plano, um bom lugar para fazer coisas como obter
        Intents e dados extras.
         */
        super.onResume();
        Log.d("ciclovida", "onResume");
    }

    @Override
    protected void onPause() {
        /*
        O método onPause é acionado, quando a Activity deixa o primeiro plano. Isso pode significar que
        uma janela de diálogo está sendo mostrada na tela, ou pode significar que este é o primeiro passo
        para que a Activity seja parada. Isso faz do onPause o lugar ideal para tarefas como parar
        animações, salvar dados e liberar recursos do sistema. Tudo que for liberado no método aqui deverá
        ser reconfigurado no método onResume.
         */
        super.onPause();
        Log.d("ciclovida", "onPause");
    }

    @Override
    protected void onStop() {
        /*
        O método onStop é chamado quando a Activity não está mais visível para o usuário. Isso pode acontecer
        porque ela está sendo destruída ou porque outra Activity foi reiniciada e está em sua frente. Aqui é o
        lugar para liberar todos os recursos que não são mais utilizados pelo usuário.
         */
        super.onStop();
        Log.d("ciclovida", "onStop");
    }

    @Override
    protected void onRestart() {
        /*
        Chamado quando uma atividade parou por algum motivo. Executando o OnStart() de uma forma automática.
         */
        super.onRestart();
        Log.d("ciclovida", "onRestart");
    }

    @Override
    protected void onDestroy() {
        /*
        O método onDestroy é chamado quando a Activity vai ser destruida.  É a última chamada que a
        Activity receberá antes de ser finalizada.
         */
        super.onDestroy();
        Log.d("ciclovida", "onDestroy");
    }

    public void tweetar (View v){
        //refereciando o multtext que recebe os dados
        EditText tweettext = (EditText) findViewById(R.id.text_twt);
        //Pegando o conteúdo digitado
        String tweet = tweettext.getText().toString();

        Tweet twt = new Tweet(tweet,"Angele", new Date());

        //Adicionando a lista
        tweets.add(twt);
        /*
        Para quando se usa um MultText
        EditText log_twt = (EditText) findViewById(R.id.log_twt);
        String tweetlog = log_twt.getText().toString();
        tweetlog = tweet +"\n" + tweetlog;
        log_twt.setText(tweetlog);
        */

        //notifica o adapter quando houve mudanças devido ao chamado do método
        adapter.notifyDataSetChanged();
        tweettext.setText(""); //limpa o campo de texto.

    }
}
