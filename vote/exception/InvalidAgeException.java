package rex.vote;
class InvalidAgeException extends Exception {
	InvalidAgeException() {
		super("Invalid Age, You should wait for Eligible to Vote");
	}
	InvalidAgeException(String msg) {
		super(msg);
	}
}