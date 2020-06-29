package users;

import JSON.JsonController;
import JSON.JsonSP;

public class Sp
{
    public static JsonSP readSP(String path)
    {
        return JsonController.readSP(path);
    }

    public static void writeSP(String path, JsonSP js)
    {
        JsonController.writeSP(path,js);
    }

}
