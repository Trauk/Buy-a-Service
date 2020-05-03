import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import org.json.*;

import java.io.FileWriter;
import java.io.IOException;


public class SignUp
{
    private Scene scene;
    JSONObject obj = new JSONObject();
    public SignUp()
    {


        JSONObject passJson = new JSONObject();
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

        Button signUpButton = new Button("Sign up");
        signUpButton.setOnAction(e -> {
            JSONObject userJson = new JSONObject();
            userJson.put("username:", nameInput.getText());
            userJson.put("password:", passInput.getText());
            obj.put(nameInput.getText(), userJson);
            System.out.println(obj.toString(4));
            try (FileWriter file = new FileWriter("user.json")) {

                file.write(obj.toString(4));
                file.flush();

            } catch (IOException err) {
                err.printStackTrace();
            }
        });
        GridPane.setConstraints(signUpButton,1,2);


        grid.getChildren().addAll(nameLabel,nameInput,passLabel,passInput,signUpButton);
        scene = new Scene(grid,w,h);

    }
    public Scene getScene()
    {
        return scene;
    }
}
