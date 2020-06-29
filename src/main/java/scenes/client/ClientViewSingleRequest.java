package scenes.client;

import Handler.SceneHandler;
import JSON.JsonClient;
import JSON.JsonRequest;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import users.Client;

import java.io.IOException;

public class ClientViewSingleRequest
{
    @FXML
    Label fxRequestTitle,fxRequestDetails,fxRequestDomain,fxName,fxPhone,fxEmail,fxUsername;
    private static JsonRequest jr;

    public static void InitScene() throws IOException
    {
        SceneHandler.InitScene("ClientViewSingleRequest","View request");
    }

    public void initialize()
    {

        fxRequestTitle.setText(jr.getReqeustTitle());
        fxRequestDetails.setText(jr.getRequestDetails());
        fxRequestDomain.setText(jr.getRequestDomain());


        JsonClient jc = Client.readClient("data/userData/" + jr.getRequestSender() + "/info.json");
        fxUsername.setText(jc.getUsername());
        fxName.setText(jc.getFirstName() + " " + jc.getLastName() + ", ");
        fxPhone.setText(jc.getPhone());
        fxEmail.setText(jc.getEmail());

    }

    public void backButtonAction() throws IOException
    {
        ClientViewRequest.InitScene();
    }

    public static void setJr(JsonRequest obj)
    {
        jr = obj;
    }

}
