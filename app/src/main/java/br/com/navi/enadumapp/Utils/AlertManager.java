package br.com.navi.enadumapp.Utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Victor Monte on 20/08/2016.
 */
public class AlertManager {

    public static void Alertar(Activity context, String mensagem, Intent intent){
        // Construtor de Mensagem
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(mensagem)
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        //Mensagem
        AlertDialog alert = builder.create();
        alert.setTitle("Enadum Informa");
        alert.show();


        //Redireciona
        if (intent != null)
        {
            context.startActivity(intent);
        }
    }
}
