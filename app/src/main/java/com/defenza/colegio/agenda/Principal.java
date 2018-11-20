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

import com.defenza.colegio.agenda.estudiante.ui.actividades.AlumnoActivity;
import com.defenza.colegio.agenda.login.LoginActivity;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

    }


    public  void  historia(View view){

        AlertDialog.Builder alert = new AlertDialog.Builder(
                this);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //alert.setTitle("Resultados Salomon k21");

        WebView wv = new WebView(this);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("https://docs.google.com/spreadsheets/d/e/2PACX-1vQBdQsv41_Gyzz-RHMfi8uBZk-vkBom-DOh2b6S0FD6Esy_0DxF2brsgiMfB7JlAmUPuobNzWCPDr2K/pubhtml");
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
    public  void  niveles(View view){

        AlertDialog.Builder alert = new AlertDialog.Builder(
                this);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //alert.setTitle("Resultados Salomon k21");

        WebView wv = new WebView(this);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("https://docs.google.com/document/d/e/2PACX-1vT5fm1zhca0F_xDQ3CF512eNIc4LxU6iJrKA9sjibh-_KlfeKkIm7MY4B999Mwt9ivBQBJ7Bb_9lhRo/pub");
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

    public  void  calendario(View view){

      /*  AlertDialog.Builder alert = new AlertDialog.Builder(
                this);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //alert.setTitle("Resultados Salomon k21");

        WebView wv = new WebView(this);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("https://docs.google.com/spreadsheets/d/e/2PACX-1vQHg4dz8pz46XoDWB_OkzVx_Wr_U_l22sVC6cCbNVpVRjvbXyEbkTawwsMQxbu1fSb4tNM60zQJ6lHs/pubhtml");
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
        d.getWindow().setAttributes(lp);*/
        Intent intent= new Intent(this,AlumnoActivity.class);
        startActivity(intent);


    }

    public  void  inscripciones(View view){

        AlertDialog.Builder alert = new AlertDialog.Builder(
                this);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //alert.setTitle("Resultados Salomon k21");

        WebView wv = new WebView(this);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("https://goo.gl/forms/UWlsoT1p5uYTni7C2");
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

    public  void  siguiente(View view){

        Intent intent= new Intent(this,LoginActivity.class);
        startActivity(intent);


    }




}
