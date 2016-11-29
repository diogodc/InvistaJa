<?php defined('BASEPATH') OR exit('No direct script access allowed'); ?>
<?php $this->load->view('head'); ?>
<header>
</header>

<!-- Contact Section -->
<section id="user">
    <div class="container" style="padding-top : 50px">
        <div class="row">
			<?php if (isset($erro)) { ?>
                <center style="background: red; color: white; margin: 10px; padding: 10px;border: #D0D0D0;border-style: solid;font-size:1.4em; " id="mensagem_enviada"><?php echo $erro ?></center>
			<?php } ?>
            <div class="col-lg-12 text-center">
                <h2>Faça seu cadastro</h2>
                <hr class="star-primary">
            </div>
        </div>

        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <?php echo form_open('usuario/novo'); ?>
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
                                'required data-validation-required-message' => 'Digite seu Nome',
                                'class' => 'form-control',
                                'placeholder' => 'Nome',
                            );

                            echo form_input($dados);
                            ?>

                                <!--<input type="text" class="form-control" placeholder="Nome" id="nome" required data-validation-required-message="Digite seu nome.">-->
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
                            <!--<input type="email" class="form-control" placeholder="Email" id="email" required data-validation-required-message="Digite seu Email.">-->
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    <div class="row control-group">
                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <label>Senha</label>
                            <?php
                            $dados = array(
                                'type' => 'password',
                                'id' => 'senha',
                                'name' => 'senha',
                                'required data-validation-required-message' => 'Cadastre uma senha',
                                'class' => 'form-control',
                                'placeholder' => 'Senha',
                            );

                            echo form_input($dados);
                            ?>
                            <!--<input type="email" class="form-control" placeholder="Email" id="email" required data-validation-required-message="Digite seu Email.">-->
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    <div class="row control-group">
                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <label>Telefone</label>
                            <?php
                            $dados = array(
                                'type' => 'text',
                                'id' => 'telefone',
                                'name' => 'telefone',
                                'required data-validation-required-message' => 'Digite seu telefone',
                                'class' => 'form-control',
                                'placeholder' => 'Telefone'
                            );

                            echo form_input($dados);
                            ?>
                            <!--<input type="tel" class="form-control" placeholder="Telefone" id="telefone" required data-validation-required-message="Informe seu telefone.">-->
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
                            echo form_submit($dados, 'Salvar');
                            ?>
                            <!--<button type="submit" class="btn btn-success btn-lg">Enviar</button>-->
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

