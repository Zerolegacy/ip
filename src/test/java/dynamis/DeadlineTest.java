package dynamis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {
    @Test
    public void stringDateTest(){
        assertEquals("[D][ ] Test (by: today)", new Deadline("Test", "today").toString());
    }

    @Test
    public void objDateTest(){
        assertEquals("[D][ ] Test (by: Jan 1 2025)", new Deadline("Test", "2025-01-01").toString());
    }
}
