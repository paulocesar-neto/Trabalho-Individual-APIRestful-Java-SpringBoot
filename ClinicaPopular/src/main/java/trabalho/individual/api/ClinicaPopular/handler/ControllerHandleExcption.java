package trabalho.individual.api.ClinicaPopular.handler;



import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import trabalho.individual.api.ClinicaPopular.exception.RecursoNaoEncontradoException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerHandleExcption extends ResponseEntityExceptionHandler {

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
         HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<String> erros = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            erros.add(error.getField() + ": " + error.getDefaultMessage());
        }

        ErrorResposta errorResposta = new ErrorResposta(status.value(),
                "Existem campos inválidos,confira o preenchimento", LocalDateTime.now(),erros);

        return super.handleExceptionInternal(ex, errorResposta, headers, status, request);

    }

    public ResponseEntity<Object> tratarRecursoNaoEncontrado(RecursoNaoEncontradoException ex) {

        ErrorResposta error = new ErrorResposta(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(), LocalDateTime.now(), new ArrayList<>());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }





}
