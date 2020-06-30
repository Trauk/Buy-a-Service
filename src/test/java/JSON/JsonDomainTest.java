package JSON;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonDomainTest
{

    @Test
    void getDomain()
    {
        JsonDomain jd = new JsonDomain();
        assertEquals(null,jd.getDomain());
        jd.setDomain("test");
        assertEquals("test",jd.getDomain());
    }
}