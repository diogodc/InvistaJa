package br.com.invistaja.invistaja.view.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import br.com.invistaja.invistaja.R;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splash = new Intent(Splash.this,
                        Principal.class);
                Splash.this.startActivity(splash);
                Splash.this.finish();
            }
        }, 3000);
    }
}
