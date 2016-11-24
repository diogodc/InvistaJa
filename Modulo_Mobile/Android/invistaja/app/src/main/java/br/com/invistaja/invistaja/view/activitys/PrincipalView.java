package br.com.invistaja.invistaja.view.activitys;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import br.com.invistaja.invistaja.R;
import br.com.invistaja.invistaja.view.fragments.ConteudoView;
import br.com.invistaja.invistaja.view.fragments.InformacoesView;
import br.com.invistaja.invistaja.view.fragments.IntroducaoView;
import br.com.invistaja.invistaja.view.fragments.SobreView;
import br.com.invistaja.invistaja.view.iView;

import static br.com.invistaja.invistaja.app.Funcoes.context;
import static br.com.invistaja.invistaja.app.Funcoes.iniciarActivity;
import static br.com.invistaja.invistaja.app.Funcoes.iniciarFragment;
import static br.com.invistaja.invistaja.app.Funcoes.menuGeral;
import static br.com.invistaja.invistaja.app.Funcoes.usuarioLogado;

public class PrincipalView extends FragmentActivity implements iView {

    private Button btnLogin;
    private LinearLayout lytLogin;
    private String str_titulo1 = "Aprendendo a Investir";
    private String str_corpo1 = "Uma pessoa de bom senso deve simplesmente ignorar \"dicas\" para ficar rico da noite para o dia. Definitivamente as probabilidades estão contra você, quando se trata de ganhar uma bolada ou herdar uma fortuna." +
            "\n No entanto, a boa notícia é que você pode construir um patrimônio mesmo assim. Para tanto é necessário ter um plano de investimento." +
            "\n Investimento não é jogo. Jogo é para especuladores que \"apostam\" todas as suas \"fichas\" numa única \"dica\" e ficam torcendo dia e noite pelo resultado de suas apostas. Tudo o que você não precisa para ter sucesso em seus investimentos são apostas, fichas e dicas. Num processo de investimento não há apostas e nem fichas e dicas, mas sim objetivos e a melhor carteira (alocação de ativos) para conquistá-los. Afinal, investimento bem-sucedido é aquele que vai fazer com que você conquiste seus objetivos." +
            "\n Não existe o melhor investimento, mas sim o investimento mais adequado para você atingir seus objetivos.";

    private String str_titulo2 = "Organize sua Contas";
    private String str_corpo2 = "Um orçamento mostrará qual a sua situação financeira atual, se suas despesas cabem no seu salário. Ele é a fotografia de suas despesas e receitas." +
            "\n Se o que você ganha não cobre suas despesas mensais sua situação já é bastante perigosa, principalmente num país como o Brasil, onde as taxas de juro estão muito altas. Comece a fazer já o seu orçamento e convoque a família porque os cortes precisam ser feitos em conjunto." +
            "\n Se seu salário cobre suas despesas, mas não há sobras, você pode ter problemas. Por isso, chame sua família para uma conversa e mostre que, sem sobras no orçamento não será possível conquistar objetivos, como a viagem, a faculdade e até mesmo a casa própria. Juntos avaliem as despesas e vejam como podem cortar um pouco de cada item." +
            "\n Se você está com folga no orçamento, parabéns! Você faz parte de um seleto grupo que já consegue ter sobras no fim do mês. No entanto avalie se:" +
            "\n ... você fez as contas corretamente" +
            "\n ... você não esqueceu de colocar nenhum item de despesa;" +
            "\n ... o que está sobrando é suficiente para conquistar seus objetivos.";

    private String str_titulo3 = "Análise de perfil";
    private String str_corpo3 = "O mercado financeiro possui uma infinidade de ativos e produtos diferentes, cada um com características bem particulares. O investidor vê-se diante de muitas opções e uma pergunta. Qual é o mais indicado para si? Os bancos e corretoras criaram uma forma de ajudar o investidor a descobrir os melhores produtos para aplicar seus recursos. O procedimento foi batizado de Análise de Perfil do Investidor (API). Em geral, trata-se de um questionário onde os clientes respondem sobre sua condição financeira, idade, quantidade de recursos que disponibilizam para investir, para que pretendem utilizar o capital que estão investindo, em quanto tempo etc. As respostas agrupadas mostram o seu perfil de investidor e, em alguns casos, já sugerem em quais produtos você pode alocar que fatias do seu capital. Isso dá mais segurança para o cliente, no momento de ele investir seus recursos. No exterior, a API é conhecida como suitability e é bastante aplicada em países onde o mercado de investimentos é maduro.";

