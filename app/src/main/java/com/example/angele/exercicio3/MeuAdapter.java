package com.example.angele.exercicio3;

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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by angele on 17/03/18.
 * Adapter que implementa um novo getview customizado
 */

public class MeuAdapter extends ArrayAdapter<Tweet>{
    private Context mContext;
    private List<Tweet> mTweet = new ArrayList<>();

    public MeuAdapter(@NonNull Context context, @LayoutRes ArrayList<Tweet> list) {
        super(context, 0,list);
        mContext=context;
        mTweet=list;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listarTweets = convertView;
        //If convertView == null then the view should be inflated
        if (listarTweets==null)
            listarTweets = LayoutInflater.from(mContext).inflate(R.layout.activity_main, parent, false);
        Tweet tweet_atual= mTweet.get(position);

        ListView tweetlogs = (ListView) listarTweets.findViewById(R.id.list_log_twt);





        return listarTweets;
    }
}
