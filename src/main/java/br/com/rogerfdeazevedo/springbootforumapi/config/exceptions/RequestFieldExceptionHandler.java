package br.com.rogerfdeazevedo.springbootforumapi.config.exceptions;

import br.com.rogerfdeazevedo.springbootforumapi.dto.OutRequestFieldExceptionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RequestFieldExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<OutRequestFieldExceptionDTO> handle(MethodArgumentNotValidException exception){
        List<OutRequestFieldExceptionDTO> outList = new ArrayList<>();
        exception.getFieldErrors().forEach(e -> {
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            outList.add(new OutRequestFieldExceptionDTO(e.getField(), message));
        });
        return outList;
    }

}
