package scenes.client;

import Handler.LogInHandler;
import Handler.SceneHandler;
import javafx.scene.Scene;
import scenes.LogSignMenu;

import java.io.IOException;

public class ClientMenu
{
    protected static Scene scene;

    public static void InitScene() throws IOException
    {
        SceneHandler.InitScene("ClientMenu","Client menu");
    }

    public void logOutAction() throws IOException
    {
        LogInHandler.loggedUser = null;
        LogSignMenu.InitScene();
    }

    public void editAccount() throws IOException
    {
        SelfEditClient.InitScene();
    }


}
