package br.com.invistaja.invistaja.view.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.com.invistaja.invistaja.R;
import br.com.invistaja.invistaja.view.iView;

import static br.com.invistaja.invistaja.app.Funcoes.aplicarMascaras;
import static br.com.invistaja.invistaja.app.Funcoes.mascaraTelefone;
import static br.com.invistaja.invistaja.app.Funcoes.usuarioLogado;

public class ContatoAtualizarView extends Activity implements iView {
    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtSenha;
    private EditText edtTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_atualizar);
        this.inflarComponetes();
        this.lerUsuarioLogado();
    }

    public void inflarComponetes(){
        this.edtNome = (EditText) findViewById(R.id.edtNome);
        this.edtEmail = (EditText) findViewById(R.id.edtEmail);
        this.edtSenha = (EditText) findViewById(R.id.edtSenha);
        this.edtTelefone = (EditText) findViewById(R.id.edtTelefone);
        aplicarMascaras(this.edtTelefone,mascaraTelefone);
    }

    private void lerUsuarioLogado(){
        this.edtNome.setText((usuarioLogado.getName()));
        this.edtEmail.setText((usuarioLogado.getLogin()));
        this.edtSenha.setText((usuarioLogado.getPassword()));
        this.edtTelefone.setText((usuarioLogado.getCellphone()));
    }

    public void onClickBtAtualizar(View view){

    }
}
