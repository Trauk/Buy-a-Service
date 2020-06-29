package scenes.sp;

import Handler.LogInHandler;
import Handler.SceneHandler;
import JSON.JsonRequest;
import JSON.JsonSP;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import misc.Request;
import users.Sp;

import java.io.IOException;
import java.util.List;

public class SpViewRequests
{
    public static ObservableList list = FXCollections.observableArrayList();
    @FXML
    public ListView<String> listView;
    private static int selectedItem = -1;

    protected static Scene scene;

    public static void InitScene() throws IOException
    {
        SceneHandler.InitScene("SpViewRequests","View requests");
    }

    public void initialize()
    {
        ViewOnLoad();
    }

    private void createList()
    {
        JsonSP jp = Sp.readSP("data/userData/" + LogInHandler.loggedUser + "/info.json");
        list.clear();
        Request.updateList();
        List<JsonRequest> ret = Request.getByDomain(jp.getDomain());
        for(JsonRequest x:ret)
        {
            list.add(x.getReqeustTitle());
        }

    }

    public void ViewOnLoad()
    {
        createList();
        listView.getItems().clear();
        listView.getItems().addAll(list);
        if(selectedItem != -1)
        {
            listView.getSelectionModel().select(selectedItem);
        }
    }

    public void backButtonAction() throws IOException
    {
        SPMenu.InitScene();
        selectedItem = -1;
    }


    public void viewRequest() throws IOException
    {
        String ret = listView.getSelectionModel().getSelectedItem();
        if(ret != null)
        {
            JsonSP jp = Sp.readSP("data/userData/" + LogInHandler.loggedUser + "/info.json");
            List<JsonRequest> objects = Request.getByDomain(jp.getDomain());
            selectedItem = listView.getSelectionModel().getSelectedIndex();
            JsonRequest object = objects.get(selectedItem);
            if(object != null)
            {
                SpViewSingleRequest.setJr(object);
                SpViewSingleRequest.InitScene();
            }

        }
    }

}
