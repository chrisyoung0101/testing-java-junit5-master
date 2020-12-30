package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@Tag("model") // TODO : Video 62
class PersonTest implements ModelTests {

    @Test
    void groupedAssertions() {
        //given
        Person person = new Person(1l, "Dog", "Doggy");

        //then
        assertAll("Test Props Set",
                () -> assertEquals("Dog", person.getFirstName()),
                () -> assertEquals( "Doggy", person.getLastName())
                );

    }


    @Test
    void groupedAssertionsMsgs() {
        //given
        Person person = new Person(1l, "Dog", "Doggy");

        //then
        assertAll("Test Props Set",
                () -> assertEquals("Dog", person.getFirstName(), "First Name Failed"),
                () -> assertEquals("Doggy", person.getLastName(),  "Last Name Failed")
        );

    }

    // TODO 66. Repeating tests with JUnit
    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} of {totalRepetitions}") // get these vars aka placeholders by clicking into this annotation and looking at it's code
    @DisplayName("My Repeated test")
    @Test  // this could be dropped I guess because of the @RepeatedTest I guess
    void myRepeatedTest() {
        // TODO - impl
    }

    // TODO : 67. JUnit Test Dependency Injection
    // Here, TestInfo & RepetitionInfo are the dependencies getting  injected
    @RepeatedTest(5)
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {

        System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());

    }

    // TODO : 69 Assignment Review
    // Note : did not finish this.


    @RepeatedTest(value = 5, name = "{displayName} : {currentRepetition} | {totalRepetitions}") // get these vars aka placeholders by clicking into this annotation and looking at it's code
    @DisplayName("My Repeated test")
    void myAssignmentRepeatedTest() {
        //todo impl
    }
}