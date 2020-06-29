package scenes.client;

import Handler.SceneHandler;
import JSON.JsonOffer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import misc.Domain;
import misc.Offer;
import misc.Request;

import java.io.IOException;
import java.util.List;

public class ClientViewOffers
{
    public static ObservableList list = FXCollections.observableArrayList();
    @FXML
    public ListView<String> listView;
    @FXML
    public ComboBox fxDomain;
    private static int selectedItem = -1;

    protected static Scene scene;

    public static void InitScene() throws IOException
    {
        SceneHandler.InitScene("ClientViewOffers","View offers");
    }

    public void initialize()
    {
        Offer.updateList();
        Domain.updateList();
        fxDomain.getItems().addAll(Domain.getStrList());
        fxDomain.getSelectionModel().selectFirst();
        ViewOnLoad();
    }

    private void createList()
    {
        list.clear();
        Request.updateList();
        List<JsonOffer> ret = Offer.getByDomain(fxDomain.getValue().toString());
        if(ret != null)
        {
            for(JsonOffer x:ret)
            {
                list.add(x.getTitle());
            }
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
        ClientMenu.InitScene();
        selectedItem = -1;
    }

    public void selectAction()
    {
        ViewOnLoad();
    }


    public void viewOffer() throws IOException
    {
        String ret = listView.getSelectionModel().getSelectedItem();
        if(ret != null)
        {
            List<JsonOffer> objects = Offer.getByDomain(fxDomain.getValue().toString());
            selectedItem = listView.getSelectionModel().getSelectedIndex();
            JsonOffer object = objects.get(selectedItem);
            if(object != null)
            {
                ClientViewSingleOffer.setJr(object);
                ClientViewSingleOffer.InitScene();
            }
            selectedItem = -1;
        }
    }
}
