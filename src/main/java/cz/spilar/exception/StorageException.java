package cz.spilar.exception;

public class StorageException extends RuntimeException {

    public static final String INITIAL_FILE_EXTENSION_ERROR = "Unsupported file type. Only .txt files are allowed.";
    public static final String INITIAL_FILE_NOT_FOUND_ERROR = "Initial file has not been found.";

    public StorageException(String message) {
        super(message);
    }
}
