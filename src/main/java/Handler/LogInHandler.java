package Handler;

import scenes.admin.AdminMenu;

import java.io.IOException;

public class LogInHandler
{
    public static void logIn(String username, String type) throws IOException
    {
        if(type.equals("Admin"))
        {
            AdminMenu.InitScene();
        }
    }
}
