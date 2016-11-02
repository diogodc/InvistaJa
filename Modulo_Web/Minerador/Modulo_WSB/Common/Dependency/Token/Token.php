<?php

namespace Common\Dependency\Token;

class Token {

    private $_secret;

    public function __construct() {
        $this->_secret = '-5391acc5a8acc02';
    }

    private function encrypt($sValue, $sSecretKey) {
        return rtrim(
                base64_encode(
                        mcrypt_encrypt(
                                MCRYPT_RIJNDAEL_256, $sSecretKey, $sValue, MCRYPT_MODE_ECB, mcrypt_create_iv(
                                        mcrypt_get_iv_size(
                                                MCRYPT_RIJNDAEL_256, MCRYPT_MODE_ECB
                                        ), MCRYPT_RAND)
                        )
                ), "\0"
        );
    }

    private function decrypt($sValue, $sSecretKey) {
        return rtrim(
                mcrypt_decrypt(
                        MCRYPT_RIJNDAEL_256, $sSecretKey, base64_decode($sValue), MCRYPT_MODE_ECB, mcrypt_create_iv(
                                mcrypt_get_iv_size(
                                        MCRYPT_RIJNDAEL_256, MCRYPT_MODE_ECB
                                ), MCRYPT_RAND
                        )
                ), "\0"
        );
    }

    public function newToken($string) {
        return $this->encrypt($string, $this->_secret);
    }

    public function decToken($string) {
        return $this->decrypt($string, $this->_secret);
    }

}
