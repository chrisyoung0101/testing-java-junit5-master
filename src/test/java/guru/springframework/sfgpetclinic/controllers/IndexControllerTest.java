package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.awt.*;
import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;


@Tag("controller") // TODO : Video 62 Tagging and Filtering JUnit Tests
                    // Run>Edit Configurations > create new JUnit, we created Controllers Test and Model Test
                    // You can run, say, Model Test and only those annotated tests will be run.

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }


    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong View Returned");
        //lambda expression here gets executed when this assertion fails
        assertEquals("index", controller.index(), () -> "Another expensive message");

        //assertJ assertions
        //see notes below
        assertThat(controller.index()).isEqualTo("index");
    }

    //Testing if an exception was thrown
    //If exception is no thrown, this test will fail
    @Test
    @DisplayName("Test Exception")
    void oopsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            controller.oopsHandler();
        });
    }

    //assertTimeout runs in the same thread so maybe use this one first as
    //testTimeOutPrempt does not run in the same thread and behaves differently
    @Disabled("Demo of timeout")
    @Test
    void testTimeOut() {

        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);

            System.out.println("testTimeOut");
        });

    }

    //
    @Disabled("Demo of timeout")
    @Test
    void testTimeOutPrempt() {

        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);

            System.out.println("testTimeOutPrempt");
        });

    }

    /////////////
    //Assumptions Video 54

    //Assumptions don't fail the test they abort the test

    //Will fail and this test will essentially get marked as ignored

    @Test
    void testAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    //Runs good
    @Test
    void testAssumptionTrueAssumptionIsTrue() {
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }

    ////////////////

    //Conditional JUnit Test Execution Video 55

    //@EnabledOnOs(OS.MAC) passes on a MAC but would get ignored on Windows

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows() {
    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {
    }

    //using environment variables
    // on the cli, run "echo $USER" to get your username which is an env var
    //Runs good
    @EnabledIfEnvironmentVariable(named = "USER", matches = "chrisyoung")
    @Test
    void testIfUserChrisYoung() {

    }

    //Does not run good
    @EnabledIfEnvironmentVariable(named = "USER", matches = "fred")
    @Test
    void testIfUserFred() {
    }

    /////

    //56. Using AssertJ with JUnit
    // alternate assertions library
    // add as dependency in maven or gradle






}