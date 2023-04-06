package ru.myappco.SpringBoot.Task1.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.myappco.SpringBoot.Task1.exception.InvalidCredentials;
import ru.myappco.SpringBoot.Task1.exception.UnauthorizedUser;

@RestControllerAdvice()
public class ExceptionHandlerAdvice {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentialsHandler(InvalidCredentials ic) {
        return new ResponseEntity<>(ic.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedHandler(UnauthorizedUser uu) {
        System.out.println(uu.getMessage());
        return new ResponseEntity<>(uu.getMessage(), HttpStatus.FORBIDDEN);
    }



}
