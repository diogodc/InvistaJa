package br.com.invistaja.invistaja.view.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.EditText;

import br.com.invistaja.invistaja.R;
import br.com.jansenfelipe.androidmask.MaskEditTextChangedListener;

import static br.com.invistaja.invistaja.app.FuncoesGeraisApp.aplicarMascaras;
import static br.com.invistaja.invistaja.app.FuncoesGeraisApp.mascaraTelefone;

public class CadastroActivity extends Activity {

    private EditText edtTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_cadastro);
        this.inflarComponetes();
        aplicarMascaras(this.edtTelefone,mascaraTelefone);
    }

    private void inflarComponetes(){
        this.edtTelefone = (EditText) findViewById(R.id.edtTelefone);
    }
}
