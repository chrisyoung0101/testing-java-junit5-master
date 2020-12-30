package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.CustomArgsProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Tag("model") // TODO : Video 62
class OwnerTest {
    @DisplayName("This will print in the test results.  Give something a mean")
    @Test
    void dependentAssertions() {

        Owner owner = new Owner(1l, "Dog", "Doggy");
        owner.setCity("Key West");
        owner.setTelephone("5552221111");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Dog", owner.getFirstName(), "First Name did not match"),
                        () -> assertEquals("Doggy", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Key West", owner.getCity(), "City did not match"),
                        () -> assertEquals("5552221111", owner.getTelephone())
                ));

        // TODO : Video 57 : Using Hamcrest with JUnit
        // not as robust as AssertJ but been around longer
        // Hamcrest is used in legacy code
        assertThat(owner.getCity(), is("Key West"));
    }


    // TODO 70. JUnit Parameterized Tests - Value Source
    @DisplayName("Value Source Test - ") // TODO 71. Unit Parameterized Tests - Display Name
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Looping", "Over", "This", "Array", "of", "Values", "To Use In Our Test"})
    void testValueSource(String val) {

        System.out.println(val);
    }

    // TODO 72. Unit Parameterized Tests - ENUM Source
    @DisplayName("Enum Source Test - ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {

        //Iterates over each value withing the ENUM file OwnerType.java
        //Each ENUM value gets it's own test run
        System.out.println(ownerType);

    }


    // TODO 73. Unit Parameterized Tests - CSV Source
    @DisplayName("CSV Input Test - ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource({
            "Fl, 1, 2",
            "OH, 2, 2",
            "MI, 3, 1"
    })
    void csvInputTest(String stateName, int val1, int val2) {

        System.out.println(stateName + " = " + val1 + ":" + val2);

    }


    // TODO 74. Unit Parameterized Tests - CSV File Source
    @DisplayName("CSV From File Test - ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    // CSV file is in test/resources directory
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1) //skip the header on the .csv
    void csvFromFileTest(String stateName, int val1, int val2) {

        System.out.println(stateName + " = " + val1 + ":" + val2);

    }


    // TODO 75. Unit Parameterized Tests - Method Provider
    @DisplayName("Method Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("getargs")
    void fromMethodTest(String stateName, int val1, int val2) {

        System.out.println(stateName + " = " + val1 + ":" + val2);

    }


    //Provider method for above method test
    static Stream<Arguments> getargs() {
        return Stream.of(Arguments.of("Fl", 5, 1), Arguments.of("OH", 2, 8), Arguments.of("MI", 3, 5));
    }

    // TODO 76. Unit Parameterized Tests - Custom Provider
    @DisplayName("Custom Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ArgumentsSource(CustomArgsProvider.class)
    void fromCustomProviderTest(String stateName, int val1, int val2) {

        System.out.println(stateName + " = " + val1 + ":" + val2);

    }



}