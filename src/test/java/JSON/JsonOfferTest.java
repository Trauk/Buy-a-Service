package JSON;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonOfferTest
{

    private static JsonOffer jo;

    @BeforeEach
   void initJo()
    {
        JsonOffer jo = new JsonOffer();
    }


    @Test
    void getSender()
    {
        assertEquals(null,jo.getSender());
    }

    @Test
    void getDomain()
    {
        assertEquals(null,jo.getDomain());
    }

    @Test
    void getDetails()
    {
        assertEquals(null,jo.getDetails());
    }

    @Test
    void getTitle()
    {
        assertEquals(null,jo.getTitle());
    }
}