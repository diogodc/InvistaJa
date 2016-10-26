<?php defined('BASEPATH') OR exit('No direct script access allowed'); ?>
<?php $this->load->view('head'); ?>
<header>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <img class="img-responsive" src="<?php echo base_url("assets/img/login.png") ?>" alt="">
                <div class="intro-text">
                    <span class="name">Área Restrita</span>
                    <hr class="star-light">
                    <span class="skills"></span>
                </div>
            </div>
        </div>
    </div>
</header>
<section id="#">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2>Por favor, logue-se</h2>
                <hr class="star-primary">
            </div>
        </div>
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">

                <?php echo validation_errors(); ?>
                <form class="form-signin " role="form" method="post" action="<?= base_url('login/validar') ?>">
                    <div class="row control-group">
                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <label>Email</label>
                            <?php
                            $dados = array(
                                'type' => 'email',
                                'id' => 'email',
                                'name' => 'usuario',
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
                <!--<input type="email" class="form-control" placeholder="Email address" required autofocus name="usuario">-->
                    <div class="row control-group">
                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <label>Email</label>
                            <?php
                            $dados = array(
                                'type' => 'password',
                                'id' => 'password',
                                'name' => 'senha',
                                'required data-validation-required-message' => 'Digite sua senha',
                                'class' => 'form-control',
                                'placeholder' => 'Senha',
                            );
                            echo form_input($dados);
                            ?>
                            <!--<input type="email" class="form-control" placeholder="Email" id="email" required data-validation-required-message="Digite seu Email.">-->
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    <!--<input type="password" class="form-control" placeholder="Password" required name="senha">-->
                    <br>
                    <div id="success"></div>
                    <div class="row">
                        <div class="form-group col-xs-12">
                            <?php
                            $dados = array('class' => 'btn btn-success btn-lg');
                            echo form_submit($dados, 'Fazer Login');
                            ?>
                            <!--<button type="submit" class="btn btn-success btn-lg">Enviar</button>-->
                        </div>
                    </div> 
                    <!--<button class="btn btn-lg btn-primary btn-block" type="submit">Fazer login</button>-->
                </form>
                <div class="row">
                    <div class="col-xs-12 text-center">
                        <h4>Não possui cadastro?</h4>
                        <a href="<?php echo base_url('usuario') ?>"><h4>Crie uma conta</h4></a>
                    </div>
                </div>  
            </div>
        </div>
    </div>
</section>

<?php $this->load->view('footer'); ?>