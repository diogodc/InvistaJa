<?php defined('BASEPATH') OR exit('No direct script access allowed'); ?>
<?php $this->load->view('head'); ?>
<header>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <img class="img-responsive" src="<?php echo base_url("assets/img/profile.png") ?>" alt="Invista Já!">
                <div class="intro-text">
                    <span class="name">Quero ficar rico!!</span>
                    <hr class="star-light">
                    <span class="skills">O Invista Já vai te ajudar a melhorar de vida</span>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- Portfolio Grid Section -->
<section id="portfolio">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2>Aprenda a Investir</h2>
                <hr class="star-primary">
            </div>
        </div>
        <div class="row">
            <div class="col-sm-4 portfolio-item">
                <p>Por onde começar?</p>
                <a href="#portfolioModal1" class="portfolio-link" data-toggle="modal">
                    <div class="caption">
                        <div class="caption-content">
                            <i class="fa fa-search-plus fa-3x"></i>
                        </div>
                    </div>
                    <img src="<?php echo base_url("assets/img/portfolio/cabin.png") ?>" class="img-responsive" alt="Por onde começar?">
                </a>
            </div>
            <div class="col-sm-4 portfolio-item">
                <p>Organize suas contas!</p>
                <a href="#portfolioModal2" class="portfolio-link" data-toggle="modal">
                    <div class="caption">
                        <div class="caption-content">
                            <i class="fa fa-search-plus fa-3x"></i>
                        </div>
                    </div>
                    <img src="<?php echo base_url("assets/img/portfolio/cake.png") ?>" class="img-responsive" alt="Organize suas contas">
                </a>
            </div>
            <div class="col-sm-4 portfolio-item">
                <p>Análise de perfil</p>
                <a href="#portfolioModal3" class="portfolio-link" data-toggle="modal">
                    <div class="caption">
                        <div class="caption-content">
                            <i class="fa fa-search-plus fa-3x"></i>
                        </div>
                    </div>
                    <img src="<?php echo base_url("assets/img/portfolio/game.png") ?>" class="img-responsive" alt="Análise de perfil">
                </a>
            </div>
            <div class="col-sm-4 portfolio-item">
                <p>O salário acabou?</p>
                <a href="#portfolioModal4" class="portfolio-link" data-toggle="modal">
                    <div class="caption">
                        <div class="caption-content">
                            <i class="fa fa-search-plus fa-3x"></i>
                        </div>
                    </div>
                    <img src="<?php echo base_url("assets/img/portfolio/circus.png") ?>" class="img-responsive" alt="O salário acabou?">
                </a>
            </div>
            <div class="col-sm-4 portfolio-item">
                <p>Minhas dívidas</p>
                <a href="#portfolioModal5" class="portfolio-link" data-toggle="modal">
                    <div class="caption">
                        <div class="caption-content">
                            <i class="fa fa-search-plus fa-3x"></i>
                        </div>
                    </div>
                    <img src="<?php echo base_url("assets/img/portfolio/safe1.png") ?>" class="img-responsive" alt="Minhas dívidas">
                </a>
            </div>
            <div class="col-sm-4 portfolio-item">
                <p>Investimentos</p>
                <a href="#portfolioModal6" class="portfolio-link" data-toggle="modal">
                    <div class="caption">
                        <div class="caption-content">
                            <i class="fa fa-search-plus fa-3x"></i>
                        </div>
                    </div>
                    <img src="<?php echo base_url("assets/img/portfolio/submarine.png") ?>" class="img-responsive" alt="Investimentos">
                </a>
            </div>
        </div>
    </div>
</section>

<!-- About Section -->
<section class="success" id="about" style="text-align: justify">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2>De Onde Viemos</h2>
                <hr class="star-light">
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4 col-lg-offset-2">
                <p>Somos uma equipe de estudantes e desenvolvemos esse projeto para atender a necessidade de uma parte da população com pouco acesso a informações sobre finanças.</p>
            </div>
            <div class="col-lg-4">
                <p>Estamos buscando levar a sustentabilidade social a um sistema que não favorece a todos, e tentando gerar informação confiável e que gere conhecimento.</p>
            </div>
        </div>
    </div>
</section>

<?php $this->load->view('footer'); ?>

<!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
<div class="scroll-top page-scroll hidden-sm hidden-xs hidden-lg hidden-md">
    <a class="btn btn-primary" href="#page-top">
        <i class="fa fa-chevron-up"></i>
    </a>
