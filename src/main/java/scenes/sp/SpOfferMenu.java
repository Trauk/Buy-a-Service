package scenes.sp;

import Handler.SceneHandler;

import java.io.IOException;

public class SpOfferMenu
{
    public static void InitScene() throws IOException
    {
        SceneHandler.InitScene("SpOfferMenu","Client request menu");
    }

    public void backButtonAction() throws IOException
    {
        SPMenu.InitScene();
    }

    public void createOffer() throws IOException
    {
        SpCreateOffer.InitScene();
    }

    public void viewOffer() throws IOException
    {
        SpViewOffers.InitScene();
}
}
