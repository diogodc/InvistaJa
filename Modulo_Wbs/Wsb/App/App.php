<?php

class App {

    static function Guid() {
        if (function_exists('com_create_guid') === true) {
            return trim(com_create_guid(), '{}');
        }

        return sprintf('%04X%04X-%04X-%04X-%04X-%04X%04X%04X', mt_rand(0, 65535), mt_rand(0, 65535), mt_rand(0, 65535), mt_rand(16384, 20479), mt_rand(32768, 49151), mt_rand(0, 65535), mt_rand(0, 65535), mt_rand(0, 65535));
    }

    static function CopySession() {
        $_SESSION["domain"] = $_SESSION["loja"];
        $_SESSION["user_id"] = $_SESSION["usuID"];
    }

    static function SanitizeName($string = '', $is_filename = FALSE) {
        // Replace all weird characters with dashes
        $string = preg_replace('/[^\w\-' . ($is_filename ? '~_\.' : '') . ']+/u', '-', $string);

        // Only allow one dash separator at a time (and make string lowercase)
        return mb_strtolower(preg_replace('/--+/u', '-', $string), 'UTF-8');
    }

    private $routing = null;

    public function Routing() {
        require_once './Library/Router.php';

        if (!$this->routing) {
            $this->routing = new \AnalisarConta\Library\Routing\Router(array(definer_parameter  => "::"));
        }

        return $this->routing;
    }

}