<?php defined('BASEPATH') OR exit('No direct script access allowed'); ?>
<?php $this->load->view('head'); ?>
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
                <p>Caderneta de Poupança</p>
                <p>CDB</p>
                <p>Fundos de Renda Fixa</p>
                <p>Tesouro Direto</p>
                <p>LCI</p>
            </div>
        </div>

        <div class="row" id="poupanca">
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
        
        <div class="row" id="cdb">
            <div class="col-lg-8 col-lg-offset-2">
                <h1>O que é?</h1>
                <h1>Como Investir</h1>
            </div>
        </div>
        
        <div class="row" id="rendafixa">
            <div class="col-lg-8 col-lg-offset-2">
                <h1>O que é?</h1>
                <h1>Como Investir</h1>
            </div>
        </div>
        
        <div class="row" id="tesouro">
            <div class="col-lg-8 col-lg-offset-2">
                <h1>O que é?</h1>
                <h1>Como Investir</h1>
            </div>
        </div>
        
        <div class="row" id="lci">
            <div class="col-lg-8 col-lg-offset-2">
                
            </div>
        </div>
    </div>
</section>

<?php $this->load->view('footer'); ?>
<div class="scroll-top page-scroll hidden-sm hidden-xs hidden-lg hidden-md">
    <a class="btn btn-primary" href="#page-top">
        <i class="fa fa-chevron-up"></i>
    </a>
</div>