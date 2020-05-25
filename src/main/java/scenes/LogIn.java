package scenes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;


public class LogIn extends LogSignMenu
{
    public PasswordField passField;
    //private static Object LogIn;
    @FXML
    public Button logButton,backButton;
    @FXML
    public TextField userInput;

    public static void InitScene() throws IOException
    {
        stage.setTitle("Login");
        FXMLLoader loader = new FXMLLoader();
        URL fxmlLocation = LogIn.class.getResource("/LogIn.fxml");
        loader.setLocation(fxmlLocation);
        //loader.setResources(ResourceBundle.getBundle("i18n/Text", new Locale("sv", "SE")));
        Pane pane = loader.<Pane>load();
        //Scene scene = new Scene(pane);
        /*int w = 300, h = 250;
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel,0,0);

        TextField nameInput = new TextField();
        nameInput.setPromptText("username");
        GridPane.setConstraints(nameInput,1,0);

        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel,0,1);

        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput,1,1);

        Button backButton = new Button("Back");
        backButton.setOnAction(e ->
        {
           LogSignMenu.InitScene();
        });
        GridPane.setConstraints(backButton,0,2);

        Button logInButton = new Button("Log in");

        logInButton.setOnAction(e ->
        {
            boolean res = users.comparePassword(nameInput.getText(), passInput.getText());
            if(res == true)
            {
                Alert.display("Success", "Login successful!");
            }
            else
            {
                Alert.display("Fail", "Username or password is incorrect!");
            }
        });
        GridPane.setConstraints(logInButton,1,2);


        grid.getChildren().addAll(nameLabel,nameInput,passLabel,passInput,backButton,logInButton);*/
        scene = new Scene(pane);
        stage.setScene(scene);
    }

    public void backButtonAction() throws IOException
    {
        LogSignMenu.InitScene();
    }

    @FXML
    public void logButtonAction()
    {
        boolean res = users.comparePassword(userInput.getText(), passField.getText());
        if(res == true)
        {
            Alert.display("Success", "Login successful!");
        }
        else
        {
            Alert.display("Fail", "Username or password is incorrect!");
        }
    }



}
