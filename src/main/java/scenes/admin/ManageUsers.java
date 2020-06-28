package scenes.admin;

import Handler.SceneHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import scenes.TextFieldBox;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ManageUsers
{
    public static ObservableList list = FXCollections.observableArrayList();
    @FXML
    public ListView<String> listView;
    public static List<String> toShow;

    protected static Scene scene;

    public static void InitScene() throws IOException
    {
        SceneHandler.InitScene("ManageUsers","Manage users");
    }

    public void initialize()
    {
        if(toShow == null || toShow.isEmpty())
        {
            toShow = SceneHandler.getUsers().getUsernameList();
        }
        listViewOnLoad();
    }


    public void listViewOnLoad()
    {
        //createList();
        listView.getItems().clear();
        listView.getItems().addAll(toShow);
    }

    public void backButtonAction() throws IOException
    {
        ManageAccounts.InitScene();
    }



    public void viewButtonAction() throws IOException
    {
        String ret = listView.getSelectionModel().getSelectedItem();
        if(ret != null)
        {
            String userType = SceneHandler.getUsers().getType(ret);

            if(userType.equals("ServiceProvider"))
            {
                ViewUserSp.setUsername(ret);
                ViewUserSp.InitScene();
            }
            if(userType.equals("Client"))
            {
                ViewUserClient.setUsername(ret);
                ViewUserClient.InitScene();
            }
        }

    }

    public void filterButtonAction()
    {
        String criteria = TextFieldBox.display("Filter by","Enter username");
        if(criteria != null && criteria.length() > 0)
        {
            List<String> ret = (SceneHandler.getUsers().getUsernameList()).stream().filter(p -> p.startsWith(criteria)).collect(Collectors.toList());
            toShow = ret;
            listViewOnLoad();
        }
        else
        {
            toShow =  SceneHandler.getUsers().getUsernameList();
            listViewOnLoad();
        }
    }


}
