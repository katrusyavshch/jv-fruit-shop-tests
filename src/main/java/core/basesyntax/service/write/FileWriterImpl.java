package core.basesyntax.service.write;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(Path filePath, String data) {
        if (filePath == null || data == null || data.isEmpty()) {
            throw new IllegalArgumentException("File path and data cannot be null or empty");
        }
        try {
            Files.write(filePath, data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Error writing the file: " + filePath, e);
        }
    }
}
