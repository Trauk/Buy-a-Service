package scenes.admin;

import Handler.SceneHandler;
import Handler.SignUpHandler;
import JSON.JsonClient;
import JSON.JsonSP;
import JSON.JsonUser;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import misc.Domain;
import scenes.Alert;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CreateAccount
{
    @FXML
    TextField fxUsername,fxEmail,fxFirstName,fxLastName,fxPhone,fxPassword;
    @FXML
    Label fxFirstNameLabel,fxLastNameLabel,fxTypeLabel,fileNameLabel;
    @FXML
    Button fxEditButton,fxApplyButton;
    @FXML
    ComboBox fxDomain,fxType;
    @FXML
    HBox fxEmailRow,fxFirstNameRow,fxLastNameRow,fxPhoneRow,fxDomainRow,fxCertificateRow;
    protected static Scene scene;
    private JsonClient jc;
    private JsonUser ju;
    private JsonSP jp;
    private String type;
    private boolean editEnabled = false;
    private static boolean fileSelected;
    private static String selectedFilePath;


    public static void InitScene() throws IOException
    {
        SceneHandler.InitScene("CreateAccount","Account creation");
        //System.out.println(username);
    }

    public void initialize()
    {
        initRoutine();
    }

    public void initRoutine()
    {
        Domain.updateList();
        fxDomain.getItems().addAll(Domain.getStrList());
        fxType.getItems().addAll("Admin","Client","Service Provider");
        fxType.getSelectionModel().selectFirst();
        fxDomain.getSelectionModel().selectFirst();
        fxTypeLabel.setText(fxType.getSelectionModel().getSelectedItem().toString());
        typeOnChange();
    }


    public void backButtonAction() throws IOException
    {
        ManageAccounts.InitScene();
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
        //Sp.writeSP("data/userData/" +username + "/info.json",jp);
        //fxNameLabel.setText(jp.getFirstName() + " " + jp.getLastName());
    }

    public void OpenCertificateButtonAction() throws IOException
    {
        String path = new File("pathFile.txt").getAbsolutePath();
        path = path.substring(0,path.lastIndexOf('\\')+1);
        path = path + jp.getCertificatePath();
        System.out.println(path);
        Desktop.getDesktop().open(new File(path));
    }

    public void typeOnChange()
    {
        String selected = fxType.getSelectionModel().getSelectedItem().toString();
        fxTypeLabel.setText(fxType.getSelectionModel().getSelectedItem().toString());
        if(selected.equals("Admin"))
        {
            fxFirstNameLabel.setText("Admin");
            fxLastNameLabel.setText("");
            fxEmailRow.setVisible(false);
            fxEmail.setText("");
            fxFirstNameRow.setVisible(false);
            fxFirstName.setText("");
            fxLastNameRow.setVisible(false);
            fxLastName.setText("");
            fxPhoneRow.setVisible(false);
            fxPhone.setText("");
            fxDomainRow.setVisible(false);
            fxDomain.getSelectionModel().selectFirst();
            fxCertificateRow.setVisible(false);
            selectedFilePath = null;
            fileSelected = false;
            fileNameLabel.setText("");
            return;
        }
        if(selected.equals("Client"))
        {
            if(fxLastName == null || fxLastName.getText().equals(""))
            {
                fxLastNameLabel.setText("LastName");
            }
            if(fxFirstName == null || fxFirstName.getText().equals(""))
            {
                fxFirstNameLabel.setText("FirstName");
            }
            fxEmailRow.setVisible(true);
            fxFirstNameRow.setVisible(true);
            fxLastNameRow.setVisible(true);
            fxPhoneRow.setVisible(true);
            fxDomainRow.setVisible(false);
            fxDomain.getSelectionModel().selectFirst();
            fxCertificateRow.setVisible(false);
            selectedFilePath = null;
            fileSelected = false;
            fileNameLabel.setText("");
            return;
        }
        if(selected.equals("Service Provider"))
        {
            if(fxLastName == null || fxLastName.getText().equals(""))
            {
                fxLastNameLabel.setText("LastName");
            }
            if(fxFirstName == null || fxFirstName.getText().equals(""))
            {
                fxFirstNameLabel.setText("FirstName");
            }
            fxEmailRow.setVisible(true);
            fxFirstNameRow.setVisible(true);
            fxLastNameRow.setVisible(true);
            fxPhoneRow.setVisible(true);
            fxDomainRow.setVisible(true);
            fxCertificateRow.setVisible(true);
            return;
        }
    }

    public void createAccountButtonAction() throws IOException
    {
        String type = fxType.getSelectionModel().getSelectedItem().toString();
        if(type.equals("Admin"))
        {
            String username = fxUsername.getText();
            String password = fxPassword.getText();
            if(username == null || password == null || username.equals("") || password.equals(""))
            {
                Alert.display("Error","You cannot leave a field empty!");
                return;
            }
            SignUpHandler.signUpAdmin(username,password);
            return;
        }
        if(type.equals("Client"))
        {
            String username = fxUsername.getText();
            String password = fxPassword.getText();
            String email = fxEmail.getText();
            String firstName = fxFirstName.getText();
            String lastName = fxLastName.getText();
            String phone = fxPhone.getText();
            if(username == null || password == null || username.equals("") || password.equals("")
             || email == null || firstName == null || lastName == null || phone == null
             || email.equals("") || firstName.equals("") || lastName.equals("") || phone.equals(""))
            {
                Alert.display("Error","You cannot leave a field empty!");
                return;
            }
            SignUpHandler.signUpClient(username,password,email,firstName,lastName,phone);
        }
        if(type.equals("Service Provider"))
        {
            String username = fxUsername.getText();
            String password = fxPassword.getText();
            String email = fxEmail.getText();
            String firstName = fxFirstName.getText();
            String lastName = fxLastName.getText();
            String phone = fxPhone.getText();
            String domain = fxDomain.getValue().toString();
            if(fileSelected == false || selectedFilePath == null || selectedFilePath.equals(""))
            {
                Alert.display("Error","Certificate not selected!");
                return;
            }
            if(username == null || password == null || username.equals("") || password.equals("")
                    || email == null || firstName == null || lastName == null || phone == null
                    || email.equals("") || firstName.equals("") || lastName.equals("") || phone.equals("")
                    )
            {
                Alert.display("Error","You cannot leave a field empty!");
                return;
            }
            SignUpHandler.signUpSp(username,password,email,firstName,lastName,phone,selectedFilePath,domain);
        }
    }

    public void browseButtonAction()
    {
        FileChooser.ExtensionFilter certifyFilter = new FileChooser.ExtensionFilter("Supported files", "*.jpg", "*.png", "*.pdf", "*.jpeg");
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(certifyFilter);
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(SceneHandler.getStage());
        if(file != null)
        {
            fileSelected = true;
            System.out.println(file.getPath());
            selectedFilePath = file.getPath();
            fileNameLabel.setText(file.getName());
        }
        else
        {
            fileSelected = false;
        }

    }


    public void firstNameOnChange()
    {
        fxFirstNameLabel.setText(fxFirstName.getText());
    }

    public void lastNameOnChange()
    {
        fxLastNameLabel.setText(fxLastName.getText());
    }



}
