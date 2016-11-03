package br.com.invistaja.invistaja.view.activitys;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import br.com.invistaja.invistaja.R;
import br.com.invistaja.invistaja.view.fragments.ConteudoFragment;
import br.com.invistaja.invistaja.view.fragments.IntroducaoFragment;
import static br.com.invistaja.invistaja.app.FuncoesGeraisApp.iniciarActivity;
import static br.com.invistaja.invistaja.app.FuncoesGeraisApp.iniciarFragment;

public class PrincipalActivity extends FragmentActivity {

    private String str_titulo = "Mussum Ipsum cacilds";
    private String str_corpo  = "Mussum Ipsum, cacilds vidis litro abertis." +
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
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.activity_principal);
        iniciarFragment(new IntroducaoFragment(),R.id.frlIntroducao,getSupportFragmentManager());
        iniciarFragment(new ConteudoFragment(),R.id.frlConteudo,getSupportFragmentManager());
    }

    public void onClickBtLogin(View view){
        new AlertDialog.Builder(this)
            .setTitle(R.string.str_atencao)
            .setMessage(R.string.str_teste)
            .setNeutralButton(R.string.str_opcao_ok,null).show();
    }

    public void onClickImageButtonsArtigos(View view){
        Bundle paramentros = new Bundle();
        switch (view.getId()){
            case R.id.imgCabin:
                paramentros.putString("Titulo",this.str_titulo);
                paramentros.putString("Corpo",this.str_corpo);
                break;
            case R.id.imgCake:
                paramentros.putString("Titulo",this.str_titulo);
                paramentros.putString("Corpo",this.str_corpo);
                break;
            case R.id.imgCircus:
                paramentros.putString("Titulo",this.str_titulo);
                paramentros.putString("Corpo",this.str_corpo);
                break;
            case R.id.imgGame:
                paramentros.putString("Titulo",this.str_titulo);
                paramentros.putString("Corpo",this.str_corpo);
                break;
            case R.id.imgSafe:
                paramentros.putString("Titulo",this.str_titulo);
                paramentros.putString("Corpo",this.str_corpo);
                break;
            case R.id.imgSubmarine:
                paramentros.putString("Titulo",this.str_titulo);
                paramentros.putString("Corpo",this.str_corpo);
                break;
            default:
                paramentros.putString("Titulo",this.str_titulo);
                paramentros.putString("Corpo",this.str_corpo);
                break;
        }
        iniciarActivity(this,ArtigosActivity.class,paramentros);
    }

    public void onClickBtTracarPerfil(View view){
        new AlertDialog.Builder(this)
                .setTitle(R.string.str_atencao)
                .setMessage(R.string.str_teste)
                .setNeutralButton(R.string.str_opcao_ok,null).show();
    }
}
