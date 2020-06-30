package JSON;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonRequestTest
{
    private static JsonRequest jr;
    @BeforeEach
    void initObj()
    {
        jr = new JsonRequest();
        jr.setReqeustTitle("test");
        jr.setRequestSender("test");
        jr.setRequestDetails("test");
        jr.setRequestDomain("test");
    }
    @Test
    void getRequestSender()
    {
        assertEquals("test",jr.getRequestSender());
    }

    @Test
    void getRequestDomain()
    {
        assertEquals("test",jr.getRequestDomain());
    }

    @Test
    void getRequestDetails()
    {
        assertEquals("test",jr.getRequestDetails());
    }

    @Test
    void getReqeustTitle()
    {
        assertEquals("test",jr.getReqeustTitle());
    }
}