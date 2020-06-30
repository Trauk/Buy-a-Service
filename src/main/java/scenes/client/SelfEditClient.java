package scenes.client;

import Handler.LogInHandler;
import Handler.SceneHandler;
import JSON.JsonClient;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import scenes.Alert;
import users.Client;
import users.User;

import java.io.IOException;

public class SelfEditClient
{
    @FXML
    TextField fxUsername,fxEmail,fxFirstName,fxLastName,fxPhone;
    @FXML
    Label fxNameLabel,fxDomainLabel;
    @FXML
    Button fxEditButton,fxApplyButton;
    @FXML
    PasswordField fxOldPassword,fxNewPassword;
    protected static Scene scene;
    private JsonClient jc;
    private static String username;
    private boolean editEnabled = false;

    public static void InitScene() throws IOException
    {
        SceneHandler.InitScene("SelfEditClient","Edit profile");
    }

    public void initialize()
    {
        initRoutine();
    }

    public void initRoutine()
    {
        username = LogInHandler.loggedUser;
        jc = Client.readClient("data/userData/" +username + "/info.json");
        fxUsername.setText(jc.getUsername());
        fxEmail.setText(jc.getEmail());
        fxFirstName.setText(jc.getFirstName());
        fxLastName.setText(jc.getLastName());
        fxPhone.setText(jc.getPhone());
        fxNameLabel.setText(jc.getFirstName() + " " + jc.getLastName());
    }


    public void backButtonAction() throws IOException
    {
        ClientMenu.InitScene();
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


    public void changePasswordButtonAction()
    {
        String oldPass = fxOldPassword.getText();
        String newPass =fxNewPassword.getText();
        if(oldPass == null || newPass == null || oldPass.equals("") || newPass.equals(""))
        {
            Alert.display("Error","Fields cannot be left empty!");
            return;
        }
        if(oldPass.equals(newPass))
        {
            Alert.display("Error","Old pass and new pass cannot be the same!");
            return;
        }
        if(SceneHandler.getUsers().comparePassword(LogInHandler.loggedUser, oldPass))
        {
            SceneHandler.getUsers().setPassword(LogInHandler.loggedUser,newPass);
            SceneHandler.getUsers().writeUser();
            jc.setPassword(User.encrypt(newPass));
            Client.writeClient("data/userData/" +username + "/info.json",jc);
            Alert.display("Success","Password changed successfully!");
            fxOldPassword.setText("");
            fxNewPassword.setText("");
        }
        else
        {
            Alert.display("Error","Old password is incorrect!");
        }
    }


}
