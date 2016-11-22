package br.com.invistaja.invistaja.view.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import br.com.invistaja.invistaja.R;

import static br.com.invistaja.invistaja.app.Funcoes.aplicarMascaras;
import static br.com.invistaja.invistaja.app.Funcoes.mascaraTelefone;

public class Contato extends Activity {

    private EditText edtTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);
        this.inflarComponetes();
        aplicarMascaras(this.edtTelefone,mascaraTelefone);
    }

    private void inflarComponetes(){
        this.edtTelefone = (EditText) findViewById(R.id.edtTelefone);
    }
}
