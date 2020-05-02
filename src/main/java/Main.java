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

        Label label1 = new Label("Login page!");

        Button button1= new Button("Login");
        button1.setOnAction(e -> {
            boolean result = ConfirmBox.display("Confirm","Are you sure?");
            System.out.println(result);
        });

        HBox topMenu = new HBox();
        Button buttonA = new Button("File");
        Button buttonB = new Button("Edit");
        Button buttonC = new Button("View");
        topMenu.getChildren().addAll(buttonA, buttonB, buttonC);

        VBox leftMenu = new VBox();
        Button buttonD = new Button("D");
        Button buttonE = new Button("E");
        Button buttonF = new Button("F");
        leftMenu.getChildren().addAll(buttonD,buttonE,buttonF);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setLeft(leftMenu);

        Scene scene = new Scene(borderPane,300,250);


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
        Pane layout = new StackPane();
        layout.getChildren().add(button1);
        //Scene scene = new Scene(layout,300,300);
        window.setScene(scene);
        window.show();

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