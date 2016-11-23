package br.com.invistaja.invistaja.view.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import br.com.invistaja.invistaja.R;

public class SplashView extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splash = new Intent(SplashView.this,
                        PrincipalView.class);
                SplashView.this.startActivity(splash);
                SplashView.this.finish();
            }
        }, 3000);
    }
}
