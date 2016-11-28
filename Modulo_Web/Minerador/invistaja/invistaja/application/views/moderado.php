<?php defined('BASEPATH') OR exit('No direct script access allowed'); ?>
<?php $this->load->view('head'); ?>
<script  type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<style>
    .formulario{
        display:none;
    }
</style>

<header>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <img class="img-responsive" src="<?php echo base_url("assets/img/simulacao.png") ?>" alt="">
                <div class="intro-text">
                    <span class="name">Faça uma simulação</span>
                    <hr class="star-light">
                    <span class="skills">com algumas opções compatíveis com seu perfil</span>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- Contact Section -->
<section id="#">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2>Simule</h2>
                <hr class="star-primary">
            </div>
        </div>
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <div novalidate>
				<p>*Por ser investimentos de renda variável, não é possivel mensurar um valor exato de rendimento.</p>
                    <select required data-validation-required-message="Escolha uma opçao" class="selectpicker form-control input-lg" data-style="btn-success" name="selecao" id="selecao">
                        <option value=""> Suas melhores opções...</option>
                        <option value="1">Ações</option> 
                        <option value="2">Fundos Imobiliários</option>
                        <option value="3">Fundos Multi Mercado</option>
                        <option value="4">Renda Fixa</option>
                    </select>
                    <br>
                    <p class="help-block text-danger"></p>
                    <div class="row control-group">
                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <label>Investir</label>
                            <input required data-validation-required-message="Digite um valor" placeholder="Quanto você deseja investir?" class="form-control" id="inv" type="number"/>
                        </div>
                    </div>
                    <p class="help-block text-danger"></p>
                    <div class="row control-group">
                        <div class="form-group col-xs-12 floating-label-form-group controls">        
                            <label>Tempo</label>
                            <input class="form-control" id="tempo" type="number" value="" required data-validation-required-message="Digite o tempo que deseja investir" placeholder="Por quantos anos deseja deixar seu dinheiro investido?"/>
                        </div>
                    </div>
                    <p class="help-block text-danger"></p>
                </div>
                <br>
                <input class="btn btn-success btn-lg" id="calcular" type="button" value="Calcular" onclick="opcao()"/>
                <br>
                <br>
                <br>
                <div class="row control-group">
                    <div class="form-group col-xs-12 floating-label-form-group controls">
                        <input class="form-control" placeholder="Quanto você teria ao final do rendimento:" id="total" type="number" readonly="readonly"/>
                    </div>
                </div>
            </div>
        </div>    
        <div class="col-lg-10 col-lg-offset-1">
            <div class="formulario" id="2">
                <div class="row investe" >
                    <div class="col-lg-12">
                    <h1 class="entry-title">Fundos Imobiliários: O que são? Por que investir? Como investir?</h1>
					<p>Os seus benefícios são diversos, mas vou resumi-los em apenas 5 para facilitar sua compreensão.</p>
					<p>Mais abaixo, listarei um guia para você iniciar seus <a href="http://hcinvestimentos.com/">investimentos</a> nos fundos imobiliários de modo tranquilo e inteligente.</p>
					<h2><strong>Fundos Imobiliários: 5 Grandes Benefícios</strong></h2>
					<h4><strong>1. Praticidade</strong></h4>
					<p>Se você já investiu diretamente em imóveis ou já precisou comprar ou vender um imóvel sabe o tempo que demora até o negócio ser efetivado, a burocracia das&nbsp; papeladas, o tempo gasto com todo o processo…</p>
					<p>Entretanto, o investimento em fundo imobiliário está a apenas um clique de distância.</p>
					<p>Basta casar sua ordem de compra com uma de venda na Bovespa através do Home-broker de sua corretora e pronto.</p>
					<p>Simples e rápido como o investimento em uma ação.</p>
					<h4><strong>2. Fracionamento</strong></h4>
					<p>Imóveis geralmente custam caro. Um apartamento de 4 quartos dificilmente é encontrado à venda por menos de R$ 300.000.</p>
					<p>Porém, ao investir nesses fundos, você pode, com pouco menos de R$ 1.000 fazer um investimento em vários imóveis.</p>
					<h4><strong>3. Atividades e inquilinos de primeira linha</strong></h4>
					<p>Ao invés de alugar o seu único imóvel que investiou para um inquilino desconhecido e duvidoso, por que não alugar para empresas como Petrobrás, Banco do Brasil, Caixa Econômica Federal, entre outras grandes corporações?</p>
					<p>Os locatários dos imóveis dentro de um fundo imobiliário geralmente são grandes empresas com nome conhecido no mercado.</p>
					<p>Tenho certeza de que a probabilidade de pagarem o aluguel em dia é muito maior do que para um indivíduo desconhecido, concorda?</p>
					<h4><strong>4. Excelentes geradores de renda</strong></h4>
					<p>Na minha opinião, a alta geração de renda é a maior vantagem dos fundos imobiliários. Raros são os investimentos que pagam rendimentos mensalmente.</p>
					<p>E sem incidência do imposto de renda. Esses fundos possuem estes dois benefícios de modo prático e simples.</p>
					<p>Todo mês os administradores dos fundos recebem os aluguéis dos inquilinos e repassam uma boa parte (95% no mínimo) para os cotistas do fundo, “caindo” diretamente na conta de sua corretora.</p>
					<p>Alguns fundos imobiliários chegam a pagar 1% por mês somente em rendimentos. Ou seja, se você investiu R$ 100 receberá mensalmente R$ 1.</p>
					<p>A média, entretanto, costuma se situar em torno dos 0,70%. E só para lembrar: sem imposto de renda!</p>
					<h4><strong>5. Rentabilidade</strong></h4>
					<p>Sim, rentabilidade passada não é garantia de rentabilidade futura.</p>
					<p>Entretanto, os fundos imobiliários apresentam, no mínimo, uma ótima oportunidade para o investidor diversificar sua carteira e perseguir uma melhor rentabilidade do que o investimento em títulos públicos, por exemplo.</p>
					<p>Se traçarmos um comparativo de rentabilidade dos investimentos desde janeiro de 2008 (período em que os fundos imobiliários começaram a ganhar certa notoriedade) até o final de 2011 percebemos que eles desbancam qualquer outro investimento.</p>
					<p>Seja ações, títulos públicos, Dólar ou Ouro, a rentabilidade apresentada foi bem superior a todos eles.</p>
					<h2><strong>Fundos Imobiliários – O guia definitivo</strong></h2>
					<p>Elaborei este guia abaixo para que você possa saber todos os detalhes sobre este tipo de investimento.</p>
					<p>Perceba por si próprio os seus benefícios, mesmo que seja uma pequena parcela de sua carteira de investimentos.</p>
					<h3><strong>Dados Gerais dos Fundos Imobiliários</strong></h3>
					<p><strong>1.&nbsp;<strong><a href="http://hcinvestimentos.com/2012/04/17/como-investir-em-fundos-imobiliarios/" rel="bookmark">Como Investir em Fundos Imobiliários</a>&nbsp;</strong></strong></p>
					<p><strong>2.&nbsp;<strong><a href="http://hcinvestimentos.com/2012/09/10/ifix-indice-fundo-imobiliario/" rel="bookmark">IFIX: Tudo o que você precisa saber sobre o novo Índice de Fundos Imobiliários</a>&nbsp;</strong></strong></p>
					<p><strong>3.&nbsp;<a href="http://hcinvestimentos.com/2010/12/02/fundos-imobiliarios-todas-as-informacoes-em-1-so-lugar/">Fundos Imobiliários – Todas as Informações em um só lugar</a></strong></p>
					<p><strong>4.&nbsp;<strong><a href="http://hcinvestimentos.com/2011/05/02/5-graficos-que-te-ajudarao-a-investir-em-fundos-imobiliarios/">5 gráficos que te ajudarão a investir em fundos imobiliários</a></strong></strong></p>
					<p><strong>5.&nbsp;<strong><a href="http://hcinvestimentos.com/2010/05/25/diversificacao-nos-fundos-de-investimento-imobiliario/">Diversificação nos Fundos Imobiliários</a></strong></strong></p>
					<p><strong>6.&nbsp;<strong><a href="http://hcinvestimentos.com/2011/05/18/como-calcular-o-preco-justo-dos-fundos-imobiliarios/">Como Calcular o Preço Justo dos Fundos Imobiliários</a></strong></strong></p>
					<p><strong>7.&nbsp;<strong><a href="http://hcinvestimentos.com/2011/02/14/igmi-c-indice-geral-do-mercado-imobiliario-%E2%80%93-comercial/">IGMI-C: Índice Geral do Mercado Imobiliário – Comercial</a></strong></strong></p>
					<h3><strong>Introdução – Conceitos Básicos sobre Fundos Imobiliários</strong></h3>
					<p><strong>1. <a href="http://hcinvestimentos.com/2009/11/01/investindo-em-fundos-de-investimentos-imobiliarios-fii-parte-i/">Investindo em Fundos Imobiliários (Parte I)</a></strong></p>
					<p><strong>2. <a href="http://hcinvestimentos.com/2009/11/19/investindo-em-fundos-de-investimentos-imobiliarios-fii-parte-ii/">Investindo em Fundos Imobiliários (Parte II)</a></strong></p>
					<p><strong>3. <a href="http://hcinvestimentos.com/2009/11/22/investindo-em-fundos-de-investimentos-imobiliarios-fii-parte-iii/">Investindo em Fundos Imobiliários (Parte III) – Correlação com diversos investimentos</a></strong></p>
					<p><strong>4. <a href="http://hcinvestimentos.com/2009/11/27/investindo-em-fundos-de-investimentos-imobiliarios-fii-parte-iv/">Investindo em Fundos Imobiliários (Parte IV) – Correlação com diversos investimentos e Análise dos REITs</a></strong></p>
					<p><strong>5. <a href="http://hcinvestimentos.com/2009/12/05/investindo-em-fundos-de-investimentos-imobiliarios-fii-parte-v/">Investindo em Fundos Imobiliários (Parte V) – Tudo o que você precisa saber sobre os rendimentos mensais</a></strong></p>
					<p><strong>6. <a href="http://hcinvestimentos.com/2009/12/18/investindo-em-fundos-de-investimentos-imobiliarios-fii-parte-vi/">Investindo em Fundos Imobiliários (Parte VI) – Métodos de Precificação</a></strong></p>
					<p><strong>7. <a href="http://hcinvestimentos.com/2010/01/04/investindo-em-fundos-de-investimentos-imobiliarios-fii-parte-vii/">Investindo em Fundos Imobiliários (Parte VII) – Preço Justo dos Fundos Imobiliários</a></strong></p>
					<p><strong><br>
					</strong></p>
					<h3><strong>Rentabilidades dos Fundos Imobiliários</strong></h3>
					<p><strong>1. <a href="http://hcinvestimentos.com/2010/01/11/fundos-de-investimento-imobiliario-dados-e-rentabilidades-em-2009/">Fundos Imobiliários: Dados e Rentabilidades em 2009</a></strong></p>
					<p><strong>2. <a href="http://hcinvestimentos.com/2010/07/11/rentabilidade-dos-fundos-de-investimentos-imobiliarios-no-1%c2%ba-semestre-de-2010/">Fundos Imobiliários: Dados e Rentabilidades no primeiro semestre de 2010</a></strong></p>
					<p><strong>3. <a href="http://hcinvestimentos.com/2010/07/18/como-calcular-a-rentabilidade-dos-fundos-imobiliarios-guia-pratico/">Como Calcular a Rentabilidade dos Fundos Imobiliários – Guia Prático</a></strong></p>
					<p><strong><br>
					</strong></p>
					<h3><strong>Análise Detalhadas de Fundos Imobiliários Individuais</strong></h3>
					<p><strong>1. <a href="http://hcinvestimentos.com/2011/04/04/vale-a-pena-investir-no-bc-fundo-de-fundos-imobiliario-bcff11b/">Vale a pena investir no BC Fundo de Fundos Imobiliários (BCFF11B)?</a></strong></p>
					<p><strong>2. <a href="http://hcinvestimentos.com/2011/04/11/vale-a-pena-investir-no-fundo-imobiliario-excellence-fexc11b/">Vale a pena investir no Fundo Imobiliário Excellence (FEXC11B)?</a></strong></p>
					<p><strong>3.&nbsp;<a href="http://hcinvestimentos.com/2009/06/07/euro11-fundo-imobiliario-europar/">Fundo Imobiliário Europar (EURO11)</a></strong></p>
					<br><br><center class="list-inline item-details">
						<li>Referência:
							<strong><a href="http://hcinvestimentos.com/fundos-imobiliarios/?hvid=6IqPXW" target="blank">HC Investimentos</a>
							</strong>
						</li>
						<li>Data:
							<strong>Novembro 2016</strong>
						</li>
					</center>
					</div>  
                </div>
            </div>
            <div class="formulario" id="1">
                <div class="row investe" >
                    <div class="col-lg-12">
                        <h1>Ações</h1>
						<p>Uma ação representa a menor parcela em que se divide o capital de uma empresa organizada em forma de sociedade anônima (S.A.). </p>
						<p>Ao abrir uma S.A., os fundadores aportam os recursos, financeiros ou não, que formarão o seu capital social. Com esses recursos, eles compram máquinas e equipamentos, pagam empregados... Enfim, fazem a empresa funcionar.</p>
						<p>Para ter suas ações negociadas em mercados organizados, como as bolsas de valores, a empresa precisa se registrar como companhia aberta na Comissão de Valores Mobiliários (CVM). </p>
						<p>Como são negociadas diariamente, as ações podem apresentar oscilações de preço. Quando há uma grande procura por ações, a tendência é de alta no seu valor. Já quando ocorre o movimento inverso e muitos investidores vendem suas ações, o preço cai. É a chamada lei da oferta e da procura.</p>
						<p>O investidor em ações é sócio da empresa. Como sócio, tem direito a participar dos lucros da empresa e poderá ganhar dinheiro com os dividendos distribuídos, além da valorização do preço de suas ações. Mas se a empresa tiver dificuldades financeiras, por causa de dificuldades do setor em que atua ou problemas administrativos, a expectativa é de que seu lucro diminua – e isso resulta na queda do preço da ação.</p>
						<p>As ações de uma empresa S.A. podem ser negociadas a qualquer tempo em bolsas de valores ou no mercado de balcão. O acionista pode vendê-las, obtendo de volta o dinheiro correspondente ao valor de sua cotação.</p>
						<h1>Onde obter informações</h1>
						<p>Atualmente, encontrar informações sobre ações já não é mais um problema.</p>
						<p>O mercado está cada vez mais transparente. Hoje é possível se informar sobre cada detalhe de seus investimentos de maneira muito simples. Cotações, maiores altas, maiores baixas, análise de empresa, projeções, análise gráficas e fundamentalistas e análises de riscos são alguns dos dados que podem ser obtidas nas instituições financeiras e na própria bolsa de valores.</p>
						<p>Há muitos sites de informação sobre o mercado de ações que podem servir de apoio ao investidor. No site da BM&FBovespa (www.bmfbovespa.com.br), por exemplo, é possível encontrar as cotações diariamente, tanto do Ibovespa como das ações negociadas no dia. No site da CVM (www.cvm.gov.br) é possível acompanhar todos os processos em andamento na autarquia, além de consultar os fatos relevantes – como são chamados os documentos publicados pelas empresas de capital aberto toda vez que uma informação importante sobre os negócios da companhia possa afetar positiva ou negativamente seu desempenho no mercado (e, consequentemente, o valor de suas ações). </p>
						<p>Há especialistas que vendem serviços de análises de empresas, de mercado, de setores e acompanhamento de papéis específicos. Matérias jornalísticas também são boas fontes de informação sobre empresas e setores.</p>
						<br><br><center class="list-inline item-details">
						<li>Referência:
							<strong><a href="http://www.comoinvestir.com.br/" target="blank">Como Investir?</a>
							</strong>
						</li>
						<li>Data:
							<strong>Novembro 2016</strong>
						</li>
					</center>
					</div>
                </div>
            </div>
            <div class="formulario" id="3">
                <div class="row investe" >
                    <div class="col-lg-12">
                        <div class="entry-inner">
							<p style="text-align: center;"><img class="aligncenter size-full wp-image-828" alt="fundos-multimercado" src="http://ynvestimentos.com.br/wp-content/uploads/2013/11/fundos-multimercado.png" width="310" height="147"></p>
							<h1><strong>1. O que é?</strong></h1>
							<p style="text-align: justify;">Fundos multimercado são fundos que podem alocar seus recursos em diversas modalidades de investimentos, dando assim mais liberdade aos gestores dos fundos para diversificar a carteira. Esses Fundos podem investir em DI, Selic, índices, taxa de juros, moedas, ações, etc, inclusive é possível investir até 20% do patrimônio em ativos financeiros no exterior.</p>
							<p style="text-align: justify;">Os fundos multimercados deverão possuir políticas de investimentos que envolvam vários fatores de risco, sem ter um foco de concentração em qualquer modalidade de investimento. Isso significa que esses fundos poderão montar uma posição alta da carteira total do fundo em ações em um determinado período, por exemplo, e se desfazer totalmente dela depois de algum tempo. Por causa disso, esses fundos são considerados de alto risco. A busca pelo retorno se dá no longo prazo, através de deslocamentos estratégicos entre diversos tipos de investimentos. Vale ressaltar que esses fundos podem fazer uso de derivativos tanto para fazer hedge quanto para fazer alavancagem, e podem cobrar taxa de performance.</p>
							<p style="text-align: justify;">O grande diferencial dos fundos multimercados é a sua flexibilidade, podendo diversificar a alocação dos recursos em diversas modalidades de investimentos disponíveis. Com isso, existem diversos estilos e estratégias que o fundo pode adotar. As principais são:</p>
							<h2 style="text-align: justify;"><strong>Trading</strong></h2>
							<p style="text-align: justify;">Os fundos multimercado que adotam essa estratégia tem como objetivo comprar e vender ativos nos momentos certos. Esses fundos adotam posições mais curtas e mais líquidas, explorando oportunidades de ganhos originados por movimentos de curto prazo nos preços dos ativos. Eles conseguem também mudar a estratégia mais facilmente, se protegendo contra a volatilidade do mercado.</p>
							<h2 style="text-align: justify;"><strong>Macro</strong></h2>
							<p style="text-align: justify;">Buscam antecipar as tendências macroeconômicas que irão determinar os preços futuros dos ativos, se utilizando de fundamentos da economia e precificação de ativos (com base em fatores macroeconômicos) para montarem essa estratégia, antecipando-se dessa forma ao mercado. Suas posições são direcionais e de longo prazo.</p>
							<h2 style="text-align: justify;"><strong>Long &amp; Short – Neutro</strong></h2>
							<p style="text-align: justify;">Também conhecida como Equity Hedge, a estratégia de Long &amp; Short – Neutro fazem operações com ativos e derivativos ligados ao mercado de renda variável, montando posições compradas e vendidas em determinados ativos, com o objetivo de manterem a exposição neutra ao risco do mercado acionário. Em outras palavras, esses fundos compram no mercado à vista de ações uma carteira com potencial de alta, e vendem simultaneamente uma carteira do Ibovespa no mercado futuro, neutralizando assim o risco da variação da Bovespa.</p>
							<h2 style="text-align: justify;"><strong>Long e Short – Direcional</strong></h2>
							<p style="text-align: justify;">Esse tipo de estratégia monta posições Long &amp; Short, isto é, posições compradas e vendidas no mercado acionário, onde seu resultado deverá vir da diferença entre essas posições. Por exemplo, um fundo que adota essa estratégia pode comprar ações de empresas subvalorizadas de um determinado setor e, simultaneamente, vender as ações de empresas sobrevalorizadas deste mesmo setor. A tendência é que as ações subvalorizadas subam de preço, e as ações sobrevalorizadas caiam de preço. Se o gestor acertar essa estratégia, o ganho será em dobro (ganho na subida das ações compradas e ganho na descida das ações vendidas).</p>
							<h2 style="text-align: justify;"><strong>Multiestratégia</strong></h2>
							<p style="text-align: justify;">Como o próprio nome já diz, o objetivo dos fundos multimercados multiestratégia é adotar diversas estratégias, sem o compromisso de adotar uma estratégia em particular. Suas prioridades são analisar o risco e retorno como um todo, tanto no ambiente macroeconômico quando na analise dos ativos, sendo muitas vezes comum o uso de derivativos para alavancagem.</p>
							<h2 style="text-align: justify;"><strong>Multigestor</strong></h2>
							<p style="text-align: justify;">O objetivo dessa estratégia é investir em mais de um fundo, gerido por gestores diferentes. Os gestores selecionados devem ter um histórico de competência, a fim de trazer mais rentabilidade para o fundo. Esses gestores são criteriosamente selecionados, consolidando a força desses gestores dentro de uma carteira única. Os recursos são alocados em cotas de fundos de gestores independentes, com diferentes estratégias de gestão e atuação, proporcionando assim a melhor relação de risco e retorno.</p>
							<h2 style="text-align: justify;"><strong>Juros e moeda</strong></h2>
							<p style="text-align: justify;">Como o próprio nome já diz, os fundos que adotam essa estratégia investem em ativos de renda fixa atrelados ao risco de juros, índice de preços e moeda estrangeira. Seu foco de prazo se dá no longo prazo, e geralmente não investem em ações.</p>
							<h2 style="text-align: justify;"><strong>Estratégia específica</strong></h2>
							<p style="text-align: justify;">Adotam como estratégia riscos específicos, como commodities, índices, moedas, etc.</p>
							<h2 style="text-align: justify;"><strong>Balanceados</strong></h2>
							<p style="text-align: justify;">Nessa estratégia, os fundos buscam investimentos diversificados e deslocamentos táticos entre diversos ativos, com uma estratégia explícita de rebalanceamente do curto prazo. Além disso, esses fundos devem deixar explícito o mix de ativos com o qual devem ser comparados, devendo ser determinado o percentual a ser aplicado em cada classe de ativo.</p>
							<h2 style="text-align: justify;"><strong>Capital Protegido</strong></h2>
							<p style="text-align: justify;">Essa estratégia busca retornos em mercados de risco, sempre buscando proteção (hedge) total ou parcial do principal investido. Os fundos investem em diversos ativos, tendo uma estratégia direcional ou não, porém, o mais importante, é fazendo operações onde o capital principal dos investidores fique protegido.</p>
							<hr>
							<h1><strong>2. Tributação</strong></h1>
							<p style="text-align: justify;">A tributação nos fundos multimercados pode variar de acordo com a política composta no regulamento ou prospecto do Fundo.</p>
							<p style="text-align: justify;">Os fundos que forem classificados como longo prazo deverão incluir obrigatoriamente a expressão “longo prazo” no nome do fundo e atender as condições previstas na regulamentação. Fundos de longo prazo são aqueles que mantém uma carteira média com prazo superior a 365 dias. Para esses fundos, a tributação ocorre da mesma forma que os fundos de renda fixa, isto é, decrescente em função do prazo da aplicação</p>
							<ul style="text-align: justify;">
							<li>Aplicações de até 180 dias: 22,5% (somente sobre os rendimentos)</li>
							</ul>
							<ul style="text-align: justify;">
							<li>Aplicações de 181 a 360 dias: 20% (somente sobre os rendimentos)</li>
							</ul>
							<ul style="text-align: justify;">
							<li>Aplicações de 361 a 720 dias: 17,5% (somente sobre os rendimentos)</li>
							</ul>
							<ul style="text-align: justify;">
							<li>Aplicações acima de 720 dias: 15% (somente sobre os rendimentos)</li>
							</ul>
							<p style="text-align: justify;">Nessa classificação de fundos multimercados, há a incidência do come-cotas, a uma alíquota de 15%, cobrados a cada 6 meses (maio e novembro).</p>
							<p style="text-align: justify;">Já os fundos multimercados classificados como “curto prazo” (e assim descrito no nome do fundo), são aqueles que mantém uma carteira com prazo médio igual ou inferior a 365 dias. Neste caso, o imposto será cobrado da seguinte maneira:</p>
							<ul style="text-align: justify;">
							<li>Aplicações de até 180 dias: 22,5% (somente sobre os rendimentos)</li>
							</ul>
							<ul style="text-align: justify;">
							<li>Aplicações de 181 a 360 dias: 20% (somente sobre os rendimentos)</li>
							</ul>
							<p style="text-align: justify;">Nessa classificação, há a incidência de come-cotas, a uma alíquota de 20%</p>
							<p style="text-align: justify;">Os fundos multimercados que tiverem como política a aplicação de no mínimo 67% em ações, serão tributados como se fosse fundos de ações, isto é, serão tributados a uma alíquota de 15%, independente do prazo de aplicação. Não há incidência de come-cotas nessa classificação de Fundo.</p>
							<hr>
							<h1><strong>3. Vantagens</strong></h1>
							<ul>
							<li style="text-align: justify;">Gestão profissional. Alguns fundos multimercados são geridos por gestores profissionais altamente qualificados, dando assim mais chances do fundo ter rendimentos mais altos do que outros fundos, lembrando sempre que nunca há a garantia de rentabilidade;</li>
							<li style="text-align: justify;">Diversificação – Uma das maiores vantagens dos fundos multimercados, pois é possível investir em diversos ativos disponíveis no mercado;</li>
							<li style="text-align: justify;">Alguns fundos multimercado usam derivativos como hedge (proteção), inclusive do capital principal investido.</li>
							<li style="text-align: justify;">Alguns fundos multimercado possuem estratégias que podem estar de acordo com as políticas de alguns investidores, no caso, os fundos com estratégia específica.</li>
							</ul>
							<hr>
							<h1><strong>4. Desvantagens</strong></h1>
							<ul>
							<li style="text-align: justify;">Os fundos de investimentos multimercados não são garantidos pelo fundo garantidor de crédito;</li>
							<li style="text-align: justify;">Taxas de administração altas podem afetar a rentabilidade do fundo;</li>
							<li style="text-align: justify;">Alto risco, pois como alguns fundos multimercados investem em ativos de risco, existe a possibilidade de perder todo o dinheiro investido, principalmente se utilizarem derivativos como alavancagem;</li>
							<li style="text-align: justify;">Imposto de renda mesmo se o resgate for menor do que R$ 20 mil reais (se for investido diretamente em ações, uma venda menor do que R$ 20 mil reais não há incidência do imposto de renda).</li>
							</ul>
							<br><br><center class="list-inline item-details">
						<li>Referência:
							<strong><a href="http://ynvestimentos.com.br/" target="blank"> Ynvestimentos</a>
							</strong>
						</li>
						<li>Data:
							<strong>Novembro 2016</strong>
						</li>
					</center>
						</div>
                    </div>
                </div>
            </div>
            <div class="formulario" id="4">
                <div class="row investe" >
                    <div class="col-lg-12">
                        <h1>O que é?</h1>
						<p>Renda Fixa é o tipo de investimento que possui uma remuneração ou um retorno de capital investido dimensionado no momento da aplicação.</p>
						<p>Em outras palavras, o investidor sabe, desde o momento da compra de determinado ativo financeiro, quanto vai receber ao final do prazo, seja em valor nominal (prefixado) ou pela variação de um índice (pós-fixado).</p>
						<p>A principal diferença de aplicações em renda fixa para renda variável é que este não garante uma rentabilidade ou ganho de capital, podendo até perder dinheiro.</p>
						<p>É o caso, por exemplo, da compra de ações. Se eu decidir comprar ações da Petrobras por R$ 25,00, não há nenhuma garantia que no dia seguinte essas ações valeriam R$ 26,00 ou qualquer outro valor. Por isso que essa é uma aplicação de risco.</p>
						<p>Na renda fixa, a regra de rentabilidade é sempre definida no momento do investimento. Uma das principais características dos títulos prefixados é que o investidor sabe exatamente a rentabilidade que irá receber se mantiver o título até a data de vencimento. São mais indicados em momento de queda da taxa de juros.</p>
						<p>Já os títulos pós-fixados têm sua rentabilidade relacionada a um indexador que varia ao longo do tempo. Assim, a rentabilidade da aplicação é composta pela variação de um indexador (IPCA ou Selic) e mais uma taxa de juros prefixada.</p>
						<p>Essa característica de ter um indexador que varia conforme a variação da inflação (IPCA) ou da taxa de juros básica da economia (Selic) diminui o risco desses títulos, visto que o investidor fica protegido da inflação ou da variação da taxa de juros.</p>
						<p>No site do Tesouro Direto há um questionário para ajudar o investidor a escolher qual é o título mais adequado aos seus objetivos (link: http://zip.net/byrRxZ).</p>
						<h1>Taxas</h1>
						<p>As operações com títulos públicos estão sujeitas ao pagamento de taxas. Verifique isso antes de escolher sua aplicação.</p>
						<p>As taxas cobradas no Tesouro Direto são diferentes das taxas cobradas pelos fundos. As taxas cobradas no Tesouro Direto são:</p>
						<p>Taxa de custódia: é uma taxa de 0,3% ao ano sobre o valor dos títulos, cobrada pela BM&FBovespa, referente aos serviços de guarda dos títulos e às informações e movimentações dos saldos.</p>
						<p>Esta taxa é cobrada semestralmente, no primeiro dia útil de janeiro ou de julho, ou na ocorrência de um evento de custódia (pagamento de juros, venda ou vencimento do título), o que ocorrer primeiro. A taxa é cobrada proporcionalmente ao período em que o investidor mantiver o título. </p>
						<p>Taxa de serviços: Bancos e corretoras também podem cobrar taxas de serviços livremente acordadas com os investidores. Há instituições que não cobram nenhuma taxa, enquanto outras cobram a cada operação realizada. As taxas cobradas pelas instituições estão disponíveis para consulta no site do Tesouro Direto (link http://zip.net/byrryW). O investidor deve confirmá-las no momento da contratação.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>



<div class="scroll-top page-scroll hidden-sm hidden-xs hidden-lg hidden-md">
    <a class="btn btn-primary" href="#page-top">
        <i class="fa fa-chevron-up"></i>
    </a>
</div>
<?php $this->load->view('footer'); ?>

<script  type="text/javascript">
    $(document).ready(function () {
        $("#selecao").on('change', function () {
            $('.formulario').hide();
            $('#' + this.value).fadeIn(1000);

        });
    });
    function opcao() {
        if (document.getElementById("selecao").value == "") {
            alert("Por favor selecione uma operação");
        }
        if (document.getElementById("selecao").value == "1") {
            Poup();
        }
        if (document.getElementById("selecao").value == "2") {
            CDB();
        }
        if (document.getElementById("selecao").value == "3") {
            RendaFixa();
        }
        if (document.getElementById("selecao").value == "4") {
            Tesouro();
        }
    }

    function valida() {
        if (document.getElementById("inv").value == "") {
            alert("Valor não informado!");
            return false;
        } else {
            if (validanumero()) {
                return true;
            } else {
                return false;
            }
        }

    }
    function validanumero() {
        var valorX = document.getElementById("inv").value;
        if (isNaN(valorX)) {
            alert("Valor do campo não numerico");
            return false;
        } else {
            return true;
        }

    }

    function Poup() {
        var tempo = document.getElementById("tempo").value;
        var valorX = document.getElementById("inv").value;
        var resultado = parseInt(valorX) + (parseInt(valorX) * 1.0) * tempo;
        document.getElementById("total").value = resultado;

    }
    function CDB() {
        var tempo = document.getElementById("tempo").value;
        var valorX = document.getElementById("inv").value;
        var resultado = parseInt(valorX) + (parseInt(valorX) * 0.11) * tempo;
        document.getElementById("total").value = resultado;

    }
    function RendaFixa() {
        var tempo = document.getElementById("tempo").value;
        var valorX = document.getElementById("inv").value;
        var resultado = parseInt(valorX) + (parseInt(valorX) * 0.3) * tempo;
        document.getElementById("total").value = resultado;

    }
    function Tesouro() {
        var tempo = document.getElementById("tempo").value;
        var valorX = document.getElementById("inv").value;
        var resultado = parseInt(valorX) + (parseInt(valorX) * 0.105) * tempo;
        document.getElementById("total").value = resultado;

    }
</script>