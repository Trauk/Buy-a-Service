package scenes.client;

import Handler.LogInHandler;
import Handler.SceneHandler;
import scenes.LogSignMenu;

import java.io.IOException;

public class ClientMenu
{

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

    public void requestMenu() throws IOException
    {
        ClientRequestMenu.InitScene();
    }

    public void offerMenu() throws IOException
    {
        ClientViewOffers.InitScene();
    }


}
