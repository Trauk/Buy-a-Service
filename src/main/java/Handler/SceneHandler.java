package Handler;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import scenes.LogIn;
import users.User;

import java.io.IOException;
import java.net.URL;

public class SceneHandler
{
    protected static Scene scene;
    protected static User users;
    protected static Stage stage;
    protected static String type;

    public static void InitScene(String name, String title) throws IOException
    {
        Stage stage = SceneHandler.getStage();
        stage.setTitle(title);
        /*stage.setMinWidth(250);
        Button logInButton = new Button("Log In");
        Button signUpButton = new Button("Sign Up");
        HBox layout = new HBox(10);
        layout.getChildren().addAll(logInButton,signUpButton);
        layout.setAlignment(Pos.CENTER);
        scene = new Scene(layout);*/
        FXMLLoader loader = new FXMLLoader();
        URL fxmlLocation = LogIn.class.getResource("/" + name + ".fxml");
        loader.setLocation(fxmlLocation);
        Pane pane = loader.<Pane>load();
        scene = new Scene(pane);
        stage.setScene(scene);
    }

    public static void setStage(Stage newStage)
    {
        stage = newStage;
    }
    public static Stage getStage()
    {
        return stage;
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
    public static User getUsers()
    {
        return users;
    }
}
