package in.hcl.user_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PasswordValidationException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public PasswordValidationException() {
		super();
	}
	
	public PasswordValidationException(String errMsg) {
		super(errMsg);
	}
}
