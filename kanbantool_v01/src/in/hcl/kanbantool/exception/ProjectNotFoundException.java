package in.hcl.kanbantool.exception;

public class ProjectNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProjectNotFoundException() {
		super();
	}
	
	public ProjectNotFoundException(String errMsg) {
		super(errMsg);
	}
	
}
