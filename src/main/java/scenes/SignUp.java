package scenes;

import Handler.SceneHandler;

import java.io.IOException;

public class SignUp extends LogSignMenu
{
    public static void InitScene() throws IOException
    {
        /*int h = 100;
        int w = 250;
        Label label = new Label("Choose account type");

        Button signUpClient = new Button("Client");
        signUpClient.setOnAction(e -> SignUpClient.InitScene());

        Button signUpSP = new Button("Service Provider");

        Button backButton = new Button("Back");
        backButton.setOnAction(e ->
        {

        });

        VBox layout = new VBox(10);
        HBox hLayout = new HBox(10);
        hLayout.getChildren().addAll(signUpClient,signUpSP);
        hLayout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label,hLayout,backButton);
        layout.setAlignment(Pos.CENTER);*/
       /* Parent root = FXMLLoader.load(SignUp.class.getResource("/SignUp.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);*/
        SceneHandler.InitScene("SignUp","Sign up");
    }
    public void backButton()
    {
        try
        {
            LogSignMenu.InitScene();
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void clientButton() throws IOException
    {
        SignUpClient.InitScene();
    }

    public void spButtonAction() throws IOException
    {
        SPSign.InitScene();
    }

    //public Scene getScene()
    /*{
        return scene;
    }*/
}
