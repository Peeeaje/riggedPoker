package com.peeeaje;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class BlindTest {

    @Test
    void throwExceptionWhenSmallBlindIsNotSet() {
        Blind.reset();

        Throwable exception = assertThrows(IllegalStateException.class, () -> {
            Blind.smallBlind();
        });
        assertEquals("Small blind has not been set", exception.getMessage());
    }

    @Test
    void throwExceptionWhenBigBlindIsNotSet() {
        Blind.reset();

        Throwable exception = assertThrows(IllegalStateException.class, () -> {
            Blind.bigBlind();
        });
        assertEquals("Big blind has not been set", exception.getMessage());
    }

    @Test
    void testBBandSB() {
        Blind.reset();
        Blind.setBlinds(10, 20);
        assertEquals(10, Blind.smallBlind());
        assertEquals(20, Blind.bigBlind());
    }

}
