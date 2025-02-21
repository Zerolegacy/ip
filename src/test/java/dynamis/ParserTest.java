package Dynamis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    @Test
    public void serialiseTest(){
        Parser p = new Parser();
        assertEquals("T | 0 | lmoa", p.serialiseTask(new Todo("lmoa")));
    }

    @Test
    public void deserialiseTest(){
        Parser p = new Parser();
        assertEquals(new Todo("test"), p.deserializeTask("T | 0 | test"));
    }
}
