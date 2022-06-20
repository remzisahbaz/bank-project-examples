package com.example.junitinjava.service.test;

import com.example.junitinjava.model.TolkienCharacter;
import com.example.junitinjava.service.DataService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.example.junitinjava.model.Race.HOBBIT;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class ServiceTest {


    // TODO initialize before each test
    DataService dataService;

    @Test
    void ensureThatInitializationOfTolkeinCharactorsWorks() {
        TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, HOBBIT);

        // TODO check that age is 33
        // TODO check that name is "Frodo"
        // TODO check that name is not "Frodon"
        fail("not yet implemented");
    }

    @Test
    void ensureThatEqualsWorksForCharaters() {
        Object jake = new TolkienCharacter("Jake", 43, HOBBIT);
        Object sameJake = jake;
        Object jakeClone = new TolkienCharacter("Jake", 12, HOBBIT);
        // TODO check that:
        // jake is equal to sameJake
        // jake is not equal to jakeClone
        fail("not yet implemented");
    }

    @Test
    void checkInheritance() {
        TolkienCharacter tolkienCharacter = dataService.getFellowship().get(0);
        // TODO check that tolkienCharacter.getClass is not a movie class
        fail("not yet implemented");
    }

    @Test
    void ensureFellowShipCharacterAccessByNameReturnsNullForUnknownCharacter() {
        // TODO imlement a check that dataService.getFellowshipCharacter returns null for an
        // unknow felllow, e.g. "Lars"
        fail("not yet implemented");
    }

    @Test
    void ensureFellowShipCharacterAccessByNameWorksGivenCorrectNameIsGiven() {
        // TODO imlement a check that dataService.getFellowshipCharacter returns a fellow for an
        // existing felllow, e.g. "Frodo"
        fail("not yet implemented");
    }


    @Test
    void ensureThatFrodoAndGandalfArePartOfTheFellowsip() {

        List<TolkienCharacter> fellowship = dataService.getFellowship();

        // TODO check that Frodo and Gandalf are part of the fellowship
        fail("not yet implemented");
    }

    @Test
    void ensureThatOneRingBearerIsPartOfTheFellowship() {

        List<TolkienCharacter> fellowship = dataService.getFellowship();

        // TODO test that at least one ring bearer is part of the fellowship
        fail("not yet implemented");
    }

    // TODO Use @RepeatedTest(int) to execute this test 1000 times
    @Test
    @Tag("slow")
    @DisplayName("Minimal stress testing: run this test 1000 times to ")
    void ensureThatWeCanRetrieveFellowshipMultipleTimes() {
        dataService = new DataService();
        assertNotNull(dataService.getFellowship());
        fail("this should run 1000 times");
    }

    @Test
    void ensureOrdering() {
        List<TolkienCharacter> fellowship = dataService.getFellowship();

        // ensure that the order of the fellowship is:
        // frodo, sam, merry,pippin, gandalf,legolas,gimli,aragorn,boromir
        fail("not yet implemented");
    }

    @Test
    void ensureAge() {
        List<TolkienCharacter> fellowship = dataService.getFellowship();

        // TODO test ensure that all hobbits and men are younger than 100 years

        // TODO also ensure that the elfs, dwars the maia are all older than 100 years
        fail("not yet implemented");

        // HINT fellowship.stream might be useful here
    }

    @Test
    void ensureThatFellowsStayASmallGroup() {

        List<TolkienCharacter> fellowship = dataService.getFellowship();

        // TODO Write a test to get the 20 element from the fellowship throws an
        // IndexOutOfBoundsException
        fail("not yet implemented");
    }

}