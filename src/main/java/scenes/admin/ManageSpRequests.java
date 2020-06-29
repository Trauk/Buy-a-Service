package scenes.admin;

import Handler.SceneHandler;
import JSON.JsonSP;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import misc.PendingSP;
import users.Sp;

import java.io.IOException;

public class ManageSpRequests
{
    public static ObservableList list = FXCollections.observableArrayList();
    @FXML
    public ListView<String> listView;
    private static int selectedItem = -1;

    protected static Scene scene;

    public static void InitScene() throws IOException
    {
        SceneHandler.InitScene("ManageSpRequests","Manage sp requests");
    }

    public void initialize()
    {
        ViewOnLoad();
    }

    private void createList()
    {
        list.clear();
        PendingSP.updateList();
        for(String x:PendingSP.getStrList())
        {
            list.add(x);
            //domainView.getItems().add(x);
            //System.out.println(x);
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
        AdminMenu.InitScene();
        selectedItem = -1;
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
