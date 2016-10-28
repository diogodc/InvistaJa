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
                <h2>Veja algumas opções</h2>
                <hr class="star-primary">
                <select name="selecao" id="selecao">
                    <option selected> Suas melhores opções...</option>
                    <option value="1">Mercado a Termo</option> 
                    <option value="2">Mercado de opções</option>
                    <option value="3">Mercado Futuro</option>
                    <option value="4">Mercado Forex</option>
                </select><br>
                <label>Quanto você deseja investir?</label><br>
                <input id="inv" type="text"/><br>
                <label>Por quanto tempo deseja deixar seu dinheiro investido?</label><br>
                <input id="tempo" type="text" value="">*valor anual</input><br><br>
                <input id="calcular" type="button" value="Calcular" onclick="opcao()"/><br>
                <label>Quanto você teria ao final do rendimento:</label><br>
                <input id="total" type="text"/><br>
            </div>
        </div>
        <div class="formulario" id="1">
            <div class="row investe" >
                <div class="col-lg-8 col-lg-offset-2">
                    <h1>O que é?</h1>
                    <p>No Brasil, a caderneta de poupança, muitas vezes chamada apenas de poupança, é uma forma de investimento de baixo risco cuja operação é regida por regras específicas estabelecidas pelo governo para depósitos de poupança.</p>
                    <p>As cadernetas de poupança são o investimento mais tradicional do Brasil e são oferecidas a pessoas físicas e jurídicas por instituições financeiras públicas e privadas através de contas bancárias chamadas de conta poupança. Dessa forma, os valores depositados na conta poupança são aplicados automaticamente na caderneta de poupança, tem liquidez diária e sofrem remunerações mensais de acordo com as determinações feitas pela legislação brasileira.</p>
                    <p>Para pessoas físicas, os rendimentos auferidos em contas poupança (usualmente através da caderneta de poupança) são isentos de imposto de renda[1] e os depósitos de poupança (assim como seus rendimentos) são objeto de garantia ordinária do FGC[2].</p>
                    <h1>Como Investir</h1>
                    <p>Uma poupança pode ser aberta por qualquer pessoa em uma agência bancária, por meio de um gerente.</p>
                    <p>Os documentos necessários são RG, CPF e comprovante de residência. O dinheiro aplicado pode ser retirado em qualquer momento.</p>
                    <p>A quantidade mínima necessária para iniciar o investimento varia de acordo com os bancos.</p>
                </div>
            </div>
        </div>
        <div class="formulario" id="2">
            <div class="row investe" >
                <div class="col-lg-8 col-lg-offset-2">
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
                </div>
            </div>
        </div>
        <div class="formulario" id="3">
            <div class="row investe" >
                <div class="col-lg-8 col-lg-offset-2">
                    <h1>O que é?</h1>
                    <h1>Como Investir</h1>
                </div>
            </div>
        </div>
        <div class="formulario" id="4">
            <div class="row investe" >
                <div class="col-lg-8 col-lg-offset-2">
                    <h1>O que é?</h1>
                    <h1>Como Investir</h1>
                </div>
            </div>
        </div>
        <div class="formulario" id="5">
            <div class="row investe" >
                <div class="col-lg-8 col-lg-offset-2">

                </div>
            </div>
        </div>
    </div>
</section><section id="#">
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
                        <option value="1">Mercado a tempo</option> 
                        <option value="2">Mercado de opções</option>
                        <option value="3">Mercado futuro</option>
                        <option value="4">Mercado forex</option>
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
                            <input required data-validation-required-message="Digite o tempo que deseja investir" placeholder="Por quanto tempo deseja deixar seu dinheiro investido? *valor anual" class="form-control" id="tempo" type="number" value=""/>
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
                    </div>
                </div>
            </div>
            <div class="formulario" id="3">
                <div class="row investe" >
                    <div class="col-lg-12">
                        <h1>O que é?</h1>
                        <h1>Como Investir</h1>
                    </div>
                </div>
            </div>
            <div class="formulario" id="4">
                <div class="row investe" >
                    <div class="col-lg-12">
                        <h1>O que é?</h1>
                        <h1>Como Investir</h1>
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
        var resultado = parseInt(valorX) + (parseInt(valorX) * 0.1) * tempo;
        document.getElementById("total").value = resultado;

    }
</script>