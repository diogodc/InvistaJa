package br.com.invistaja.invistaja.view.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import br.com.invistaja.invistaja.R;

public class ArtigosActivity extends Activity {
    private TextView titulo;
    private TextView corpo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_artigos);
        this.inflarComponentes();
        this.setArtigo(this.getIntent().getExtras());
    }

    private void inflarComponentes(){
        this.titulo = (TextView) findViewById(R.id.idTitulo);
        this.corpo = (TextView) findViewById(R.id.idCorpo);
    }

    public void setArtigo(Bundle artigo){
        this.titulo.setText(artigo.getString("Titulo"));
        this.corpo.setText(artigo.getString("Corpo"));
    }
}
