package ru.tinkoff.contactapplicationapi.exception;

import org.hibernate.JDBCException;
import org.hibernate.exception.JDBCConnectionException;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.tinkoff.contactapplicationapi.model.Error;
import ru.tinkoff.contactapplicationapi.model.ErrorResponse;
import ru.tinkoff.contactapplicationapi.model.Response;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ContactNotFoundException.class)
    protected ResponseEntity<Response> handleContactNotFoundException() {
        return new ResponseEntity<>(new ErrorResponse(false, new Error(404, "No contacts with that ID")), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ApplicationsNotFoundException.class)
    protected ResponseEntity<Response> handleApplicationsNotFoundException() {
        return new ResponseEntity<>(new ErrorResponse(false, new Error(404, "Contact with this ID have no applications")), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({IllegalArgumentException.class, MethodArgumentTypeMismatchException.class})
    protected ResponseEntity<Response> handleIllegalArgumentException() {
        return new ResponseEntity<>(new ErrorResponse(false, new Error(400, "Wrong Arguments")), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({JDBCException.class, SQLGrammarException.class, JDBCConnectionException.class})
    protected ResponseEntity<Response> handleSQLException() {
        return new ResponseEntity<>(new ErrorResponse(false, new Error(500, "SQL Exception")), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
