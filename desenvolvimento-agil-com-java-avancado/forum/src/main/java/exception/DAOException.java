package exception;

public class DAOException extends Exception {

    public DAOException(String mensagem, Exception exception) {
        super(mensagem, exception);
    }
}