    private String str_titulo4 = "O salário acabou?";
    private String str_corpo4 = "Relaxe! Você não está sozinho. Dados do IBGE dão conta de que 85% das famílias brasileiras têm algum tipo de dificuldade para chegar ao fim do mês com a renda que recebem." +
            "\n Observe que, segundo os dados do IBGE, quanto maior a renda menor a dificuldade, um resultado, a princípio, óbvio. Mas, quando analisado no detalhe, ainda assim é muito preocupante. Isso porque, mesmo famílias que estão na faixa de renda mais alta do estudo (acima de R$ 6 mil) têm pouca habilidade para manejar o orçamento." +
            "\n Veja os números: 53,45% das famílias que ganham mais de R$ 6 mil tem problemas para chegar ao fim do mês. Desse grupo, 6,66% tem muita dificuldade, 11,95% tem dificuldade e 36,74% tem alguma dificuldade. Pode-se dizer, sem medo de errar, que uma renda de R$ 6 mil não faz uma família rica, nem tampouco pobre." +
            "\n Assim, o grande problema dessas famílias não é falta de dinheiro, mas principalmente de planejamento financeiro." +
            "\n O planejamento financeiro é a melhor resposta para que esse enorme grupo de famílias que não consegue chegar ao fim do mês com o salário consiga colocar sua vida financeira em ordem, sem sofrimento, pois, o planejamento financeiro vai equilibrar suas receitas e despesas.";

