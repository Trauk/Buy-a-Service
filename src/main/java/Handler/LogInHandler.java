package Handler;

import JSON.JsonSP;
import misc.Domain;
import scenes.Alert;
import scenes.admin.AdminMenu;
import scenes.client.ClientMenu;
import scenes.sp.SPMenu;
import users.Sp;

import java.io.IOException;

public class LogInHandler
{
    public static String loggedUser;
    public static void logIn(String username, String type) throws IOException
    {
        if(type.equals("Admin"))
        {
            loggedUser = username;
            Alert.display("Success", "Login successful!");
            AdminMenu.InitScene();

        }
        if(type.equals("ServiceProvider"))
        {

            Domain.updateList();
            JsonSP jp = Sp.readSP("data/userData/" +username + "/info.json");
            String approved = jp.getApproved();
            //PendingSP.updateList();
            //if(PendingSP.exists(username))
            //{
            //    Alert.display("Error","Account was not approved yet");
            //    return;
            //}
            if(Domain.exists(jp.getDomain()) == false)
            {
                Alert.display("Error","Your domain is not supported anymore, contact system administrator!");
                return;
            }
            if(approved.equals("pending"))
            {
                Alert.display("Error","Account was not approved yet");
                return;
            }
            if(approved.equals("rejected"))
            {
                Alert.display("Error", "Your application was not accepted, contact system administrator!");
                return;
            }
            if(approved.equals("approved"))
            {
                loggedUser = username;
                Alert.display("Success", "Login successful!");
                SPMenu.InitScene();
                return;
            }

        }
        if(type.equals("Client"))
        {
            loggedUser = username;
            Alert.display("Success", "Login successful!");
            ClientMenu.InitScene();


        }
    }
}
