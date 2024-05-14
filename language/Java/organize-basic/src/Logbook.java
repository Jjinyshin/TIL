import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.Collections;

public class Logbook {
    void wirteMessage(String message, Path location) throws IOException {
//        인수를 검증할 때는 순서가 중요한데, 반드시 null을 먼저 확인한 후 도메인에 따라 "유효하지 않은" 값을 검사해야 한다.
//        메서드 서명 내 인수 순서에 따라 확인하도록 순서 변경
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("The message is invalid");
        }
        if (location == null || Files.isDirectory(location)) {
            throw new IllegalArgumentException("The path is invalid");
        }
        String entry = LocalDate.now() + ": " + message;
        Files.write(location, Collections.singletonList(entry),
                StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }
}
