<?php

defined('BASEPATH') OR exit('No direct script access allowed');
/*
 * Arquivo Configuração de Email
 * @author William Rufino
 * @version 1.0
 */

$config['smtp_host'] = 'ssl://smtp.googlemail.com';
$config['smtp_port'] = 465;
$config['smtp_user'] = 'bruno.ed00@gmail.com';
$config['smtp_pass'] = 'bruno924';
$config['protocol'] = 'smtp';
$config['validate'] = TRUE;
$config['mailtype'] = 'html';
$config['charset'] = 'utf-8';
$config['newline'] = "\r\n";
?>

