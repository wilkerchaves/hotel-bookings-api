package app.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(exception = InvalidEnumArgumentException.class)
	public ProblemDetail handleInvalidEnumArgException(InvalidEnumArgumentException e) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
		problemDetail.setTitle("Invalid enum argmuent");
		problemDetail.setProperty("timestamp", Instant.now());
		return problemDetail;
	}
	
	@ExceptionHandler(exception = ResourceAlreadyExistsException.class)
	public ProblemDetail handleResourceAlreadyExistsException(ResourceAlreadyExistsException e) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, e.getMessage());
		problemDetail.setTitle("Resource already exists");
		problemDetail.setProperty("timestamp", Instant.now());
		return problemDetail;
	}



}
