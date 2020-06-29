package scenes.client;

import Handler.LogInHandler;
import Handler.SceneHandler;
import JSON.JsonRequest;
import JSON.JsonSP;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import misc.PendingSP;
import misc.Request;
import scenes.admin.ViewUser;
import users.Sp;

import java.io.IOException;
import java.util.List;

public class ClientViewRequest
{
    public static ObservableList list = FXCollections.observableArrayList();
    @FXML
    public ListView<String> listView;
    private static int selectedItem = -1;

    protected static Scene scene;

    public static void InitScene() throws IOException
    {
        SceneHandler.InitScene("ClientViewRequests","View requests");
    }

    public void initialize()
    {
        ViewOnLoad();
    }

    private void createList()
    {
        list.clear();
        Request.updateList();
        List<JsonRequest> ret = Request.getBySender(LogInHandler.loggedUser);
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
        ClientRequestMenu.InitScene();
        selectedItem = -1;
    }

    public void deleteRequest()
    {
        String ret = listView.getSelectionModel().getSelectedItem();
        if(ret != null)
        {
            List<JsonRequest> objects = Request.getBySender(LogInHandler.loggedUser);
            selectedItem = listView.getSelectionModel().getSelectedIndex();
            JsonRequest object = objects.get(selectedItem);
            Request.deleteElement(object.getRequestDomain(),object.getReqeustTitle());
            selectedItem = -1;
            ViewOnLoad();
        }

    }

    public void viewRequest() throws IOException
    {
        String ret = listView.getSelectionModel().getSelectedItem();
        if(ret != null)
        {
            List<JsonRequest> objects = Request.getBySender(LogInHandler.loggedUser);
            selectedItem = listView.getSelectionModel().getSelectedIndex();
            JsonRequest object = objects.get(selectedItem);
            if(object != null)
            {
                ClientViewSingleRequest.setJr(object);
                ClientViewSingleRequest.InitScene();
            }

        }
    }

    public void approveButtonAction()
    {
        String user = listView.getSelectionModel().getSelectedItem();
        JsonSP jp = Sp.readSP("data/userData/" +user + "/info.json");
        jp.setApproved("approved");
        Sp.writeSP("data/userData/" +user + "/info.json",jp);
        PendingSP.deleteElement(user);
        selectedItem = -1;
        ViewOnLoad();
        //UPDATE THE LIST VIEW!
    }

    public void rejectButtonAction()
    {
        String user = listView.getSelectionModel().getSelectedItem();
        JsonSP jp = Sp.readSP("data/userData/" +user + "/info.json");
        jp.setApproved("rejected");
        Sp.writeSP("data/userData/" +user + "/info.json",jp);
        PendingSP.deleteElement(user);
        selectedItem = -1;
        ViewOnLoad();
        //UPDATE THE LIST VIEW!
    }
    public void ViewButtonAction() throws IOException
    {
        String ret = listView.getSelectionModel().getSelectedItem();
        if(ret != null)
        {
            selectedItem = listView.getSelectionModel().getSelectedIndex();
            ViewUser.setUsername(ret);
            ViewUser.InitScene();
        }

    }
}
