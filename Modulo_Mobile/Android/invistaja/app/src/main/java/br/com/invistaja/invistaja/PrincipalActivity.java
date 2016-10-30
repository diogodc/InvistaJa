package br.com.invistaja.invistaja;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class PrincipalActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_principal);
    }

    public void onClickBtLogin(View view){
        new AlertDialog.Builder(this)
                .setTitle(R.string.str_atencao)
                .setMessage(R.string.str_teste)
                .setNeutralButton(R.string.str_opcao_ok,null).show();
    }


}
