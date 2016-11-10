package br.com.invistaja.invistaja.view.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import br.com.invistaja.invistaja.R;

public class CadastroActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.activity_cadastro);
    }
}
