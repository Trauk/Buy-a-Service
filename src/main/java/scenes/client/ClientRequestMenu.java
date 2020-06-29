package scenes.client;

import Handler.SceneHandler;

import java.io.IOException;

public class ClientRequestMenu
{
    public static void InitScene() throws IOException
    {
        SceneHandler.InitScene("ClientRequestMenu","Client request menu");
    }

    public void backButtonAction() throws IOException
    {
        ClientMenu.InitScene();
    }

    public void createRequest() throws IOException
    {
        CreateRequest.InitScene();
    }

    public void viewRequest() throws IOException
    {
        CreateRequest.InitScene();
    }
}
