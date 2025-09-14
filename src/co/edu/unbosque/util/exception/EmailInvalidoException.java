package co.edu.unbosque.util.exception;

public class EmailInvalidoException extends Exception {
    public EmailInvalidoException() {
        super("El correo electrónico ingresado no es válido.");
    }
}