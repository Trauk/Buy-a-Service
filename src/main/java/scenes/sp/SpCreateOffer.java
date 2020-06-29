package scenes.sp;

import Handler.LogInHandler;
import Handler.SceneHandler;
import JSON.JsonSP;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import misc.Offer;
import scenes.Alert;
import users.Sp;

import java.io.IOException;

public class SpCreateOffer
{
    @FXML
    TextField fxTitle;
    @FXML
    TextArea fxDetails;
    public static void InitScene() throws IOException
    {
        SceneHandler.InitScene("SpCreateOffer","Sp offer");
    }

    public void backButtonAction() throws IOException
    {
        SpOfferMenu.InitScene();
    }

    public void initialize()
    {
        initRoutine();
    }

    public void initRoutine()
    {
        Offer.updateList();
    }

    public void createOffer()
    {
        JsonSP jp = Sp.readSP("data/userData/" + LogInHandler.loggedUser + "/info.json");
        String title = fxTitle.getText();
        String details = fxDetails.getText();
        String domain = jp.getDomain();
        if(title == null || details == null || title.equals("") || details.equals(""))
        {
            Alert.display("Error","You cannot leave a field empty!");
            return;
        }
        if(Offer.exists(domain,title))
        {
            Alert.display("Error","Title already in use!");
            return;
        }
        Offer.addElement(domain, LogInHandler.loggedUser, details, title);
        Alert.display("Success","Offer created successfully!");

    }


}
