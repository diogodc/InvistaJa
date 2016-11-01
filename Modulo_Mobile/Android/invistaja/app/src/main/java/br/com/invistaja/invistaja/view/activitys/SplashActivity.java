package br.com.invistaja.invistaja.view.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.Window;

import br.com.invistaja.invistaja.R;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splash = new Intent(SplashActivity.this,
                        PrincipalActivity.class);
                SplashActivity.this.startActivity(splash);
                SplashActivity.this.finish();
            }
        }, 3500);
    }
}
