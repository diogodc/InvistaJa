package br.com.invistaja.invistaja.view.activitys;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import br.com.invistaja.invistaja.R;
import br.com.invistaja.invistaja.view.fragments.ConteudoView;
import br.com.invistaja.invistaja.view.fragments.InformacoesView;
import br.com.invistaja.invistaja.view.fragments.IntroducaoView;
import br.com.invistaja.invistaja.view.fragments.SobreView;

import static br.com.invistaja.invistaja.app.Funcoes.iniciarActivity;
import static br.com.invistaja.invistaja.app.Funcoes.iniciarFragment;
import static br.com.invistaja.invistaja.app.Funcoes.menuGeral;

public class PrincipalView extends FragmentActivity {

    private String str_titulo = "Mussum Ipsum cacilds";
    private String str_corpo = "Mussum Ipsum, cacilds vidis litro abertis." +
            "Manduma pindureta quium dia nois paga." +
            "Si u mundo tá muito paradis?" +
            "Toma um mé que o mundo vai girarzis!" +
            "Admodum accumsan disputationi eu sit." +
            "Vide electram sadipscing et per." +
            "Casamentiss faiz malandris se pirulitá." +
            "Ta deprimidis, eu conheço uma cachacis que pode alegrar sua vidis." +
            "in elementis mé pra quem é amistosis quis leo." +
            "Suco de cevadiss deixa as pessoas mais interessantiss." +
            "Pra lá , depois divoltis porris, paradis." +
            "Atirei o pau no gatis, per gatis num morreus. " +
            "Detraxit consequat et quo num tendi nada. " +
            "Cevadis im ampola pa arma uma pindureta. " +
            "Sapien in monti palavris qui num significa nadis i pareci latim. ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_principal);
        iniciarFragment(new IntroducaoView(), R.id.frlIntroducao, getSupportFragmentManager());
        iniciarFragment(new ConteudoView(), R.id.frlConteudo, getSupportFragmentManager());
        iniciarFragment(new SobreView(), R.id.frlSobre, getSupportFragmentManager());
        iniciarFragment(new InformacoesView(), R.id.frlInformacoes, getSupportFragmentManager());
    }

    public void onClickBtLogin(View view) {
        iniciarActivity(PrincipalView.this,LoginView.class,null);
    }

    public void onClickImageButtonsArtigos(View view) {
        Bundle paramentros = new Bundle();
        switch (view.getId()) {
            case R.id.imgCabin:
                paramentros.putString("Titulo", this.str_titulo);
                paramentros.putString("Corpo", this.str_corpo);
                break;
            case R.id.imgCake:
                paramentros.putString("Titulo", this.str_titulo);
                paramentros.putString("Corpo", this.str_corpo);
                break;
            case R.id.imgCircus:
                paramentros.putString("Titulo", this.str_titulo);
                paramentros.putString("Corpo", this.str_corpo);
                break;
            case R.id.imgGame:
                paramentros.putString("Titulo", this.str_titulo);
                paramentros.putString("Corpo", this.str_corpo);
                break;
            case R.id.imgSafe:
                paramentros.putString("Titulo", this.str_titulo);
                paramentros.putString("Corpo", this.str_corpo);
                break;
            case R.id.imgSubmarine:
                paramentros.putString("Titulo", this.str_titulo);
                paramentros.putString("Corpo", this.str_corpo);
                break;
            default:
                paramentros.putString("Titulo", this.str_titulo);
                paramentros.putString("Corpo", this.str_corpo);
                break;
        }
        iniciarActivity(this, ArtigosView.class, paramentros);
    }

    public void onClickMenu(View view){
        menuGeral(this);
    }
}

