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
					<p>Por serem investimentos de alto risco, não é possível mensurar ganhos concretos, porém, a rentabilidade é alta. Esse tipo de investimento necessita de um alto conhecimento.<p>
                    <select required data-validation-required-message="Escolha uma opçao" class="selectpicker form-control input-lg" data-style="btn-success" name="selecao" id="selecao">
                        <option value=""> Suas melhores opções...</option>
                        <option value="1">Mercado a Termo</option> 
                        <option value="2">Mercado de Opções</option>
                        <option value="3">Mercado Futuro</option>
                        <option value="4">Mercado Forex</option>
                    </select>
                    <br>
                </div>
            </div>
        </div>    
        <div class="col-lg-10 col-lg-offset-1">
            <div class="formulario" id="1">
                <div class="row investe" >
                    <div class="col-lg-12">
                        <h1>O que é?</h1>
						<p>É aquele em que as partes assumem compromisso de compra e venda de quantidade e qualidade determinadas de um ativo dito real (mercadoria).</p>
						<p>Exemplo: contratação de compra/venda de um lote padronizado de ouro para entrega em 30 dias.</p>
						<p>As partes compradora e vendedora ficam vinculadas uma à outra até a liquidação do contrato, ou seja:</p>
						<p>I. O comprador do termo leva o contrato até o final do prazo contratado, paga pelo ativo objeto do contrato e quer recebê-lo;</p>
						<p>II. O vendedor quer levar o contrato até o final, quer entregar o ativo objeto e receber o correspondente pagamento.</p>
						<h1>O contrato a termo caracteriza-se por:</h1>
						<p>ser muito detalhado.</p>
						<p>ter movimentação financeira somente na liquidação.</p>
						<h1>Suas desvantagens operacionais são:</h1>
						<p>baixa liquidez.</p>
						<p>pouca transparência.</p>
						<p>risco de crédito.</p>
						<br><br><center class="list-inline item-details">
                            <li>Referência:
                                <strong><a href="http://www.portaldoinvestidor.gov.br/menu/Menu_Investidor/derivativos/mercado_termo.html" target="blank">Portal do Investidor</a>
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
						<p>No mercado de opções, negocia-se o direito de comprar ou de vender um bem por um preço fixo numa data futura. Quem adquirir o direito deve pagar um prêmio ao vendedor. Este prêmio não é o preço do bem, mas apenas um valor pago para ter a opção (possibilidade) de comprar ou vender o referido bem em uma data futura por um preço previamente acordado.</p>
						<p>O objeto de negociação pode ser um ativo financeiro ou uma mercadoria, negociados em pregão, com ampla transparência. O comprador da opção, também chamado titular, sempre terá o direito do exercício, mas não obrigação de exercê-lo. O vendedor da opção, também chamado lançador, terá a obrigação de atender ao exercício caso o titular opte por exercer seu direito.</p>
						<p>Preço de exercício: É o preço que o titular paga (ou recebe) pelo bem em caso de exercício da opção. </p>
						<p>Prêmio: É o valor pago pelo titular (e recebido pelo lançador) para adquirir o direito de comprar ou vender o ativo pelo preço de exercício em data futura.</p>
						<p>Assim como no mercado futuro, é possível uma contraparte transferir a um terceiro o seu compromisso, desde que execute a operação inversa àquela que originou a posição inicial; quem comprou, vende a mesma opção; ou quem vendeu originalmente, compra uma opção para a mesma série e vencimento, o que dispensa a necessidade das contrapartes originais permanecerem atreladas até a data de vencimento da obrigação.</p>
						<p>É importante destacar que, no mercado de opções, o titular pode perder no máximo o prêmio pago, enquanto para o lançador de uma opção os riscos são ilimitados.</p>
						<br><br><center class="list-inline item-details">
                            <li>Referência:
                                <strong><a href="http://www.investidor.gov.br/menu/Menu_Investidor/derivativos/mercado_opcoes.html" target="blank">Portal do Investidor</a>
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
            <div class="formulario" id="3">
                <div class="row investe" >
                    <div class="col-lg-12">
                        <h1>O que é?</h1>
						<p>Semelhante ao mercado a termo, no entanto, as obrigações financeiras, com apuração de perdas e ganhos, são ajustadas diariamente entre as partes, conforme as expectativas do mercado referente ao preço futuro da ação.</p>
						<h1>Vantagens</h1>
						<p>Proteger das oscilações de preços do papel negociado no mercado</p>
						<p>Diversificar riscos, utilizando margem de garantia</p>
						<p>Obter recursos para aproveitar as oportunidades de negócios no mercado</p>
						<p>Oportunidade de alavancar ganhos de sua carteira de ações</p>
						<br><br><center class="list-inline item-details">
                            <li>Referência:
                                <strong><a href="http://www.fatorcorretora.com.br/corretora_valores/produtos/acoes/termo.html" target="blank">Fator Corretora</a>
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
						<p>O Mercado de Forex é o maior Mercado do mundo com mais de 4 trilhões de dólares negociados diariamente, valor superior a 9 vezes a soma diária de todas as negociações feitas em todas bolsas de valores do mundo juntas.</p>
						<p>Trata-se de um Mercado descentralizado, ou seja, ele não é negociado em um único local onde todas as ordens de compra e venda são emitidas, como no Brasil na BM&F Bovespa.</p>
						<p>Cada corretora de Forex possui os bancos que fornecem a liquidez, ou seja, que fornecem as moedas para a compra e venda para as corretoras. Os bancos que fornecem as moedas para negociação são os grandes bancos globais como Deutsche Bank, UBS AG, Barclays, Citibank, JP Morgan, HSBC.</p>
						<h1>2) E no Brasil essa operação é legalizada?</h1>
						<p>Como é um mercado descentralizado, cada país possui suas regras e condições. A grande maioria dos países do mundo oferecem o mercado de Forex para pessoas físicas como você desde que o uso do home broker (negociação feita pela internet) se popularizou no final da década de 90.</p>
						<p>Cada país fez sua regulamentação e regras. Hoje o mercado de Forex é popular em todos os países desenvolvidos como Estados Unidos, Canadá, Japão, Austrália, Hong Kong e em toda Europa.</p>
						<p>Infelizmente no Brasil esse mercado ainda não foi regulamentado pela CVM (Comissão de Valores Mobiliários), o que significa que nenhuma corretora de valores pode oferecer este serviço ao cliente aqui no Brasil.</p>
						<p>É por isso que surgiram boatos sobre a legalização do Forex. Mas como queremos justamente encontrar opções de investimentos em que seu dinheiro fique longe do governo, você pode investir no Forex sim. Para isso, basta abrir uma conta em qualquer corretora (estrangeira, nesse caso) de Forex em qualquer país do mundo sem problemas.</p>
						<h1>3) O que é o Forex?</h1>
						<p>Diferentemente do Mercado Futuro no Brasil em que você vai trabalhar com derivativos como boi gordo, ouro, índice Bovespa, dólar, no Forex você vai trabalhar com taxas cambiais entre duas moedas. A maior parte das transações são:</p>
						<p>Como você observou, é sempre a relação entre duas moedas. Você pode entrar comprado ou vendido na transação. Por exemplo, se você avaliou que o Euro vai valorizar em relação ao Dólar, você deverá vender o EUR/USD (entrar vendido no caso), pois nesse caso a relação EUR/USD irá diminuir.</p>
						<img class="aligncenter size-full wp-image-3121" src="http://www.jornadadodinheiro.com/wp-content/uploads/2016/01/Como-funciona-o-mercado-FOREX2a.jpg" alt="Como funciona o mercado FOREX?" srcset="http://www.jornadadodinheiro.com/wp-content/uploads/2016/01/Como-funciona-o-mercado-FOREX2a.jpg 755w, http://www.jornadadodinheiro.com/wp-content/uploads/2016/01/Como-funciona-o-mercado-FOREX2a-300x99.jpg 300w" sizes="(max-width: 755px) 100vw, 755px" width="755" height="249">
						<img class="aligncenter size-full wp-image-3120" src="http://www.jornadadodinheiro.com/wp-content/uploads/2016/01/Como-funciona-o-mercado-FOREX2.jpg" alt="Como funciona o mercado FOREX?" srcset="http://www.jornadadodinheiro.com/wp-content/uploads/2016/01/Como-funciona-o-mercado-FOREX2.jpg 362w, http://www.jornadadodinheiro.com/wp-content/uploads/2016/01/Como-funciona-o-mercado-FOREX2-170x300.jpg 170w" sizes="(max-width: 362px) 100vw, 362px" width="362" height="640">
						<p>O horário de funcionamento também é diferente. Há possibilidade de realizar um trade 24h por dia, 6 dias da semana. Ele começa no domingo à noite e termina na sexta à noite. Por que é assim? Porque ele começa no horário comercial de Sydney, depois de Tóquio, Londres e finalmente termina em Nova Iorque.</p>
						<p>Outra característica importante do FOREX é a possibilidade de alavancagem. A sigla PIP (Price Interest Point) é a menor unidade de preço de qualquer mercado cambial. No FOREX, seu ganho é sobre o PIPS. Equivale a 1/100 de um centavo. Ou seja, se você investir 1 dólar, você estará controlando 100 dólares de valor no FOREX. É por isso que existe uma alta alavancagem no FOREX.</p>
						<p>Com toda essa alavancagem, você pode ganhar muito como também perder muito. Você precisa estudar bem a análise gráfica para começar nesse investimento.</p>
                        <br><br><center class="list-inline item-details">
                            <li>Referência:
                                <strong><a href="http://www.jornadadodinheiro.com/investir/como-funciona-o-mercado-forex/" target="blank">Jornal do dinheiro</a>
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
        if (document.getElementById("selecao").value == "3") {
            RendaFixa();
        }
        if (document.getElementById("selecao").value == "4") {
            Tesouro();
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
        var resultado = parseInt(valorX) + (parseInt(valorX) * 0.18) * tempo;
        document.getElementById("total").value = resultado;

    }
    function RendaFixa() {
        var tempo = document.getElementById("tempo").value;
        var valorX = document.getElementById("inv").value;
        var resultado = parseInt(valorX) + (parseInt(valorX) * 0.13) * tempo;
        document.getElementById("total").value = resultado;

    }
    function Tesouro() {
        var tempo = document.getElementById("tempo").value;
        var valorX = document.getElementById("inv").value;
        var resultado = parseInt(valorX) + (parseInt(valorX) * 3.0) * tempo;
        document.getElementById("total").value = resultado;

    }
</script>