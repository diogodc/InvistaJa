<?php defined('BASEPATH') OR exit('No direct script access allowed'); ?>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Invista Já!</title>
        <link rel="icon" href="<?php echo base_url("assets/img/favicon.ico") ?>" type="image/x-icon" />

        <!-- Bootstrap Core CSS -->
        <link href="<?php echo base_url("assets/vendor/bootstrap/css/bootstrap.min.css") ?> " rel="stylesheet">

        <!-- Theme CSS -->
        <link href="<?php echo base_url("assets/css/freelancer.min.css") ?>" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="<?php echo base_url("assets/vendor/font-awesome/css/font-awesome.min.css") ?>" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body id="page-top" class="index">

        <!-- Navigation -->
        <nav id="mainNav" class="navbar navbar-default navbar-fixed-top navbar-custom">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <a href="#">
                        <img src="<?php echo base_url("assets/img/logo.png") ?>" alt="">
                    </a>
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                    </button>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="hidden">
                            <a href="#page-top"></a>
                        </li>
                        <li>
                            <a class="page-scroll" href="<?php echo base_url('pagina') ?>">Aprenda a Investir</a>
                        </li>
                        <li>
                            <a class="page-scroll nav-link" href="<?php echo base_url('perfil') ?>">Conheça seu Perfil</a>
                        </li>
                        <li>
                            <a class="page-scroll" href="<?php echo base_url('simulacao') ?>">Faça uma Simulação</a>
                        </li>
                        <li>
                            <a class="page-scroll" href="<?php echo base_url('contato') ?>">Contato</a>
                        </li>
                        <li>
                            <?php if ($this->session->userdata("logado")) { ?>
                                <button style="" class="btn btn-default btn-lg dropdown-toggle" type="button" id="menu1" data-toggle="dropdown"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Minha conta
                                    <span class="caret"></span></button>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="menu1" style="background-color: gray;text-align: right">
                                    <li role="presentation"><a role="menuitem">Olá!</a></li>
                                    <li role="presentation"><a role="menuitem" href="<?php echo base_url('usuario/editar') ?>">Editar</a></li>
                                    <li role="presentation" class="divider"></li>
                                    <li role="presentation"><a href="<?= base_url('login/logout') ?>" class="btn btn-success btn-md">
                                            <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span> Sair
                                        </a></li>
                                </ul>
                            <?php } else { ?>
                                <a href="<?= base_url('login') ?>" class="btn btn-success btn-md">
                                    <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span> Login
                                </a>
                            <?php } ?>
                        </li>    
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>

            <!-- /.container-fluid -->
        </nav>
        <!-- Header -->

