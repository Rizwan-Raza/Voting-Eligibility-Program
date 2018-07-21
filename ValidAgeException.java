package rex.vote;
class ValidAgeException extends Exception {
	ValidAgeException() {
		super("You are in.");
	}
	ValidAgeException(String msg) {
		super(msg);
	}
}