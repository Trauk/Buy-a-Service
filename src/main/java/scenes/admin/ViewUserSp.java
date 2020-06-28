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
import misc.Domain;
import users.Sp;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewUserSp
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
        SceneHandler.InitScene("ViewUserSp","Profile of " + username);
        //System.out.println(username);
    }

    public void initialize()
    {
        initRoutine();
    }

    public void initRoutine()
    {
        type = SceneHandler.getUsers().getType(username);
        if(type.equals("ServiceProvider"))
        {
            jp = Sp.readSP("data/userData/" +username + "/info.json");
            fxUsername.setText(jp.getUsername());
            fxEmail.setText(jp.getEmail());
            fxFirstName.setText(jp.getFirstName());
            fxLastName.setText(jp.getLastName());
            fxPhone.setText(jp.getPhone());
            fxNameLabel.setText(jp.getFirstName() + " " + jp.getLastName());
            fxDomainLabel.setText(jp.getDomain());
            Domain.updateList();
            fxDomain.getItems().addAll(Domain.getStrList());
            try
            {
                int index = Domain.getIndex(jp.getDomain());
                if(index == -1)
                    fxDomain.getSelectionModel().selectFirst();
                else
                    fxDomain.getSelectionModel().select(index);
            }
            catch(Exception e)
            {};
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
        fxDomain.setDisable(!editEnabled);
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
        jp.setDomain(fxDomain.getValue().toString());
        Sp.writeSP("data/userData/" +username + "/info.json",jp);
        fxNameLabel.setText(jp.getFirstName() + " " + jp.getLastName());
        fxDomainLabel.setText(jp.getDomain());
    }

    public void OpenCertificateButtonAction() throws IOException
    {
        String path = new File("pathFile.txt").getAbsolutePath();
        path = path.substring(0,path.lastIndexOf('\\')+1);
        path = path + jp.getCertificatePath();
        System.out.println(path);
        Desktop.getDesktop().open(new File(path));
    }


}