    private String str_titulo5 = "Minhas dívidas";
    private String str_corpo5 = "Se você parou nesta área é porque deve estar com algum problema financeiro. Algo assim como uma fatura impagável no cartão de crédito, um limite estourado no cheque especial e o medo de encontrar na rua o gerente do banco. Ou seja, você se endividou um tanto além da conta. Mas o pior é que, desesperado, pode estar prestes a contrair novas dívidas para pagar as já vencidas.\n" +
            "Pare já. Dívidas impossíveis de pagar não se resolvem com novas. Só se pode sair delas com uma cuidadosa estratégia para pagar cada uma delas.\n" +
            "Aperte o orçamento, sente-se com seus credores e comece a elaborar uma estratégia para finalizar uma a uma.\n" +
            "Por que as pessoas têm problemas com dívidas?\n" +
            "• Porque enfrentam problemas inesperados causados por doença, divócio ou desemprego;\n" +
            "• Porque não têm controle de seus orçamentos e não se planejam para o futuro;\n" +
            "• Porque não têm noções de planejamento financeiro e acabam fazendo operações de crédito que comprometem mais de 30% do orçamento.\n" +
            "Curiosidade\n" +
            "Você sabia que nos EUA, mais de 1,4 milhão de indivíduos pediram falência em 2001, um aumento significativo se comparado ao número de falências pessoais 20 anos antes, que era de 316 mil?\n" +
            "Quanto devo?\n" +
            "Para começar, faça uma lista de todas as suas dívidas. Ao terminar, é possível que o coração palpite e a mão trema. Mas pode apostar você deu o primeiro passo para resolver seus problemas.\n" +
            "O pior para quem está endividado é não conhecer a dimensão real do problema. Você sabe que ele existe porque os credores estão pressionando, mas às vezes sua angústia é exagerada. É por isso que vale a pena fazer uma relação de todos esses números.\n" +
            "Dívidas que ficam apenas nos nossos pensamentos nos deixam deprimidos, atrapalham a concentração no trabalho e trazem conflitos à vida em família. No entanto, quando se começa a lidar com o problema de frente, de uma forma realista, esteja certo de que se sentirá mais animado, porque, seja qual for a sua situação, você começou a trilhar o caminho para resolvê-la.\n" +
            "Como se livrar das dívidas\n" +
            "Depois de listar todas as dívidas, coloque-as em ordem decrescente, da mais cara para a mais barata. As mais caras são as que você deve atacar primeiro, e não o contrário.\n" +
            "Outra providência importante é fazer um orçamento. De novo, faça uma lista. Coloque seu salário e outras fontes de renda que tiver, no lado esquerdo, e todas as suas despesas mensais no lado direito. Esqueça suas dívidas nesse momento. Deixe de fora até as prestações que você assumiu. Agora, subtraindo o total das despesas do total das receitas, veja quanto sobrou. Esse é o dinheiro que você tem para pagar todo mês suas dívidas.\n" +
            "O ideal é que você reserve de 20% a, no máximo, 30% de sua renda mensal para o pagamento de dívidas. Mais que isso é candidatar-se a ter problemas no futuro, porque você não conseguirá manter por muito tempo a disciplina dos pagamentos mensais.\n" +
            "Não se preocupe com o tempo que vai levar para quitar suas dívidas. O fundamental é interromper o processo de endividamento e começar a liquida-las, para viver melhor.\n" +
            "Se você tem um bem, poderá vender. Um carro, por exemplo. Além da economia com seguro e taxas como IPVA, você pode abater uma parte de sua dívida.\n" +
            "Quanto custa cada dívida\n" +
            "O custo de uma dívida é a taxa de juro que você paga. Mas, se você já está inadimplente, acrescente nesse custo as multas pelo atraso. Quanto antes você conversar com seu credor, melhor. Ao negociar uma forma de pagamento você interrompe o acúmulo de juros e multas que acabam virando uma bola de neve.\n" +
            "O cheque especial costuma ser a dívida mais cara. Um jeito fácil de liquidar esse problema é fazer uma troca. Peça para cancelar o seu cheque especial e transforme a dívida num empréstimo pessoal com parcelas mensais fixas. Você vai ver que sai bem mais em conta. Mas não deixe de cancelar o cheque especial, porque, do contrário, estará apenas contraindo mais uma dívida.\n" +
            "A quem recorrer\n" +
            "Converse com o gerente de seu banco. Ele poderá ajudá-lo nesse processo. Poderá, por exemplo, encontrar alternativas de crédito mais barato para que você troque as dívidas caras por dívidas mais baratas.\n" +
            "É importante ter uma planilha organizada, com todos os custos devidamente calculados e projeções de pagamento. Seu gerente pode lhe ajudar nesta tarefa.\n" +
            "Para escapar das dívidas, é necessário ter informação (como as que você vai obter aqui), paciência (se não tem, trate de desenvolver esse atributo) e disciplina (vale a mesma recomendação do item anterior).\n" +
            "Família: solução ou problema?\n" +
            "Deixe seus parentes e amigos longe de suas dívidas. Pedir dinheiro emprestado a parentes é um erro comum que, em geral, além de não resolver o problema ainda cria mais um, o das brigas familiares.\n" +
            "Você deve, contudo, buscar apoio em seus filhos e mulher (ou marido). Este é um problema de todos. Reúna a família e exponha a real situação. Definam juntos quais os gastos cortar.\n" +
            "Considere:\n" +
            "• Saldar dívidas pode significar perda de capital e quem quer sair do vermelho deve estar preparado para isso. Enxugar contas e vender bens pode fazer parte do processo.\n" +
            "• Defina os gastos prioritários. Corte os gastos supérfluos e que não acrescentam nada aos seus objetivos de equilíbrio financeiro.\n" +
            "• Assim que perceber que terá problemas para continuar pagando uma dívida, procure imediata e diretamente o credor, informando sua situação. Essa medida evitará que sua dívida cresça muito.\n" +
            "• Mesmo endividado, você deve traçar metas: assim que liquidar uma dívida, comece a poupar para um determinado objetivo.\n" +
            "• Abra mão de uma coisa que deseje muito hoje, com o objetivo de equilibrar suas finanças e poder adquirir aquilo que quer no futuro.\n";

