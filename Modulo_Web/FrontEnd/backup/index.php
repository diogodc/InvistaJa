<!DOCTYPE html>
<?php
session_start();

class User {

    private $_user;
    private $_password;

    public static function getMember($__user = "", $__password = "") {
        $user = new user();
        $user->_user = $__user;
        $user->_password = $__password;
        return $user;
    }

    public static function getPosted() {
        $user = "";
        $password = "";

        if (isset($_POST['user'])) {
            $user = $_POST['user'];
        }

        if (isset($_POST['password'])) {
            $password = $_POST['password'];
        }

        return \User::getMember($user, $password);
    }

    public static function RestrictedArea() {
        $_SESSION['restricted'] = \User::getMember("restricted", "9g37p 3g%>HI?D9[:d");
        return $_SESSION['restricted'];
    }

    public function user() {
        return $this->_user;
    }

    public function password() {
        return $this->_password;
    }

    public function equals($_object) {
        return $this->_password == $_object->_password && $this->_user == $_object->_user;
    }

}
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

