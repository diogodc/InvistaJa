<?php defined('BASEPATH') OR exit('No direct script access allowed'); ?>
<?php $this->load->view('head'); ?>
<header>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <?php if (isset($email_enviado)) { ?>
                    <div style="background: white; color: black; margin: 10px; padding: 10px;border: #D0D0D0;border-style: solid; " id="mensagem_enviada"><?php echo $email_enviado ?></div>
                <?php } ?>    
                <img class="img-responsive" src="<?php echo base_url("assets/img/profilecontato.png") ?>" alt="">
                <div class="intro-text">
                    <span class="name">Tem uma dúvida?</span>
                    <hr class="star-light">
                    <span class="skills">Ou quer saber mais?</span>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- Contact Section -->
<section id="">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 text-center">
                <h2 class="section-heading">Entre em contato conosco</h2>
                <hr class="star-primary">
            </div>
        </div>

        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
                <!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->

                <?php $attributes = array('class' => 'email', 'id' => 'contactForm'); ?>
                <?php echo form_open('contato/enviaEmail', $attributes); ?>
                <!--<form action="" method="post" name="sentMessage" id="contactForm" novalidate>-->
                <div novalidate>
                    <div class="row control-group">
                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <label>Nome</label>
                            <?php
                            $dados = array(
                                'type' => 'text',
                                'id' => 'nome',
                                'name' => 'nome',
                                'required data-validation-required-message' => 'Digite seu nome',
                                'class' => 'form-control',
                                'placeholder' => 'Nome',
                            );

                            echo form_input($dados);
                            ?>

                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    <div class="row control-group">
                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <label>Email</label>
                            <?php
                            $dados = array(
                                'type' => 'email',
                                'id' => 'email',
                                'name' => 'email',
                                'required data-validation-required-message' => 'Digite seu Email',
                                'class' => 'form-control',
                                'placeholder' => 'Email',
                            );

                            echo form_input($dados);
                            ?>
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    <div class="row control-group">
                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <label>Telefone</label>
                            <?php
                            $dados = array(
                                'type' => 'tel',
                                'id' => 'telefone',
                                'name' => 'telefone',
                                'required data-validation-required-message' => 'Digite seu telefone',
                                'class' => 'form-control',
                                'placeholder' => 'Telefone',
                            );

                            echo form_input($dados);
                            ?>
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    <div class="row control-group">
                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <label>Messagem</label>
                            <?php
                            $dados = array(
                                'rows' => '5',
                                'id' => 'mensagem',
                                'name' => 'mensagem',
                                'required data-validation-required-message' => 'Digite sua mensagem',
                                'class' => 'form-control',
                                'placeholder' => 'Mensagem',
                            );

                            echo form_textarea($dados);
                            ?>
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    <br>
                    <div id="success"></div>
                    <div class="row">
                        <div class="form-group col-xs-12">
                            <?php
                            $dados = array(
                                'class' => 'btn btn-success btn-lg',
                            );
                            echo form_submit($dados, 'Enviar');
                            ?>

                        </div>
                    </div>
                </div>    
                <?php echo form_close(); ?>
            </div>
        </div>
    </div>
</section>
<script type="text/javascript">
/* Máscaras ER */
function mascara(o,f){
    v_obj=o
    v_fun=f
    setTimeout("execmascara()",1)
}
function execmascara(){
    v_obj.value=v_fun(v_obj.value)
}
function mtel(v){
    v=v.replace(/\D/g,"");             //Remove tudo o que não é dígito
    v=v.replace(/^(\d{2})(\d)/g,"($1) $2"); //Coloca parênteses em volta dos dois primeiros dígitos
    v=v.replace(/(\d)(\d{4})$/,"$1-$2");    //Coloca hífen entre o quarto e o quinto dígitos
    return v;
}
function id( el ){
	return document.getElementById( el );
}
window.onload = function(){
	id('telefone').onkeyup = function(){
		mascara( this, mtel );
	}
}
</script>
<?php $this->load->view('footer'); ?>