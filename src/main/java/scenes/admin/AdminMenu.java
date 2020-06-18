package scenes.admin;

import Handler.SceneHandler;
import javafx.scene.Scene;
import scenes.LogSignMenu;

import java.io.IOException;

public class AdminMenu
{
    protected static Scene scene;

    public static void InitScene() throws IOException
    {
        /*Stage stage = SceneHandler.getStage();
        stage.setTitle("Admin menu");
        /*stage.setMinWidth(250);
        Button logInButton = new Button("Log In");
        Button signUpButton = new Button("Sign Up");
        HBox layout = new HBox(10);
        layout.getChildren().addAll(logInButton,signUpButton);
        layout.setAlignment(Pos.CENTER);
        scene = new Scene(layout);
        FXMLLoader loader = new FXMLLoader();
        URL fxmlLocation = LogIn.class.getResource("/AdminMenu.fxml");
        loader.setLocation(fxmlLocation);
        Pane pane = loader.<Pane>load();
        scene = new Scene(pane);
        stage.setScene(scene);
        */
        SceneHandler.InitScene("AdminMenu","Admin menu");

    }

    public void logOutAction() throws IOException
    {
        LogSignMenu.InitScene();
    }

    public void manageAccButtonAction() throws IOException
    {
        ManageAccounts.InitScene();
    }

    public void manageDomainsButtonAction() throws IOException
    {
        ManageDomains.InitScene();
    }

}
