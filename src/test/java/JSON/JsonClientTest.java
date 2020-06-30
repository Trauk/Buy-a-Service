package JSON;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class JsonClientTest
{

    private static JsonClient jc;
    @BeforeEach
    void createObj()
    {
       jc = new JsonClient();
       jc.setUsername("test");
       jc.setPassword("test");
       jc.setType("test");
       jc.setEmail("test");
       jc.setFirstName("test");
       jc.setLastName("test");
       jc.setPhone("test");
       jc.setInfoPath("test");
    }
    @org.junit.jupiter.api.Test
    void getUsername()
    {
        assertEquals("test",jc.getUsername());
    }

    @org.junit.jupiter.api.Test
    void getPassword()
    {
        assertEquals("test",jc.getPassword());
    }

    @org.junit.jupiter.api.Test
    void getType()
    {
        assertEquals("test",jc.getType());
    }

    @org.junit.jupiter.api.Test
    void getEmail()
    {
        assertEquals("test",jc.getEmail());
    }

    @org.junit.jupiter.api.Test
    void getFirstName()
    {
        assertEquals("test",jc.getFirstName());
    }

    @org.junit.jupiter.api.Test
    void getLastName()
    {
        assertEquals("test",jc.getLastName());
    }

    @org.junit.jupiter.api.Test
    void getPhone()
    {
        assertEquals("test",jc.getPhone());
    }

    @org.junit.jupiter.api.Test
    void getInfoPath()
    {
        assertEquals("test",jc.getInfoPath());
    }
}