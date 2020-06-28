package scenes.admin;

import Handler.LogInHandler;
import Handler.SceneHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import scenes.Alert;

import java.io.IOException;

public class SelfEditAdmin
{
    @FXML
    Label fxNameLabel;
    @FXML
    PasswordField fxOldPassword,fxNewPassword;
    public static void InitScene() throws IOException
    {
        SceneHandler.InitScene("SelfEditAdmin","Edit account");
    }

    public void initialize()
    {
        fxNameLabel.setText(LogInHandler.loggedUser);
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
        if(SceneHandler.getUsers().comparePassword(LogInHandler.loggedUser,oldPass) == true)
        {
            SceneHandler.getUsers().setPassword(LogInHandler.loggedUser,newPass);
            SceneHandler.getUsers().writeUser();
            Alert.display("Success","Password changed successfully!");
            fxOldPassword.setText("");
            fxNewPassword.setText("");
        }
        else
        {
            Alert.display("Error","Old password is incorrect!");
        }
    }

    public void backButtonAction() throws IOException
    {
        AdminMenu.InitScene();
    }


}
