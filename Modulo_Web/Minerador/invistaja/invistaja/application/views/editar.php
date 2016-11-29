<?php defined('BASEPATH') OR exit('No direct script access allowed'); ?>
<?php $this->load->view('head'); ?>
<script  type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<header>
</header>
<section id="user">
    <div class="container" style="padding-top : 50px">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2>Seus dados</h2>
                <hr class="star-primary">
            </div>
        </div>

        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <?php echo form_open('usuario/alter'); ?>
                <?php
                $data = array(
                    'type' => 'hidden',
                    'name' => 'id',
                    'id' => 'hiddenid',
                    'value' => $ID_USER,
                    'class' => 'hidden'
                );

                echo form_input($data);
                ?>
                <div class="novalidate">
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
                                'value' => $NAME_USER,
                                'readonly' => "readonly"
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
                                'value' => $LOGIN,
                                'readonly' => "readonly"
                            );

                            echo form_input($dados);
                            ?>
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
                                'value' => $PHONE_NUMBER_USER,
                                'data-mask' => '(00) 0000-0000',
                                'data-mask-selectonfocus' => "true"
                            );

                            echo form_input($dados);
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
                            echo form_submit($dados, 'Salvar');
                            ?>
                        </div>
                    </div>
                </div>    
                <?php echo form_close(); ?>
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