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
                    <select required data-validation-required-message="Escolha uma opçao" class="selectpicker form-control input-lg" data-style="btn-success" name="selecao" id="selecao">
                        <option value=""> Suas melhores opções...</option>
                        <option value="1">Caderneta de poupança</option> 
                        <option value="2">CDB</option>
                        <option value="4">Tesouro direto</option>
                        <option value="5">LCI</option>
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
                            <label>Tempo no investimento</label>
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
                        <label>Rendimento</label>
                        <input class="form-control" placeholder="Quanto você teria ao final do rendimento:" id="total" type="number" readonly="readonly"/>
                    </div>
                </div>
            </div>
        </div>    
        <div class="col-lg-10 col-lg-offset-1">
            <div class="formulario" id="1">
                <div class="row investe" >
                    <div class="col-lg-12">
                        <h1>O que é?</h1>
                        <p>No Brasil, a caderneta de poupança, muitas vezes chamada apenas de poupança, é uma forma de investimento de baixo risco cuja operação é regida por regras específicas estabelecidas pelo governo para depósitos de poupança.</p>
                        <p>As cadernetas de poupança são o investimento mais tradicional do Brasil e são oferecidas a pessoas físicas e jurídicas por instituições financeiras públicas e privadas através de contas bancárias chamadas de conta poupança. Dessa forma, os valores depositados na conta poupança são aplicados automaticamente na caderneta de poupança, tem liquidez diária e sofrem remunerações mensais de acordo com as determinações feitas pela legislação brasileira.</p>
                        <p>Para pessoas físicas, os rendimentos auferidos em contas poupança (usualmente através da caderneta de poupança) são isentos de imposto de renda[1] e os depósitos de poupança (assim como seus rendimentos) são objeto de garantia ordinária do FGC[2].</p>
                        <h1>Como Investir</h1>
                        <p>Uma poupança pode ser aberta por qualquer pessoa em uma agência bancária, por meio de um gerente.</p>
                        <p>Os documentos necessários são RG, CPF e comprovante de residência. O dinheiro aplicado pode ser retirado em qualquer momento.</p>
                        <p>A quantidade mínima necessária para iniciar o investimento varia de acordo com os bancos.</p>
						<br><br><center class="list-inline item-details">
                            <li>Referência:
                                <strong><a href="https://pt.wikipedia.org/wiki/Caderneta_de_poupan%C3%A7a" target="blank">Wikipédia</a>
                                </strong>
                            </li>
                            <li>Data:
                                <strong>Novembro 2016</strong>
                            </li>
                            <li>Imagem:
                                <strong><a href="http://br.freepik.com/" target="blank">Free Pik</a>
                                </strong>
                            </li>
                        </center>
					</div>
                </div>
            </div>
            <div class="formulario" id="2">
                <div class="row investe" >
                    <div class="col-lg-12">
                        <h1>O que é?</h1>
                        <p>O CDB - Certificado de Depósito Bancário é um título de renda fixa extremamente seguro, que é emitido pelos bancos como forma de captação de recursos com o objetivo de financiar suas atividades.</p>
                        <p>Ele funciona como um “empréstimo” do investidor para as instituições financeiras, e em troca desse empréstimo a instituição te devolve o dinheiro corrigido com os juros.</p>
                        <h1>Como Investir</h1>
                        <p>Para investir nestes títulos de Renda Fixa, o passo a passo é muito simples:</p>
                        <p>Primeiro você precisa estabelecer seus objetivos. É muito importante determinar antecipadamente qual o valor que você pretende investir, o prazo que você poderá deixar o seu capital aplicado e quais metas deseja atingir.</p>
                        <p>O segundo passo é abrir uma conta de investimentos. Ao abrir sua conta em uma corretora, você terá acesso à títulos de diversas instituições, com diferentes prazos e rentabilidades.</p>
                        <p>Escolher o título mais adequado de acordo com o seu planejamento inicial. Tendo em vista o seu capital e o prazo que pretende resgatá-lo, você terá diferentes opções de título, então é preciso compará-los e verificar qual deles lhe trará a melhor rentabilidade e as melhores condições.</p>
                        <p>Proteja seu patrimônio. É muito importante respeitar o limite de proteção do FGC, de até R$250 mil. Caso deseje investir uma quantia maior que essa, uma dica interessante é dividir o seu capital em títulos de diferentes bancos.
                        <p>Por fim, aplique o seu dinheiro. E então é só acompanhar o desempenho do seu investimento e aguardar seus lucros.</p>
						<br><br><center class="list-inline item-details">
                            <li>Referência:
                                <strong><a href="https://www.tororadar.com.br/investimento/cdb-rendimento-o-que-e" target="blank">Toro Radar</a>
                                </strong>
                            </li>
                            <li>Data:
                                <strong>Novembro 2016</strong>
                            </li>
                            <li>Imagem:
                                <strong><a href="http://br.freepik.com/" target="blank">Free Pik</a>
                                </strong>
                            </li>
                        </center>
					</div>
                </div>
            </div>
            <div class="formulario" id="4">
                <div class="row investe" >
                    <div class="col-lg-12">
                        <h1>O que é?</h1>
                        <p>Tesouro Direto é um programa implementado em 7 de janeiro de 2002 pelo Tesouro Nacional, em parceria com a BM&FBovespa. O objetivo é tornar popular o acesso ao investimento em títulos públicos, possibilitando sua compra por pessoas físicas pela internet.</p>
                        <p>Os títulos públicos federais são créditos emitidos pelo Tesouro Nacional sob a forma escritural (meio eletrônico) ao público para financiamento do Déficit Orçamentário Geral da União e da Dívida Pública Federal, e custodiados por Central Depositária especializada e habilitada.</p>
                        <h1>Como Investir</h1>
						<p>As pessoas podem comprar títulos de duas maneiras. A primeira delas é participando de um fundo que invista neles. Nesse caso, a compra dos títulos é realizada por um administrador profissional.</p>
						<p>A segunda forma é comprar diretamente na Secretaria do Tesouro, pela Internet, por meio de um serviço chamado Tesouro Direto (link encurtado: http://zip.net/bqrs5J).</p>
						<p>Para realizar essa compra direta, a pessoa precisa ter CPF (Cadastro de Pessoa Física) e estar cadastrada em um banco ou corretora habilitados a operar o Tesouro Direto. Esses operadores habilitados são chamados agentes de custódia.</p>
						<p>O cadastro em um banco ou corretora também é necessário para quem investe por meio de um fundo.</p>
						<p>Nele, deve ser informado nome, profissão, endereço e entregues cópias do RG, CPF e comprovante de residência do investidor.</p>
						<p>Assim, a corretora abre uma conta desse investidor na BM&FBovespa. Cada instituição determina qual a quantia mínima para a abertura da conta.</p>
						<p>A lista destas entidades é encontrada neste link http://zip.net/byrryW.</p>
						<p>Para quem opta pela compra direta, depois de feita a inscrição em um destes bancos ou corretoras, o investidor recebe uma senha para ter acesso à operação pela Internet.</p>
						<p>A negociação é feita no site do Tesouro Direto (link: http://zip.net/bqrs5J).</p>
						<p>Os títulos públicos podem ser prefixados (nesse caso, o rendimento é definido no momento em que é feito o investimento) ou pós-fixados (isso significa que a rentabilidade está associada a algum índice, como o IPCA ou a taxa Selic, por exemplo).</p>
						<p>Quando comprados, os títulos têm um prazo de vencimento, que significa o dia em que o governo pagará ao investidor o dinheiro que ele investiu.</p>
						<p>O investidor também pode negociar os títulos antes dessa data, mas receberá o valor de mercado do título naquele momento, que pode ser maior ou menor que o estipulado para o vencimento.</p>
						<p>No caso dos títulos, o dinheiro é depositado ou retirado na conta do investidor no dia seguinte ao da ordem de venda ou compra.</p>
						<h1>Qual o grau de risco desse investimento?</h1>
						<p>Os títulos são investimentos de baixo risco, pois o governo é o credor. Mas, se o investidor vender seus títulos antes da data de vencimento, o ganho ou a perda estará sujeito ao valor de mercado do título naquele momento.</p>
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
						<br><br><center class="list-inline item-details">
                            <li>Referência:
                                <strong><a href="https://pt.wikipedia.org/" target="blank">Wikipédia</a>
                                </strong>
                            </li>
                            <li>Data:
                                <strong>Novembro 2016</strong>
                            </li>
                            <li>Imagem:
                                <strong><a href="http://br.freepik.com/" target="blank">Free Pik</a>
                                </strong>
                            </li>
                        </center>
					</div>
                </div>
            </div>
            <div class="formulario" id="5">
                <div class="row investe" >
                    <div class="col-lg-12">
						<h1>LCI</h1>
						<p>Mas afinal, o que é LCI? É vantajoso? Tem risco? O que tem a ver com o setor imobiliário?</p>
						<p>A seguir você entenderá suas características e vantagens para tirar suas próprias conclusões e analisar se é interessante investir seu dinheiro em LCI (Letra de Crédito Imobiliário) ou não.</p>
						<p>Quando falamos em investimentos é importante analisarmos o perfil e os objetivos do investidor para determinar o melhor produto do mercado e como alcançar tais objetivos, sejam eles a compra de um imóvel ou carro, ou a sua tão esperada aposentadoria e estabilidade financeira.</p>
						<p>A sigla LCI tem por significado Letra de Crédito Imobiliário. É um produto financeiro lastreado em empréstimos de natureza imobiliária. Para que você entenda melhor, a LCI (Letra de Crédito Imobiliário) é um empréstimo que você faz a uma instituição, sendo que esses recursos serão destinados para financiar o setor imobiliário (construção e reforma de imóveis).</p>
						<p>Como sabemos, o trabalho dos bancos e outras instituições financeiras é pegar dinheiro emprestado, pagando uma taxa de juros, para emprestar a seus clientes cobrando uma taxa maior. Uma das formas de captação de recursos para este fim, em especifico para financiamento de habitação ou o conhecido crédito imobiliário, é através do investimento LCI.</p>
						<p>Através desse produto, a instituição emitente da LCI firmará um “contrato” com o investidor onde serão estabelecidos os juros a serem pagos por aquele dinheiro inicialmente “pego emprestado” e também os prazos de pagamento desses juros.</p>
						<p>Ou seja, recapitulando:</p>
						<p>A LCI é um produto de Renda Fixa que geralmente é emitido pelos bancos como forma de captação de recursos.</p>
						<h1>Como Investir</h1>
						<p>A LCI pode ser emitida por qualquer instituição financeira que disponha o crédito imobiliário como produto de empréstimos a seus clientes. Porém geralmente vemos os bancos como principais instituições que as emitem e também as principais instituições responsáveis pelo financiamento habitacional.</p>
                        <br><br><center class="list-inline item-details">
                            <li>Referência:
                                <strong><a href="https://www.tororadar.com.br/investimento/lci-rendimento-o-que-e" target="blank">Toro Radar</a>
                                </strong>
                            </li>
                            <li>Data:
                                <strong>Novembro 2016</strong>
                            </li>
                            <li>Imagem:
                                <strong><a href="http://br.freepik.com/" target="blank">Free Pik</a>
                                </strong>
                            </li>
                        </center>
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
            alert("Por favor selecione uma opeção");
        }
        if (document.getElementById("selecao").value == "1") {
            Poup();
        }
        if (document.getElementById("selecao").value == "2") {
            CDB();
        }
        if (document.getElementById("selecao").value == "4") {
            Tesouro();
        }
        if (document.getElementById("selecao").value == "5") {
            LCI();
        }
    }

    function valida() {
        if (document.getElementById("inv").value == "") {
            alert("Valor não informador");
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
        var resultado = parseInt(valorX) + (parseInt(valorX) * 0.0617) * tempo;
        document.getElementById("total").value = resultado;

    }
    function CDB() {
        var tempo = document.getElementById("tempo").value;
        var valorX = document.getElementById("inv").value;
        var resultado = parseInt(valorX) + (parseInt(valorX) * 0.0825) * tempo;
        document.getElementById("total").value = resultado;

    }
    function Tesouro() {
        var tempo = document.getElementById("tempo").value;
        var valorX = document.getElementById("inv").value;
        var resultado = parseInt(valorX) + (parseInt(valorX) * 0.1425) * tempo;
        document.getElementById("total").value = resultado;

    }
    function LCI() {
        var tempo = document.getElementById("tempo").value;
        var valorX = document.getElementById("inv").value;
        var resultado = parseInt(valorX) + (parseInt(valorX) * 0.09) * tempo;
        document.getElementById("total").value = resultado;

    }
</script>