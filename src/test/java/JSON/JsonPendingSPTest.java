package JSON;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonPendingSPTest
{

    @Test
    void getPending()
    {
        assertEquals(null,new JsonPendingSP().getPending());
    }
}