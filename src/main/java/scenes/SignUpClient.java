package scenes;

import JSON.JsonUser;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import users.User;

import java.io.IOException;

public class SignUpClient extends LogSignMenu
{
    public static void InitScene()
    {
        LogSignMenu.type = "Client";
        stage.setTitle("Sign Up as client");
        int w = 300, h = 250;
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
            try
            {
                SignUp.InitScene();
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        });
        GridPane.setConstraints(backButton,0,2);

        Button signUpButton = new Button("Sign up");
        signUpButton.setOnAction(e ->
        {
            boolean res = users.userExist(nameInput.getText());
            if(res == false)
            {
                Alert.display("Fail", "User already exists!");
            }
            else
            {
                JsonUser ju = new JsonUser();
                ju.setUsername(nameInput.getText());
                ju.setPassword(User.encrypt(passInput.getText()));
                ju.setType(LogSignMenu.type);
                users.getListUsr().add(ju);
                users.writeUser();
                Alert.display("Success", "Account created!");
            }
        });
        GridPane.setConstraints(signUpButton,1,2);


        grid.getChildren().addAll(nameLabel,nameInput,passLabel,passInput,backButton,signUpButton);
        scene = new Scene(grid,w,h);
        stage.setScene(scene);
    }
    //public Scene getScene()
    /*{
        return scene;
    }*/
}
