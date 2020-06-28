package scenes.sp;

import Handler.LogInHandler;
import Handler.SceneHandler;
import JSON.JsonSP;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import scenes.Alert;
import users.Sp;
import users.User;

import java.io.IOException;

public class SelfEditSP
{
    @FXML
    TextField fxUsername,fxEmail,fxFirstName,fxLastName,fxPhone;
    @FXML
    Label fxNameLabel,fxDomainLabel;
    @FXML
    Button fxEditButton,fxApplyButton;
    @FXML
    ComboBox fxDomain;
    @FXML
    PasswordField fxOldPassword,fxNewPassword;
    protected static Scene scene;
    private JsonSP jp;
    private static String username;
    private boolean editEnabled = false;

    public static void InitScene() throws IOException
    {
        SceneHandler.InitScene("SelfEditSP","Edit profile");
        //System.out.println(username);
    }

    public void initialize()
    {
        initRoutine();
    }

    public void initRoutine()
    {
        username = LogInHandler.loggedUser;
        jp = Sp.readSP("data/userData/" +username + "/info.json");
        fxUsername.setText(jp.getUsername());
        fxEmail.setText(jp.getEmail());
        fxFirstName.setText(jp.getFirstName());
        fxLastName.setText(jp.getLastName());
        fxPhone.setText(jp.getPhone());
        fxNameLabel.setText(jp.getFirstName() + " " + jp.getLastName());
    }


    public void backButtonAction() throws IOException
    {
        SPMenu.InitScene();
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
        jp.setUsername(fxUsername.getText());
        jp.setEmail(fxEmail.getText());
        jp.setFirstName(fxFirstName.getText());
        jp.setLastName(fxLastName.getText());
        jp.setPhone(fxPhone.getText());
        Sp.writeSP("data/userData/" +username + "/info.json",jp);
        fxNameLabel.setText(jp.getFirstName() + " " + jp.getLastName());
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
            jp.setPassword(User.encrypt(newPass));
            Sp.writeSP("data/userData/" +username + "/info.json",jp);
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
