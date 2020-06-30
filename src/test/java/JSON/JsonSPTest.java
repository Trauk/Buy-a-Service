package JSON;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonSPTest
{
    private static JsonSP js;
    @BeforeEach
    void createObj()
    {
        js = new JsonSP();
    }
    @Test
    void getUsername()
    {
        assertEquals(null,js.getUsername());
    }

    @Test
    void getPassword()
    {
        assertEquals(null,js.getPassword());
    }

    @Test
    void getType()
    {
        assertEquals(null,js.getType());
    }

    @Test
    void getEmail()
    {
        assertEquals(null,js.getEmail());
    }

    @Test
    void getFirstName()
    {
        assertEquals(null,js.getFirstName());
    }

    @Test
    void getLastName()
    {
        assertEquals(null,js.getLastName());
    }

    @Test
    void getPhone()
    {
        assertEquals(null,js.getPhone());
    }

    @Test
    void getInfoPath()
    {
        assertEquals(null,js.getInfoPath());
    }

    @Test
    void getDomain()
    {
        assertEquals(null,js.getDomain());
    }

    @Test
    void getApproved()
    {
        assertEquals("pending",js.getApproved());
    }

    @Test
    void getCertificatePath()
    {
        assertEquals(null,js.getCertificatePath());
    }
}