package br.com.invistaja.invistaja.view.activitys;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;

import br.com.invistaja.invistaja.R;
import br.com.invistaja.invistaja.view.fragments.ConteudoFragment;
import br.com.invistaja.invistaja.view.fragments.IntroducaoFragment;

public class PrincipalActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.activity_principal);
        this.setNewFragment(new IntroducaoFragment(),R.id.frlIntroducao);
        this.setNewFragment(new ConteudoFragment(),R.id.frlConteudo);
    }

    public void onClickBtLogin(View view){
        new AlertDialog.Builder(this)
            .setTitle(R.string.str_atencao)
            .setMessage(R.string.str_teste)
            .setNeutralButton(R.string.str_opcao_ok,null).show();
    }

    private void setNewFragment(Fragment frg ,int frl){
        FragmentManager manFrg = getSupportFragmentManager();
        FragmentTransaction traFrg = manFrg.beginTransaction();
        traFrg.replace(frl, frg);
        traFrg.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        traFrg.commit();
    }
}
