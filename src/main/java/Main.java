import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class Menu extends Application
{

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
        Label label1 = new Label("Login page!");

        Button button1= new Button("Login");
        button1.setOnAction(e -> window.setScene(scene2));

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
    }

}
