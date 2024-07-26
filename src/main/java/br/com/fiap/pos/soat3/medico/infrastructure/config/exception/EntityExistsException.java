package br.com.fiap.pos.soat3.medico.infrastructure.config.exception;

public class EntityExistsException extends RuntimeException {

    public EntityExistsException(String entityName, String id) {
        super(String.format("%s com este identificador [%s] já se encontra presente no banco de dados", entityName, id));
    }
}
