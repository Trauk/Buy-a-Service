import JSON.JsonUser;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class Main extends Application
{
    Scene scene;
    Stage window;
    Scene scene1,scene2;
    Button loginButton;
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        window = primaryStage;
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        }); // What happens when you press the x button




    /*
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1,button1);
        scene1 = new Scene(layout1, 200, 200);

        Button button2 = new Button("Log out");
        button2.setOnAction(e -> window.setScene(scene1));

        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2,200,200);

        window.setScene(scene1);
        window.setTitle("Login test");
        window.show();
        */
        //Pane layout = new StackPane();
        //layout.getChildren().add(button1);
        //Scene scene = new Scene(layout,300,300);



        //scene = new SignUp().getScene();
        //window.setScene(scene);
        //window.show();
        JsonUser userFile = new JsonUser("user.json");
        userFile.readJson();

    }
    private void closeProgram()
    {
        Boolean answer = ConfirmBox.display("Confirm","Are you sure you want to exit?");
        if(answer)
        {
            window.close();
        }
    }

}
