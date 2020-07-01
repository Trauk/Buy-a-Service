package Handler;

import JSON.JsonClient;
import JSON.JsonSP;
import JSON.JsonUser;
import scenes.Alert;
import users.Client;
import users.Sp;
import users.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class SignUpHandler
{
    public static void signUpClient(String username,String password, String email, String firstName, String lastName, String phone)
    {
        String type = "Client";

        boolean res = SceneHandler.getUsers().userExist(username);
        if(res == false)
        {
            Alert.display("Fail", "User already exists!");
        }
        else
        {
            JsonUser ju = new JsonUser();
            ju.setUsername(username);
            ju.setPassword(User.encrypt(password));
            ju.setType(type);
            SceneHandler.getUsers().getListUsr().add(ju);
            SceneHandler.getUsers().writeUser();


            String path = "data/userData/" + username + "/";
            JsonClient jc = new JsonClient();

            jc.setUsername(username);
            jc.setPassword(User.encrypt(password));
            jc.setEmail(email);
            jc.setFirstName(firstName);
            jc.setLastName(lastName);
            jc.setType(type);
            jc.setPhone(phone);
            jc.setInfoPath(path+"info.json");
            Client.writeClient(path+"info.json",jc);

            Alert.display("Success", "Account created!");
        }

    }

    public static void signUpAdmin(String username,String password)
    {
        String type = "Admin";

        boolean res = SceneHandler.getUsers().userExist(username);
        if(res == false)
        {
            Alert.display("Fail", "User already exists!");
        }
        else
        {
            JsonUser ju = new JsonUser();
            ju.setUsername(username);
            ju.setPassword(User.encrypt(password));
            ju.setType(type);
            SceneHandler.getUsers().getListUsr().add(ju);
            SceneHandler.getUsers().writeUser();

            Alert.display("Success", "Account created!");
        }

    }

    public static void signUpSp(String username,String password, String email, String firstName, String lastName, String phone, String certificatePath, String domain) throws IOException
    {
        String type = "ServiceProvider";

        boolean res = SceneHandler.getUsers().userExist(username);
        if(res == false)
        {
            Alert.display("Fail", "User already exists!");
        }
        else
        {
            JsonUser ju = new JsonUser();
            ju.setUsername(username);
            ju.setPassword(User.encrypt(password));
            ju.setType(type);
            SceneHandler.getUsers().getListUsr().add(ju);
            SceneHandler.getUsers().writeUser();


            String path = "data/userData/" + username + "/";
            JsonSP jp = new JsonSP();


            jp.setUsername(username);
            jp.setPassword(User.encrypt(password));
            jp.setEmail(email);
            jp.setFirstName(firstName);
            jp.setLastName(lastName);
            jp.setType(type);
            jp.setPhone(phone);
            jp.setInfoPath(path+"info.json");
            jp.setCertificatePath(certificatePath);
            jp.setDomain(domain);
            jp.setApproved("approved");
            Sp.writeSP(path+"info.json",jp);

            int lastIndexOf = certificatePath.lastIndexOf(".");
            String toPath = path + "certificate" + certificatePath.substring(lastIndexOf);
            Files.copy(Paths.get(certificatePath), Paths.get(toPath), StandardCopyOption.REPLACE_EXISTING);

            Alert.display("Success", "Account created!");
        }

    }



}