</div>



<!-- Portfolio Modals -->
<div class="portfolio-modal modal fade" id="portfolioModal1" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-content">
        <div class="close-modal" data-dismiss="modal">
            <div class="lr">
                <div class="rl">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="modal-body">
                        <h2>Aprendendo a Investir</h2>
                        <hr class="star-primary">
                        <img src="<?php echo base_url("assets/img/portfolio/cabin.png") ?>" class="img-responsive img-centered" alt="Aprendendo a investir">
                        <div style="text-align: justify">
                            <p>Uma pessoa de bom senso deve simplesmente ignorar "dicas" para ficar rico da noite para o dia. Definitivamente as probabilidades estão contra você, quando se trata de ganhar uma bolada ou herdar uma fortuna.</p>
                            <p>No entanto, a boa notícia é que você pode construir um patrimônio mesmo assim. Para tanto é necessário ter um plano de investimento.</p> 
                            <p>Investimento não é jogo. Jogo é para especuladores que "apostam" todas as suas "fichas" numa única "dica" e ficam torcendo dia e noite pelo resultado de suas apostas.
                                Tudo o que você não precisa para ter sucesso em seus investimentos são apostas, fichas e dicas. Num processo de investimento não há apostas e nem fichas e dicas, mas sim objetivos e a melhor carteira (alocação de ativos) para conquistá-los. Afinal, investimento bem-sucedido é aquele que vai fazer com que você conquiste seus objetivos.</p>
                            <p>Não existe o melhor investimento, mas sim o investimento mais adequado para você atingir seus objetivos.</p>
                        </div>
                        <ul class="list-inline item-details">
                            <li>Referência:
                                <strong><a href="http://www.comoinvestir.com.br/" target="blank">Como Investir?</a>
                                </strong>
                            </li>
                            <li>Data:
                                <strong>Novembro 2016</strong>
                            </li>
                            <li>Imagem:
                                <strong><a href="http://br.freepik.com/" target="blank">Free Pik</a>
                                </strong>
                            </li>
                        </ul>
                        <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Fechar</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="portfolio-modal modal fade" id="portfolioModal2" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-content">
        <div class="close-modal" data-dismiss="modal">
            <div class="lr">
                <div class="rl">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="modal-body">
                        <h2>Organize sua Contas</h2>
                        <hr class="star-primary">
                        <img src="<?php echo base_url("assets/img/portfolio/cake.png") ?>" class="img-responsive img-centered" alt="Organize suas contas">
                        <div style="text-align: justify">
                            <p>Um orçamento mostrará qual a sua situação financeira atual, se suas despesas cabem no seu salário. Ele é a fotografia de suas despesas e receitas.</p>
                            <p>Se o que você ganha não cobre suas despesas mensais sua situação já é bastante perigosa, principalmente num país como o Brasil, onde as taxas de juro estão muito altas. Comece a fazer já o seu orçamento e convoque a família porque os cortes precisam ser feitos em conjunto.</p>
                            <p>Se seu salário cobre suas despesas, mas não há sobras, você pode ter problemas. Por isso, chame sua família para uma conversa e mostre que, sem sobras no orçamento não será possível conquistar objetivos, como a viagem, a faculdade e até mesmo a casa própria. Juntos avaliem as despesas e vejam como podem cortar um pouco de cada item.</p>
                            <p>Se você está com folga no orçamento, parabéns! Você faz parte de um seleto grupo que já consegue ter sobras no fim do mês. No entanto avalie se:</p>
                            <p>• ... você fez as contas corretamente;</p>
                            <p>• ... você não esqueceu de colocar nenhum item de despesa;</p>
                            <p>• ... o que está sobrando é suficiente para conquistar seus objetivos.</p>
                            <h3>Dez razões para ter um orçamento:</h3>
                            <ul class="list-group">
                                <li class="list-group-item">1º Você saberá qual o real alcance de sua renda.</li>
                                <li class="list-group-item">2º Evitará que você assuma dívidas que não poderá pagar.</li>
                                <li class="list-group-item">3º Você conseguirá identificar e cortar desperdícios.</li>
                                <li class="list-group-item">4º É o primeiro passo para construir um patrimônio.</li>
                                <li class="list-group-item">5º Você não precisará ficar contando os dias para chegar o fim do mês.</li>
                                <li class="list-group-item">6º Sua família enxergará para onde vai o seu salário.</li>
                                <li class="list-group-item">7º Sua família saberá quais as demandas que cabem no orçamento.</li>
                                <li class="list-group-item">8º Seu filho aprenderá com seu exemplo a ser um adulto financeiramente responsável.</li>
                                <li class="list-group-item">9º Sua produtividade no trabalho tende a aumentar sem aflições financeiras.</li>
                                <li class="list-group-item">10º Você conseguirá criar um plano de investimento para manter seu padrão de vida durante sua aposentadoria.</li>
                            </ul>
                        </div>
                        <div
                            class="fb-like"
                            data-share="true"
                            data-width="450"
                            data-show-faces="true">
                        </div>

                        <ul class="list-inline item-details">
                            <li>Referência:
                                <strong><a href="http://www.comoinvestir.com.br/" target="blank">Como Investir?</a>
                                </strong>
                            </li>
                            <li>Data:
                                <strong>Novembro 2016</strong>
                            </li>
                            <li>Imagem:
                                <strong><a href="http://br.freepik.com/" target="blank">Free Pik</a>
                                </strong>
                            </li>
                        </ul>
                        <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Fechar</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="portfolio-modal modal fade" id="portfolioModal3" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-content">
        <div class="close-modal" data-dismiss="modal">
            <div class="lr">
                <div class="rl">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="modal-body">
                        <h2>Análise de perfil</h2>
                        <hr class="star-primary">
                        <img src="<?php echo base_url("assets/img/portfolio/game.png") ?>" class="img-responsive img-centered" alt="Análise de perfil">
                        <div style="text-align: justify">
                            <p>O mercado financeiro possui uma infinidade de ativos e produtos diferentes, cada um com características bem particulares. O investidor vê-se diante de muitas opções e uma pergunta. Qual é o mais indicado para si?
                                Os bancos e corretoras criaram uma forma de ajudar o investidor a descobrir os melhores produtos para aplicar seus recursos. O procedimento foi batizado de Análise de Perfil do Investidor (API). Em geral, trata-se de um questionário onde os clientes respondem sobre sua condição financeira, idade, quantidade de recursos que disponibilizam para investir, para que pretendem utilizar o capital que estão investindo, em quanto tempo etc.
                                As respostas agrupadas mostram o seu perfil de investidor e, em alguns casos, já sugerem em quais produtos você pode alocar que fatias do seu capital. Isso dá mais segurança para o cliente, no momento de ele investir seus recursos.
                                No exterior, a API é conhecida como suitability e é bastante aplicada em países onde o mercado de investimentos é maduro.</p>
                        </div>
                        <ul class="list-inline item-details">
                            <li>Referência:
                                <strong><a href="http://www.comoinvestir.com.br/" target="blank">Como Investir?</a>
                                </strong>
                            </li>
                            <li>Data:
                                <strong>Novembro 2016</strong>
                            </li>
                            <li>Imagem:
                                <strong><a href="http://br.freepik.com/" target="blank">Free Pik</a>
                                </strong>
                            </li>
                        </ul>
                        <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Fechar</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="portfolio-modal modal fade" id="portfolioModal4" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-content">
        <div class="close-modal" data-dismiss="modal">
            <div class="lr">
                <div class="rl">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="modal-body">
                        <h2>O salário acabou?</h2>
                        <hr class="star-primary">
                        <img src="<?php echo base_url("assets/img/portfolio/circus.png") ?>" class="img-responsive img-centered" alt="O salário acabou?">
                        <div id="PrintArea">
                            <div class="conteudo" style="text-align: justify">
                                <div id="ctl00_PlaceHolderMain_Content__ControlWrapper_RichHtmlField" style="display:inline"><p>Relaxe! Você não está sozinho. Dados do IBGE dão conta de que 85% das famílias brasileiras têm algum tipo de dificuldade para chegar ao fim do mês com a renda que recebem. </p>
                                    <p>Observe que, segundo os dados do IBGE, quanto maior a renda menor a dificuldade, um resultado, a princípio, óbvio. Mas, quando analisado no detalhe, ainda assim é muito preocupante. Isso porque, mesmo famílias que estão na faixa de renda mais alta do estudo (acima de R$ 6 mil) têm pouca habilidade para manejar o orçamento. </p>
                                    <p>Veja os números: 53,45% das famílias que ganham mais de R$ 6 mil tem problemas para chegar ao fim do mês. Desse grupo, 6,66% tem muita dificuldade, 11,95% tem dificuldade e 36,74% tem alguma dificuldade. Pode-se dizer, sem medo de errar, que uma renda de R$ 6 mil não faz uma família rica, nem tampouco pobre. </p>
                                    <p>Assim, o grande problema dessas famílias não é falta de dinheiro, mas principalmente de planejamento financeiro. </p>
                                    <p>O planejamento financeiro é a melhor resposta para que esse enorme grupo de famílias que não consegue chegar ao fim do mês com o salário consiga colocar sua vida financeira em ordem, sem sofrimento, pois, o planejamento financeiro vai equilibrar suas receitas e despesas.</p>
                                    <h3>Por que isso ocorre? </h3>
                                    <p>No corre-corre diário, com horas de trabalho, filhos para educar, cursos para concluir e tantas metas para atingir, ter disciplina financeira é quase uma fantasia. Isso em qualquer lugar do mundo. No entanto, os brasileiros conviveram com taxas de inflação estratosféricas nos anos 80 e início dos anos 90. Com os preços dos bens e serviços mudando diariamente era praticamente impossível para o brasileiro manter um orçamento adequado. A taxa de inflação no País chegou a registrar alta nos preços de até 80% num único mês. Assim, a falta de organização financeira acentuou-se nas famílias brasileiras. </p>
                                    <p>A estabilidade nos preços foi alcançada com o plano Real, que teve início em junho de 1994. Hoje não só é possível como desejável ter um planejamento financeiro adequado às suas ambições e receitas. Note que, com a inflação sob controle, as taxas de juro reais (acima da inflação) estão altíssimas no Brasil e proporcionaram ganhos generosos para aqueles que mantiveram disciplina orçamentária. </p>
                                    <h3>Ganhos com taxa de juros em vinte anos*</h3>
                                    <table class="table">
                                        <tbody>
                                            <tr class="ms-rteTableHeaderRow-1">
                                                <td class="ms-rteTableHeaderOddCol-1">Uma aplicação de R$...</td>
                                                <td class="ms-rteTableHeaderEvenCol-1">Vale hoje...</td></tr>
                                            <tr class="ms-rteTableOddRow-1">
                                                <td class="ms-rteTableOddCol-1">100,00</td>
                                                <td class="ms-rteTableEvenCol-1">672,75</td></tr>
                                            <tr class="ms-rteTableEvenRow-1">
                                                <td class="ms-rteTableOddCol-1">500,00</td>
                                                <td class="ms-rteTableEvenCol-1">3.363,75</td></tr>
                                            <tr class="ms-rteTableOddRow-1">
                                                <td class="ms-rteTableOddCol-1">5.000,00</td>
                                                <td class="ms-rteTableEvenCol-1">33.639,50</td></tr>
                                            <tr class="ms-rteTableEvenRow-1">
                                                <td class="ms-rteTableOddCol-1">10.000,00</td>
                                                <td class="ms-rteTableEvenCol-1">67.275,00</td></tr></tbody></table>
                                    <p><em>*Rendimento nominal, bruto de IR; Taxa do Juro 10% ao ano</em></p>
                                </div>
                            </div>                        
                            <ul class="list-inline item-details">
                                <li>Referência:
                                    <strong><a href="http://www.comoinvestir.com.br/" target="blank">Como Investir?</a>
                                    </strong>
                                </li>
                                <li>Data:
                                    <strong>Novembro 2016</strong>
                                </li>
                                <li>Imagem:
                                    <strong><a href="http://br.freepik.com/" target="blank">Free Pik</a>
                                    </strong>
                                </li>
                            </ul>
                            <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Fechar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>    
