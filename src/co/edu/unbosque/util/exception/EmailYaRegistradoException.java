package co.edu.unbosque.util.exception;

public class EmailYaRegistradoException extends Exception {
    public EmailYaRegistradoException() {
        super("Este correo electrónico ya está registrado.");
    }
}