<?php defined('BASEPATH') OR exit('No direct script access allowed'); ?>
<?php $this->load->view('head'); ?>
<script type="text/javascript" src="<?php echo site_url("http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js") ?>"></script>
<script type="text/javascript">
    window.onload = function () {
        location.hash = "#pergunta";
    }
</script>
<?php $cont = 1; ?>
<header>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <img class="img-responsive" src="<?php echo base_url("assets/img/perfil.png") ?>" alt="">
                <div class="intro-text">
                    <span class="name">Saber seu perfil</span>
                    <hr class="star-light">
                    <span class="skills">É uma parte importante!</span>
                </div>
            </div>
        </div>
    </div>
</header>
<section id="#perfil">
    <div class="container">
        <div class="row">
            <div id="pergunta" class="col-lg-12 text-center">
                <h2>Responda algumas perguntas:</h2>
                <hr class="star-primary">
            </div>
        </div>
    </div>    
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
            <?php echo validation_errors(); ?>
            <?php if ($qtdPergunta > $pergunta[0]->ID_QUESTION and $pergunta) { ?>
                <form class="form-signin " role="form" method="post" action="<?= base_url('perfil/perguntas') ?>">
                <?php } elseif ($qtdPergunta == $pergunta[0]->ID_QUESTION and $pergunta) { ?>
                    <form class="form-signin " role="form" method="post" action="<?= base_url('perfil/perfil') ?>">
                    <?php } ?>        
                    <div class="row control-group">
                        <div class="form-group col-lg-12 label-form-group controls">
                            <br><div class="row control-group">
                                <div class="form-group col-lg-12 label-form-group controls" style="padding-botton:20px; background-color: #f5f5f0; font-size: 25px; color:#2C3E50">
                                    <?php echo $pergunta[0]->QUESTION; ?>
                                    <?php for ($i = 0; $i < count($resposta); $i++) { ?>
                                        <div style="font-size:20px;border-style: solid; padding:10px;margin:10px;">
                                            <label><?php
                                                $data = array(
                                                    'type' => 'radio',
                                                    'name' => 'resposta',
                                                    'id' => 'hiddenid',
                                                    'value' => $resposta[$i]->ID_ANSWER,
                                                    'class' => 'form-check-input',
                                                    'required data-validation-required-message' => 'Escolha uma resposta'
                                                );

                                                echo form_input($data);
                                                ?>

                                                <?php echo $resposta[$i]->ANSWER_TEXT; ?></label>
                                        </div>
                                    <?php } ?>
                                </div>
                            </div>
                        </div>
                    </div>
                    <?php
                    $data = array(
                        'type' => 'hidden',
                        'name' => 'idx',
                        'id' => 'hiddenid',
                        'value' => $pergunta[0]->ID_QUESTION + 1,
                        'class' => 'hidden'
                    );

                    echo form_input($data);
                    ?>

                    <?php if ($pergunta[0]->ID_QUESTION == $qtdPergunta) { ?>     
                        <div class="row">
                            <div class="form-group col-xs-12">
                                <?php
                                $dados = array('class' => 'btn btn-success btn-lg');
                                echo form_submit($dados, 'Salvar');
                                ?>
                            </div>
                        </div>
                    <?php } else { ?>
                        <div class="row">
                            <div class="form-group col-xs-12">
                                <?php
                                $dados = array('class' => 'btn btn-success btn-lg');
                                echo form_submit($dados, 'Proxima');
                                ?>
                            </div>
                        </div>
                    <?php } ?>
                </form>
        </div>
    </div>
</section>
<?php $this->load->view('footer'); ?>

<div class="scroll-top page-scroll hidden-sm hidden-xs hidden-lg hidden-md">
    <a class="btn btn-primary" href="#page-top">
        <i class="fa fa-chevron-up"></i>
    </a>
</div>