package JSON;

import org.json.JSONObject;

public class JsonUser extends JsonController
{
    private String user;
    private String pass;
    public JsonUser(String fileName)
    {
       super(fileName);
    }
    public void parseFunction(JSONObject obj)
    {

    }
}
