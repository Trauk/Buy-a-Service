package scenes;

import Handler.SceneHandler;
import JSON.JsonSP;
import JSON.JsonUser;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import misc.Domain;
import users.Sp;
import users.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class SPSign extends LogSignMenu
{
    private File file;
    private String selectedFilePath = "";
    private boolean fileSelected = false;
    @FXML
    public PasswordField passField;
    //private static Object LogIn;
    @FXML
    public Button signButton,backButton;
    @FXML
    public TextField userField,emailField,firstNameField,lastNameField,phoneField;
    @FXML
    public ComboBox domainCombo;
    @FXML
    public Label fileLabel;
    public static void InitScene() throws IOException
    {
        LogSignMenu.type = "ServiceProvider";
        SceneHandler.InitScene("SPSign","Sign up as service provider");
    }
    public void backButtonAction()
    {
        try
        {
            SignUp.InitScene();
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void initialize()
    {
        domainCombo.getItems().addAll(Domain.getStrList());
        try
        {
            domainCombo.getSelectionModel().selectFirst();
        }
        catch(Exception e)
        {};
    }

    public void SPDataSave()
    {
        String path = "data/userData/" + userField.getText() + "/";
        JsonSP jp = new JsonSP();
        jp.setUsername(userField.getText());
        jp.setPassword(User.encrypt(passField.getText()));
        jp.setEmail(emailField.getText());
        jp.setFirstName(firstNameField.getText());
        jp.setLastName(lastNameField.getText());
        jp.setType(LogSignMenu.type);
        jp.setPhone(phoneField.getText());
        jp.setInfoPath(path+"info.json");
        jp.setDomain(domainCombo.getValue().toString());
        Sp.writeSP(path+"info.json",jp);

    }

    public void signButtonAction() throws IOException
    {
        boolean res = users.userExist(userField.getText());
        if(fileSelected == false)
        {
            Alert.display("Fail", "Certificate was not selected!");
            return;
        }
        if(res == false)
        {
            Alert.display("Fail", "User already exists!");
            return;
        }
        else
        {
            JsonUser ju = new JsonUser();
            ju.setUsername(userField.getText());
            ju.setPassword(User.encrypt(passField.getText()));
            ju.setType(LogSignMenu.type);
            users.getListUsr().add(ju);
            users.writeUser();

            SPDataSave();
            int lastIndexOf = selectedFilePath.lastIndexOf(".");
            String toPath = "data/userData/" + userField.getText() + "/ceritificate" + selectedFilePath.substring(lastIndexOf);
            Files.copy(Paths.get(selectedFilePath), Paths.get(toPath), StandardCopyOption.REPLACE_EXISTING);
            Alert.display("Success", "Account created!");
            LogSignMenu.InitScene();
        }
    }

    public void browseButtonAction() throws Exception
    {
        FileChooser.ExtensionFilter certifyFilter = new FileChooser.ExtensionFilter("Supported files", "*.jpg", "*.png", "*.pdf", "*.jpeg");
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(certifyFilter);
        fileChooser.setTitle("Open Resource File");
        file = fileChooser.showOpenDialog(stage);
        if(file != null)
        {
            fileSelected = true;
            System.out.println(file.getPath());
            selectedFilePath = file.getPath();
            fileLabel.setText(file.getName());
        }
        else
        {
            fileSelected = false;
        }


    }
    //public Scene getScene()
    /*{
        return scene;
    }*/
}
