package JSON;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonUserTest
{
    private static JsonUser ju;
    @BeforeEach
    void initObj()
    {
        ju = new JsonUser();
    }
    @Test
    void getUsername()
    {
        assertEquals(null,ju.getUsername());
    }

    @Test
    void getPassword()
    {
        assertEquals(null,ju.getPassword());
    }

    @Test
    void getType()
    {
        assertEquals(null,ju.getType());
    }
}