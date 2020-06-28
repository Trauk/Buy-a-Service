package scenes.admin;

import Handler.SceneHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import misc.Domain;
import scenes.TextFieldBox;

import java.io.IOException;

public class ManageDomains
{
    public static ObservableList list = FXCollections.observableArrayList();
    @FXML
    public ListView<String> domainView;

    protected static Scene scene;

    public static void InitScene() throws IOException
    {
        SceneHandler.InitScene("ManageDomains","Manage domains");
    }

    public void initialize()
    {
        domainViewOnLoad();
    }

    private void createList()
    {
        list.clear();
        Domain.updateList();
        for(String x:Domain.getStrList())
        {
            list.add(x);
            //domainView.getItems().add(x);
            //System.out.println(x);
        }

    }

    public void domainViewOnLoad()
    {
        createList();
        domainView.getItems().clear();
        domainView.getItems().addAll(list);
    }

    public void backButtonAction() throws IOException
    {
        AdminMenu.InitScene();
    }

    public void addDomainButtonAction()
    {
        String ret = TextFieldBox.display("Add domain","Enter new domain");
        if(ret!=null)
        {
            Domain.addElement(ret);
            domainView.getItems().addAll(ret);
        }

    }

    public void deleteDomainButtonAction()
    {
        String ret = domainView.getSelectionModel().getSelectedItem();
        Domain.deleteElement(ret);
        //domainView.getItems().remove(ret);
        domainViewOnLoad();
    }


}
