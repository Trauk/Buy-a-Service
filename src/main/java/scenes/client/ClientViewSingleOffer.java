package scenes.client;

import Handler.SceneHandler;
import JSON.JsonOffer;
import JSON.JsonSP;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import users.Sp;

import java.io.IOException;

public class ClientViewSingleOffer
{
    @FXML
    Label fxRequestTitle,fxRequestDetails,fxRequestDomain,fxName,fxPhone,fxEmail,fxUsername;
    private static JsonOffer jr;

    public static void InitScene() throws IOException
    {
        SceneHandler.InitScene("ClientViewSingleOffer","View offer");
    }

    public void initialize()
    {

        fxRequestTitle.setText(jr.getTitle());
        fxRequestDetails.setText(jr.getDetails());
        fxRequestDomain.setText(jr.getDomain());


        JsonSP jc = Sp.readSP("data/userData/" + jr.getSender() + "/info.json");
        fxUsername.setText(jc.getUsername());
        fxName.setText(jc.getFirstName() + " " + jc.getLastName() + ", ");
        fxPhone.setText(jc.getPhone());
        fxEmail.setText(jc.getEmail());

    }

    public void backButtonAction() throws IOException
    {
        ClientViewOffers.InitScene();
    }

    public static void setJr(JsonOffer obj)
    {
        jr = obj;
    }

}
