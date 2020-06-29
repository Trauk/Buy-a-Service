package scenes.admin;

import Handler.SceneHandler;
import JSON.JsonClient;
import JSON.JsonSP;
import JSON.JsonUser;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import users.Client;

import java.io.IOException;

public class ViewUserClient
{
    @FXML
    TextField fxUsername,fxEmail,fxFirstName,fxLastName,fxPhone;
    @FXML
    Label fxNameLabel,fxDomainLabel,fxRatingLabel;
    @FXML
    Button fxEditButton,fxApplyButton;
    @FXML
    ComboBox fxDomain;
    protected static Scene scene;
    private JsonClient jc;
    private JsonUser ju;
    private JsonSP jp;
    private String type;
    private static String username;
    private boolean editEnabled = false;

    public static void setUsername(String newUsername)
    {
        username = newUsername;
    }

    public static void InitScene() throws IOException
    {
        SceneHandler.InitScene("ViewUserClient","Profile of " + username);
        //System.out.println(username);
    }

    public void initialize()
    {
        initRoutine();
    }

    public void initRoutine()
    {
        type = SceneHandler.getUsers().getType(username);
        if(type.equals("Client"))
        {
            jc = Client.readClient("data/userData/" +username + "/info.json");
            fxUsername.setText(jc.getUsername());
            fxEmail.setText(jc.getEmail());
            fxFirstName.setText(jc.getFirstName());
            fxLastName.setText(jc.getLastName());
            fxPhone.setText(jc.getPhone());
            fxNameLabel.setText(jc.getFirstName() + " " + jc.getLastName());

        }
    }


    public void backButtonAction() throws IOException
    {
        ManageUsers.InitScene();
        username = null;
    }

    public void editButtonAction()
    {
        editEnabled = !editEnabled;
        fxApplyButton.setDisable(!editEnabled);
        fxEmail.setEditable(editEnabled);
        fxFirstName.setEditable(editEnabled);
        fxLastName.setEditable(editEnabled);
        fxPhone.setEditable(editEnabled);
    }

    public void applyButtonAction()
    {
        jc.setUsername(fxUsername.getText());
        jc.setEmail(fxEmail.getText());
        jc.setFirstName(fxFirstName.getText());
        jc.setLastName(fxLastName.getText());
        jc.setPhone(fxPhone.getText());
        Client.writeClient("data/userData/" +username + "/info.json", jc);
        fxNameLabel.setText(jc.getFirstName() + " " + jc.getLastName());
    }



}
