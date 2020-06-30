package scenes.client;

import Handler.LogInHandler;
import Handler.SceneHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import misc.Domain;
import misc.Request;
import scenes.Alert;

import java.io.IOException;

public class CreateRequest
{
    @FXML
    ComboBox fxDomain;
    @FXML
    TextField fxTitle;
    @FXML
    TextArea fxDetails;
    public static void InitScene() throws IOException
    {
        SceneHandler.InitScene("CreateRequest","Client request");
    }

    public void backButtonAction() throws IOException
    {
        ClientRequestMenu.InitScene();
    }

    public void initialize()
    {
        initRoutine();
    }

    public void initRoutine()
    {
        Request.updateList();
        Domain.updateList();
        fxDomain.getItems().addAll(Domain.getStrList());
        fxDomain.getSelectionModel().selectFirst();
    }

    public void createRequestAction()
    {
        String title = fxTitle.getText();
        String details = fxDetails.getText();
        String domain = fxDomain.getValue().toString();
        if(title == null || details == null || title.equals("") || details.equals(""))
        {
            Alert.display("Error","You cannot leave a field empty!");
            return;
        }
        if(Request.exists(domain,title))
        {
            Alert.display("Error","Title already in use!");
            return;
        }
        Request.addElement(domain, LogInHandler.loggedUser, details, title);
        Alert.display("Success","Request created successfully!");

    }


}

