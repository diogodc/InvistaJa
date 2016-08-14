<!DOCTYPE html>
<?php 
    session_start();
?>
<html>
    <head>
        <title>INVI$TA JÁ</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="app/css/bovespa.css" type="text/css" rel="stylesheet">
        <style>
            .icon-bar {
                background-color: #fff;
            }
            .icon-bar {
                display: block;
                width: 22px !important;
                height: 2px !important;
                border-radius: 1px;
                margin-top: 2px;
            }
        </style>
    </head>     
    <body  class="bovespa">
         
    </body> 
    <script src="app/js/core.js"></script>
    <script src="app/js/bovespa.js"></script>
    <?php       
        if(isset($_SESSION['user_token'])){
           echo "<token val='{$_SESSION['user_token']}'/>";
        }
    ?>
</html>