    private String str_titulo6 = "Investimentos";
    private String str_corpo6 = "\n" +
            "Sua principal preocupação hoje é acumular patrimônio? Ou seu objetivo atual é proteger o patrimônio que você já acumulou? É importante entender que não existe a melhor opção, e sim a mais adequada a suas necessidades e expectativas.\n" +
            "Há várias formas de você investir seu dinheiro: comprar um imóvel, aplicar em títulos de renda fixa ou em ações são alguns exemplos. Um aspecto importante é definir qual a meta de rentabilidade para a aplicação.\n" +
            "Se sua meta é acumular patrimônio você terá, necessariamente, de buscar aplicações mais arrojadas. Esses investimentos têm maior potencial de ganho ao longo do tempo, e consequentemente um maior grau de risco.\n" +
            "Mas, se você quer apenas proteger seu patrimônio, opte por aplicações mais conservadoras, mas com uma taxa de retorno acima da inflação.\n" +
            "Ao escolher um investimento arrojado é importante que sua decisão seja baseada em seus objetivos e tempo de aplicação, e sua tolerância ao risco de perda.\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.inflarComponetes();
        iniciarFragment(new IntroducaoView(), R.id.frlIntroducao, getSupportFragmentManager());
        iniciarFragment(new ConteudoView(), R.id.frlConteudo, getSupportFragmentManager());
        iniciarFragment(new SobreView(), R.id.frlSobre, getSupportFragmentManager());
        iniciarFragment(new InformacoesView(), R.id.frlInformacoes, getSupportFragmentManager());
    }

    @Override
    public void inflarComponetes() {
        this.setContentView(R.layout.activity_principal);
        this.btnLogin = (Button) this.findViewById(R.id.btnLogin);
        this.lytLogin = (LinearLayout) this.findViewById(R.id.lytLogin);
        Bundle paramentro = this.getIntent().getExtras();
        if (paramentro !=null){
            if (paramentro.getBoolean("menu") == false) {
                this.btnLogin.setText("Olá " + usuarioLogado.getName());
                this.btnLogin.setAllCaps(false);
            }else{
                this.btnLogin.setText(R.string.str_frg_conteudo_logar);
                this.btnLogin.setAllCaps(true);
            }
        }
    }

    public void onClickBtLogin(View view) {
        if (usuarioLogado==null) {
            iniciarActivity(PrincipalView.this, LoginView.class, null);
            this.finish();
        }else{
            menuGeral(this);
        }
    }

    public void onClickImageButtonsArtigos(View view) {
        Bundle paramentros = new Bundle();
        switch (view.getId()) {
            case R.id.imgCabin:
                paramentros.putString("Titulo", this.str_titulo1);
                paramentros.putString("Corpo", this.str_corpo1);
                break;
            case R.id.imgCake:
                paramentros.putString("Titulo", this.str_titulo2);
                paramentros.putString("Corpo", this.str_corpo2);
                break;
            case R.id.imgGame:
                paramentros.putString("Titulo", this.str_titulo3);
                paramentros.putString("Corpo", this.str_corpo3);
                break;
            case R.id.imgCircus:
                paramentros.putString("Titulo", this.str_titulo4);
                paramentros.putString("Corpo", this.str_corpo4);
                break;
            case R.id.imgSafe:
                paramentros.putString("Titulo", this.str_titulo5);
                paramentros.putString("Corpo", this.str_corpo5);
                break;
            case R.id.imgSubmarine:
                paramentros.putString("Titulo", this.str_titulo6);
                paramentros.putString("Corpo", this.str_corpo6);
                break;
            default:
                paramentros.putString("Titulo", this.str_titulo1);
                paramentros.putString("Corpo", this.str_corpo1);
                break;
        }
        iniciarActivity(this, ArtigosView.class, paramentros);
    }

    public void onClickMenu(View view){
        menuGeral(this);
    }
}

