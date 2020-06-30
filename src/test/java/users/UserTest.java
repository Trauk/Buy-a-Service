package users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class UserTest
{
    private  static User userTest;
    @BeforeEach
    public void createTestUser() {
        userTest = new User("testJson.json");
    }
    @Test
    void getType()
    {

        assertEquals("Admin",userTest.getType("Admin"));
    }

    @Test
    void userExist()
    {
       assertTrue(userTest.userExist(""));
    }

    @Test
    void comparePassword()
    {
        assertEquals(true,userTest.comparePassword("Admin","Admin"));
        assertEquals(false,userTest.comparePassword("",""));
    }

    @Test
    void encrypt()
    {
        assertEquals("81dc9bdb52d04dc20036dbd8313ed055",User.encrypt("1234"));
    }

}