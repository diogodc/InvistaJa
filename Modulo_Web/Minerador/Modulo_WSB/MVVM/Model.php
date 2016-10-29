<?php

namespace Model;

require_once __DIR__ . '/../Common/Contract/DataConnection/ContractDataConnection.php';

class Model extends \Common\Contract\DataConnection\ConnectionOracle {
    
}

class ModelSession {
    
}

class ModelUser extends Model {

    public function get_byCredentials($credentials) {
        $connection  = $this->connection();
        
        $query_string_exists_user = "If Exists(Select [user].id From [dbo].[USUARIO] [user] Where [user].usu = @user)"
                . "                   Begin"
                . "                         Set @cond = 1;"
                . "                   End ";

        $query_string_exists = "If Exists(Select [user].id From [dbo].[USUARIO] [user] Where [user].usu = @user And [user].senha = @password)"
                . "              Begin"
                . "                        Set @cond = 3;"
                . "                        Select @user_id = [user].id,"
                . "                               @user_name= [user].NOMEFUNC"
                . "                        From [dbo].[USUARIO] [user] "
                . "                        Where [user].usu = @user "
                . "                        And [user].senha = @password"
                . "              End ";

        $query_string = "Declare @cond as Int,"
                . "              @user_id as Int,"
                . "              @user_name as Varchar(200)"
                . "              "
                . "      Declare @user as Varchar(20),"
                . "              @password as Varchar(15)"
                . "              "
                . "      Set @cond = 2;"
                . "      Set @user_id = 0;"
                . "      Set @user_name = ''; "
                . "      Set @user  = '{$credentials->username}';"
                . "      Set @password  = '{$credentials->password}';"
                . "      " . $query_string_exists_user . $query_string_exists
                . "      Select @cond cond,"
                . "             @user_id user_id,"
                . "             @user_name user_name ";
        return $connection->executeQuery($query_string);
    }

}
