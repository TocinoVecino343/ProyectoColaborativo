package co.edu.unbosque.util.exception;

import co.edu.unbosque.model.persistence.UsuarioDAO;

public class LanzadorExcepciones {

    public static void validarEmail(String email) throws EmailInvalidoException {
        if (email == null || email.trim().isEmpty() || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new EmailInvalidoException();
        }
    }

    public static void verificarEmailNoRegistrado(String email) throws EmailYaRegistradoException {
        UsuarioDAO dao = new UsuarioDAO();
        if (dao.existeCorreo(email)) {
            throw new EmailYaRegistradoException();
        }
    }
}