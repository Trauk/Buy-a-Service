package scenes.sp;

import Handler.LogInHandler;
import Handler.SceneHandler;
import JSON.JsonOffer;
import JSON.JsonSP;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import misc.Offer;
import misc.PendingSP;
import scenes.admin.ViewUser;
import users.Sp;

import java.io.IOException;
import java.util.List;

public class SpViewOffers
{
    public static ObservableList list = FXCollections.observableArrayList();
    @FXML
    public ListView<String> listView;
    private static int selectedItem = -1;

    protected static Scene scene;

    public static void InitScene() throws IOException
    {
        SceneHandler.InitScene("SpViewOffers","View offers");
    }

    public void initialize()
    {
        ViewOnLoad();
    }

    private void createList()
    {
        list.clear();
        Offer.updateList();
        List<JsonOffer> ret = Offer.getBySender(LogInHandler.loggedUser);
        for(JsonOffer x:ret)
        {
            list.add(x.getTitle());
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
        SpOfferMenu.InitScene();
        selectedItem = -1;
    }

    public void deleteOffer()
    {
        String ret = listView.getSelectionModel().getSelectedItem();
        if(ret != null)
        {
            List<JsonOffer> objects = Offer.getBySender(LogInHandler.loggedUser);
            selectedItem = listView.getSelectionModel().getSelectedIndex();
            JsonOffer object = objects.get(selectedItem);
            Offer.deleteElement(object.getDomain(),object.getTitle());
            selectedItem = -1;
            ViewOnLoad();
        }

    }

    public void viewOffer() throws IOException
    {
        String ret = listView.getSelectionModel().getSelectedItem();
        if(ret != null)
        {
            List<JsonOffer> objects = Offer.getBySender(LogInHandler.loggedUser);
            selectedItem = listView.getSelectionModel().getSelectedIndex();
            JsonOffer object = objects.get(selectedItem);
            if(object != null)
            {
                SpViewSingleOffer.setJr(object);
                SpViewSingleOffer.InitScene();
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
