package cz.spilar.validator;

import cz.spilar.exception.StorageException;

import java.io.File;

public class FileValidator {

    public static void validateFileExtension(File file, String extension) throws StorageException {
        String fileName = file.getName().toUpperCase();
        if (!fileName.endsWith(extension.toUpperCase())) {
            throw new StorageException(StorageException.INITIAL_FILE_EXTENSION_ERROR);
        }
    }
}
