package br.com.invistaja.invistaja.view.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import br.com.invistaja.invistaja.R;

import static br.com.invistaja.invistaja.app.FuncoesGerais.aplicarMascaras;
import static br.com.invistaja.invistaja.app.FuncoesGerais.mascaraTelefone;

public class Cadastro extends Activity {

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
