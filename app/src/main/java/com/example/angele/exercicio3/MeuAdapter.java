package com.example.angele.exercicio3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by angele on 17/03/18.
 * Adapter que implementa um novo getview customizado
 */

public class MeuAdapter extends ArrayAdapter<Tweet>{
    private Context mContext;
    private List<Tweet> mTweet = new ArrayList<>();

    public MeuAdapter(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes ArrayList<Tweet> list) {
        super(context, 0,list);
        mContext=context;
        mTweet=list;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listarTweets = convertView;

        //If convertView == null then the view should be inflated
        if (listarTweets==null)
            listarTweets = LayoutInflater.from(mContext).inflate(R.layout.lista_personalizada, parent, false);
        Tweet tweet_atual= mTweet.get(position);

        ListView tweetlogs = (ListView) listarTweets.findViewById(R.id.list_log_twt);
        TextView autor = (TextView) listarTweets.findViewById(R.id.lista_autor);
        TextView texto = (TextView) listarTweets.findViewById(R.id.lista_texto);
        TextView data = (TextView) listarTweets.findViewById(R.id.lista_data);

        autor.setText(tweet_atual.getAutor().getNome());
        texto.setText(tweet_atual.getTexto());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String data_aux= sdf.format(tweet_atual.getData());
        data.setText(data_aux);

        return listarTweets;
    }
}