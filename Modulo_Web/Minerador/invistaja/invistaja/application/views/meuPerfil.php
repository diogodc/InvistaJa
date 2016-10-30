<?php defined('BASEPATH') OR exit('No direct script access allowed'); ?>
<?php $this->load->view('head'); ?>
<header>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <img class="img-responsive" src="<?php echo base_url("assets/img/meu perfil.png") ?>" alt="">
                <div class="intro-text">
                    <span class="skills">Seu Perfil é</span>
                    <hr class="star-light">
                    <span class="name"><?php echo $perfil['NAME_PROFILE']; ?></span>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- Contact Section -->
<section id="#">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-justify">
                <p><?php echo $perfil['RESUMO']; ?><p>
                <h4><a href="<?php echo base_url('simulacao') ?>">Clique aqui para fazer uma simulação</a></h4>
                <hr class="star-primary">
                <h4>Não concordo com meu perfil</h4>
                <p>Alguns clientes, ainda que orientados sobre os investimentos mais adequados ao seu perfil, aqueles como menos chances de trazerem frustrações, optam por investir em outros produtos.</p>
                <p>É o caso de clientes considerados conservadores e que querem aplicar boa parte de seus recursos em ações, por exemplo. Nesses casos, a instituição sugere que ele siga seu perfil de investimento, mas podem atender o pedido do cliente, desde que este assine um termo atestando que está ciente dos riscos que está assumindo.</p>
                <p>Importante ressaltar que, assim como vantagens, todos os investimentos têm riscos e é importante conhecer a fundo todos os que envolvem o produto que você escolheu.</p>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
                <!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->

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