package com.example.angele.exercicio3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

/**
 * Created by angele on 17/03/18.
 * Adapter que implementa um novo getview customizado
 */

public class MeuAdapter extends ArrayAdapter{

    public MeuAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

}
