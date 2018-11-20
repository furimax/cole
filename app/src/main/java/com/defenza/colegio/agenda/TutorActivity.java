package com.defenza.colegio.agenda;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.defenza.colegio.agenda.ui.actividades.MainActivity;

public class TutorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor);
    }

    public  void  notas(View view){

        AlertDialog.Builder alert = new AlertDialog.Builder(
                this);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //alert.setTitle("Resultados Salomon k21");

        WebView wv = new WebView(this);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("https://docs.google.com/spreadsheets/d/e/2PACX-1vSYF_16iovQ7dqy0pdxw5GE-xmS1wmYhuMRI4CnzMsXQcf1uL-rP6xcSWayWVRj6U8zXs7pq95Wv93j/pubhtml");
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view,
                                                    String url) {
                view.loadUrl(url);

                return true;
            }
        });

        alert.setNegativeButton("Close",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        Dialog d = alert.setView(wv).create();
        d.show();
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(d.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.FILL_PARENT;
//                lp.height = WindowManager.LayoutParams.FILL_PARENT;
        d.getWindow().setAttributes(lp);



    }


    public  void  asistencia(View view){

        AlertDialog.Builder alert = new AlertDialog.Builder(
                this);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //alert.setTitle("Resultados Salomon k21");

        WebView wv = new WebView(this);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("https://docs.google.com/spreadsheets/d/e/2PACX-1vTWz2nSCI5SX91PulaYRmbB1DAGbck4N7gLUAjl38i7rMTbScvQDDliSLpSGq-hUjJZKkLXKiAzwPFF/pubhtml");
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view,
                                                    String url) {
                view.loadUrl(url);

                return true;
            }
        });

        alert.setNegativeButton("Close",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        Dialog d = alert.setView(wv).create();
        d.show();
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(d.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.FILL_PARENT;
//                lp.height = WindowManager.LayoutParams.FILL_PARENT;
        d.getWindow().setAttributes(lp);



    }

    public  void  tareas(View view){

        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);


    }






}
