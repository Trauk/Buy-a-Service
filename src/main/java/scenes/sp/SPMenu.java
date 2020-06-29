package scenes.sp;

import Handler.LogInHandler;
import Handler.SceneHandler;
import javafx.scene.Scene;
import scenes.LogSignMenu;

import java.io.IOException;

public class SPMenu
{
    protected static Scene scene;

    public static void InitScene() throws IOException
    {
        SceneHandler.InitScene("SPMenu","Service provider menu");
    }

    public void logOutAction() throws IOException
    {
        LogInHandler.loggedUser = null;
        LogSignMenu.InitScene();
    }

    public void editAccount() throws IOException
    {
        SelfEditSP.InitScene();
    }

    public void viewRequests() throws IOException
    {
        SpViewRequests.InitScene();
    }

    public void offerMenu() throws IOException
    {
        SpOfferMenu.InitScene();
    }


}
