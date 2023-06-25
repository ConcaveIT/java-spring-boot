package PaymentType.example.PaymentType.handler;
import PaymentType.example.PaymentType.exception.PaymentTypeNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class NotFoundExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = { PaymentTypeNotFoundException.class, PaymentTypeNotFoundException.class })
    protected ResponseEntity<Object> handleConflict(
            PaymentTypeNotFoundException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();

        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}