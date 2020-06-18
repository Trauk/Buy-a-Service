package scenes.admin;

import Handler.SceneHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import scenes.LogIn;

import java.io.IOException;
import java.net.URL;

public class ManageAccounts
{
    public static void InitScene() throws IOException
    {
        Scene scene;
        Stage stage = SceneHandler.getStage();
        stage.setTitle("Admin menu");
        /*stage.setMinWidth(250);
        Button logInButton = new Button("Log In");
        Button signUpButton = new Button("Sign Up");
        HBox layout = new HBox(10);
        layout.getChildren().addAll(logInButton,signUpButton);
        layout.setAlignment(Pos.CENTER);
        scene = new Scene(layout);*/
        FXMLLoader loader = new FXMLLoader();
        URL fxmlLocation = LogIn.class.getResource("/ManageAccounts.fxml");
        loader.setLocation(fxmlLocation);
        Pane pane = loader.<Pane>load();
        scene = new Scene(pane);
        stage.setScene(scene);


    }

    public void backButtonAction() throws IOException
    {
        AdminMenu.InitScene();
    }

}
