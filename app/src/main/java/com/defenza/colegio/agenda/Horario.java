package com.defenza.colegio.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class Horario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_horario);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button btnPrueba = (Button) findViewById(R.id.buttonPrueba);
        btnPrueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(
                        Horario.this);
                //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                //alert.setTitle("Resultados Salomon k21");

                WebView wv = new WebView(Horario.this);
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
        });

        //WebView myWebView = (WebView) findViewById(R.id.webView);
        //myWebView.loadUrl("https://amatellanes.wordpress.com/");

    }
}
