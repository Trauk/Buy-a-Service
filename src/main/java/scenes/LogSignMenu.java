package scenes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import users.User;

import java.io.IOException;
import java.net.URL;


public class LogSignMenu
{
    protected static Scene scene;
    protected static User users;
    protected static Stage stage;
    protected static String type;

    public static void InitScene() throws IOException
    {
        stage.setTitle("Start menu");
        /*stage.setMinWidth(250);
        Button logInButton = new Button("Log In");
        Button signUpButton = new Button("Sign Up");
        HBox layout = new HBox(10);
        layout.getChildren().addAll(logInButton,signUpButton);
        layout.setAlignment(Pos.CENTER);
        scene = new Scene(layout);*/
        FXMLLoader loader = new FXMLLoader();
        URL fxmlLocation = LogIn.class.getResource("/LogSignMenu.fxml");
        loader.setLocation(fxmlLocation);
        Pane pane = loader.<Pane>load();
        scene = new Scene(pane);
        stage.setScene(scene);


    }

    public void logInButton()
    {
        try
        {
            LogIn.InitScene();
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void signUpButton() throws IOException
    {
        SignUp.InitScene();
    }



    public static void setStage(Stage newStage)
    {
        stage = newStage;
    }
    public static Scene getScene()
    {
        return scene;
    }
    public static void setScene(Scene newScene)
    {
        scene = newScene;
    }
    public static void setUsers(User newUsers)
    {
        users = newUsers;
    }
}
