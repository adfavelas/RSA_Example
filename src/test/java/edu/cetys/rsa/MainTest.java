package edu.cetys.rsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void method() {
    }

    @Test
    void getStr() {
    }

    @Test
    void decrypt() {
    }

    @Test
    void euler() {
        int euler = Main.euler(15);
        assertEquals(8,euler);

        euler = Main.euler(32);
        assertEquals(22,euler);

        //euler = Main.euler(15);
        //assertEquals(10,euler);
    }
}