<div class="portfolio-modal modal fade" id="portfolioModal5" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-content">
        <div class="close-modal" data-dismiss="modal">
            <div class="lr">
                <div class="rl">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="modal-body">
                        <h2>Minhas dívidas</h2>
                        <hr class="star-primary">
                        <img src="<?php echo base_url("assets/img/portfolio/safe1.png") ?>" class="img-responsive img-centered" alt="Minhas Dívidas"/>
                        <div class="conteudo" style="text-align: justify">
                            <p>Se você parou nesta área é porque deve estar com algum problema financeiro. Algo assim como uma fatura impagável no cartão de crédito, um limite estourado no cheque especial e o medo de encontrar na rua o gerente do banco. Ou seja, você se endividou um tanto além da conta. Mas o pior é que, desesperado, pode estar prestes a contrair novas dívidas para pagar as já vencidas. </p>
                            <p>Pare já. Dívidas impossíveis de pagar não se resolvem com novas. Só se pode sair delas com uma cuidadosa estratégia para pagar cada uma delas. </p>
                            <p>Aperte o orçamento, sente-se com seus credores e comece a elaborar uma estratégia para finalizar uma a uma. </p>
                            <h3>Por que as pessoas têm problemas com dívidas?</h3>
                            <p>• Porque enfrentam problemas inesperados causados por doença, divócio ou desemprego; </p>
                            <p>• Porque não têm controle de seus orçamentos e não se planejam para o futuro; </p>
                            <p>• Porque não têm noções de planejamento financeiro e acabam fazendo operações de crédito que comprometem mais de 30% do orçamento. </p>
                            <h3>Curiosidade</h3>
                            <p><strong>Você sabia que </strong>nos EUA, mais de 1,4 milhão de indivíduos pediram falência em 2001, um aumento significativo se comparado ao número de falências pessoais 20 anos antes, que era de 316 mil? </p>
                            <h3>Quanto devo? </h3>
                            <p>Para começar, faça uma lista de todas as suas dívidas. Ao terminar, é possível que o coração palpite e a mão trema. Mas pode apostar você deu o primeiro passo para resolver seus problemas. </p>
                            <p>O pior para quem está endividado é não conhecer a dimensão real do problema. Você sabe que ele existe porque os credores estão pressionando, mas às vezes sua angústia é exagerada. É por isso que vale a pena fazer uma relação de todos esses números. </p>
                            <p>Dívidas que ficam apenas nos nossos pensamentos nos deixam deprimidos, atrapalham a concentração no trabalho e trazem conflitos à vida em família. No entanto, quando se começa a lidar com o problema de frente, de uma forma realista, esteja certo de que se sentirá mais animado, porque, seja qual for a sua situação, você começou a trilhar o caminho para resolvê-la. </p>
                            <h3>Como se livrar das dívidas </h3>
                            <p>Depois de listar todas as dívidas, coloque-as em ordem decrescente, da mais cara para a mais barata. As mais caras são as que você deve atacar primeiro, e não o contrário. </p>
                            <p>Outra providência importante é fazer um orçamento. De novo, faça uma lista. Coloque seu salário e outras fontes de renda que tiver, no lado esquerdo, e todas as suas despesas mensais no lado direito. Esqueça suas dívidas nesse momento. Deixe de fora até as prestações que você assumiu. Agora, subtraindo o total das despesas do total das receitas, veja quanto sobrou. Esse é o dinheiro que você tem para pagar todo mês suas dívidas. </p>
                            <p>O ideal é que você reserve de 20% a, no máximo, 30% de sua renda mensal para o pagamento de dívidas. Mais que isso é candidatar-se a ter problemas no futuro, porque você não conseguirá manter por muito tempo a disciplina dos pagamentos mensais. </p>
                            <p>Não se preocupe com o tempo que vai levar para quitar suas dívidas. O fundamental é interromper o processo de endividamento e começar a liquida-las, para viver melhor. </p>
                            <p>Se você tem um bem, poderá vender. Um carro, por exemplo. Além da economia com seguro e taxas como IPVA, você pode abater uma parte de sua dívida. </p>
                            <h3>Quanto custa cada dívida </h3>
                            <p>O custo de uma dívida é a taxa de juro que você paga. Mas, se você já está inadimplente, acrescente nesse custo as multas pelo atraso. Quanto antes você conversar com seu credor, melhor. Ao negociar uma forma de pagamento você interrompe o acúmulo de juros e multas que acabam virando uma bola de neve. </p>
                            <p>O cheque especial costuma ser a dívida mais cara. Um jeito fácil de liquidar esse problema é fazer uma troca. Peça para cancelar o seu cheque especial e transforme a dívida num empréstimo pessoal com parcelas mensais fixas. Você vai ver que sai bem mais em conta. Mas não deixe de cancelar o cheque especial, porque, do contrário, estará apenas contraindo mais uma dívida. </p>
                            <h3>A quem recorrer </h3>
                            <p>Converse com o gerente de seu banco. Ele poderá ajudá-lo nesse processo. Poderá, por exemplo, encontrar alternativas de crédito mais barato para que você troque as dívidas caras por dívidas mais baratas. </p>
                            <p>É importante ter uma planilha organizada, com todos os custos devidamente calculados e projeções de pagamento. Seu gerente pode lhe ajudar nesta tarefa. </p>
                            <p>Para escapar das dívidas, é necessário ter informação (como as que você vai obter aqui), paciência (se não tem, trate de desenvolver esse atributo) e disciplina (vale a mesma recomendação do item anterior). </p>
                            <h3>Família: solução ou problema? </h3>
                            <p>Deixe seus parentes e amigos longe de suas dívidas. Pedir dinheiro emprestado a parentes é um erro comum que, em geral, além de não resolver o problema ainda cria mais um, o das brigas familiares. </p>
                            <p>Você deve, contudo, buscar apoio em seus filhos e mulher (ou marido). Este é um problema de todos. Reúna a família e exponha a real situação. Definam juntos quais os gastos cortar.</p>
                            <p><strong>Considere:</strong></p>
                            <p>• Saldar dívidas pode significar perda de capital e quem quer sair do vermelho deve estar preparado para isso. Enxugar contas e vender bens pode fazer parte do processo. </p>
                            <p>• Defina os gastos prioritários. Corte os gastos supérfluos e que não acrescentam nada aos seus objetivos de equilíbrio financeiro. </p>
                            <p>• Assim que perceber que terá problemas para continuar pagando uma dívida, procure imediata e diretamente o credor, informando sua situação. Essa medida evitará que sua dívida cresça muito. </p>
                            <p>• Mesmo endividado, você deve traçar metas: assim que liquidar uma dívida, comece a poupar para um determinado objetivo. </p>
                            <p>• Abra mão de uma coisa que deseje muito hoje, com o objetivo de equilibrar suas finanças e poder adquirir aquilo que quer no futuro.</p>
                        </div>                            
                        <ul class="list-inline item-details">
                            <li>Referência:
                                <strong><a href="http://www.comoinvestir.com.br/" target="blank">Como Investir?</a>
                                </strong>
                            </li>
                            <li>Data:
                                <strong>Novembro 2016</strong>
                            </li>
                            <li>Imagem:
                                <strong><a href="http://br.freepik.com/" target="blank">Free Pik</a>
                                </strong>
                            </li>
                        </ul>
                        <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Fechar</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="portfolio-modal modal fade" id="portfolioModal6" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-content">
        <div class="close-modal" data-dismiss="modal">
            <div class="lr">
                <div class="rl">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="modal-body">
                        <h2>Como escolher</h2>
                        <hr class="star-primary">
                        <img src="<?php echo base_url("assets/img/portfolio/submarine.png") ?>" class="img-responsive img-centered" alt="Investimento">
                        <div class="conteudo" style="text-align: justify">
                            <p>Sua principal preocupação hoje é acumular patrimônio? Ou seu objetivo atual é proteger o patrimônio que você já acumulou? É importante entender que não existe a melhor opção, e sim a mais adequada a suas necessidades e expectativas. </p>
                            <p>Há várias formas de você investir seu dinheiro: comprar um imóvel, aplicar em títulos de renda fixa ou em ações são alguns exemplos. Um aspecto importante é definir qual a meta de rentabilidade para a aplicação. </p>
                            <p>Se sua meta é acumular patrimônio você terá, necessariamente, de buscar aplicações mais arrojadas. Esses investimentos têm maior potencial de ganho ao longo do tempo, e consequentemente um maior grau de risco.</p>
                            <p>Mas, se você quer apenas proteger seu patrimônio, opte por aplicações mais conservadoras, mas com uma taxa de retorno acima da inflação. </p>
                            <p>Ao escolher um investimento arrojado é importante que sua decisão seja baseada em seus objetivos e tempo de aplicação, e sua tolerância ao risco de perda.</p>
                        </div>
                    </div>                            
                    <ul class="list-inline item-details">
                        <li>Referência:
                            <strong><a href="http://www.comoinvestir.com.br/" target="blank">Como Investir?</a>
                            </strong>
                        </li>
                        <li>Data:
                            <strong>Novembro 2016</strong>
                        </li>
                        <li>Imagem:
                            <strong><a href="http://br.freepik.com/" target="blank">Free Pik</a>
                            </strong>
                        </li>
                    </ul>
                    <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Fechar</button>
                </div>
            </div>
        </div>
    </div>
</div>


