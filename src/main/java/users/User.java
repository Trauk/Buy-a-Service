package users;

import JSON.JsonController;
import JSON.JsonUser;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class User
{
    private List<JsonUser> listUsr;
    private String path;
    public User(List<JsonUser> listUsr)
    {
        this.listUsr = listUsr;
    }

    public User(String path)
    {
        this.path = path;
        this.listUsr = JsonController.readArrayUser(path);
    }

    public void writeUser()
    {
        JsonController.writeArrayUser(path,listUsr);
    }


    private JsonUser getUser(String username)
    {
        return this.listUsr.stream().filter(user -> username.equals(user.getUsername())).findAny().orElse(null);
    }

    public String getType(String username)
    {
        return getUser(username).getType();
    }

    public void setPassword(String username, String password)
    {
        getUser(username).setPassword(encrypt(password));
    }

    public void setType(String username, String type)
    {
        getUser(username).setType(type);
    }

    public boolean userExist(String username)
    {
        JsonUser user = getUser(username);
        if(user == null)
            return true;
        else
            return false;
    }

    public boolean comparePassword(String username, String password)
    {
        JsonUser user = getUser(username);
        if(user != null)
            if(user.getPassword().equals(encrypt(password)))
            {
                return true;
            }
            else
            {
                return false;
            }
        else
            return false;
    }

    public void testGet(String username)
    {
        System.out.println(getUser(username).getPassword());
    }


    public List<JsonUser> getListUsr()
    {
        return listUsr;
    }

    public void setListUsr(List<JsonUser> listUsr)
    {
        this.listUsr = listUsr;
    }

    public static String encrypt(String text)
    {
        MessageDigest m = null;
        try
        {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        m.reset();
        m.update(text.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        String hashtext = bigInt.toString(16);
        while(hashtext.length() < 32 )
        {
            hashtext = "0"+hashtext;
        }
        return hashtext;
        //return text;
    }

}
