package model;

public class Autenticador {

    public String autentica(String login, String senha) throws Exception {
        if (!login.equals("admin"))
            throw new Exception("erro");
        return "Admin";
    }
}
