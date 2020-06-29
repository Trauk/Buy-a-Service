import Handler.SceneHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import scenes.ConfirmBox;
import scenes.LogSignMenu;
import users.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

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
    public void start(Stage primaryStage) throws NoSuchAlgorithmException, IOException
    {
        window = primaryStage;
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        }); // What happens when you press the x button
        User users = new User("testJson.json");
        LogSignMenu.setUsers(users);
        LogSignMenu.setStage(window);

        SceneHandler.setUsers(users);
        SceneHandler.setStage(window);
        //window.setTitle("Login");


        LogSignMenu.InitScene();
        ////window.setScene(scene);
        //window.setScene(new Scene(root,600,600));
        window.show();

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
        //JsonUser userFile = new JsonUser("user.json");
        //userFile.readJson();
        //userFile.writeJson("users2.json");
        /*String plaintext = "your text here";
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(plaintext.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        String hashtext = bigInt.toString(16);
// Now we need to zero pad it if you actually want the full 32 chars.
        while(hashtext.length() < 32 ){
            hashtext = "0"+hashtext;
        }
        System.out.println(hashtext);*/

        //JsonUser usr = objectMapper.readValue(testJson,JsonUser.class);
        //System.out.println("usr: " + usr.getUsername());
        //System.out.println("pass: " + usr.getPassword());
        //objectMapper.writeValue(new FileOutputStream("testJson"), usr);
        /*File file = new File("testJson.json");
        ObjectMapper objectMapper = new ObjectMapper();
        List<JsonUser> listUsr = objectMapper.readValue(file, new TypeReference<List<JsonUser>>(){});
        System.out.println(listUsr);*/


/*
        ObjectMapper objectMapper = new ObjectMapper();
        List<JsonUser> listUsr;
        JsonController jc = new JsonController();
        listUsr = jc.readArrayUser("testJson.json");
        String name = "";
        User userTest = new User(listUsr);
        userTest.testGet("Amali");

        if(listUsr != null)
        {
            for (JsonUser x:listUsr)
            {
                System.out.println(x.getUsername());
                System.out.println(x.getPassword());
                name = x.getUsername();
                //x.setPassword("Changed");
                System.out.println();
            }
        }
        File file = new File(name + "/testJson3.json");
        file.getParentFile().mkdirs();
        objectMapper.writeValue(file, listUsr);

        User usr = new User();
        usr.readFromFile("text.json");
        void readFromFile(String path)
        {
            this.usrList = JC.readFromFile(NumeClasa,path);
        }
        */
    }
    private void closeProgram()
    {
        Boolean answer = ConfirmBox.display("Confirm","Are you sure you want to exit?");
        if(answer)
        {
            window.close();
        }
    }
    public Stage getWindow()
    {
        return window;
    }



}
