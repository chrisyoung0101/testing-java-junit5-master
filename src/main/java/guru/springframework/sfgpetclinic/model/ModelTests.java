package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;

@Tag("model")
public interface ModelTests {

    @BeforeEach
    default void beforeEachConsoleOutputer(){
        System.out.println("Running Test -");
    }
}
