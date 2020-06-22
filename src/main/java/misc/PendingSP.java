package misc;

import JSON.JsonController;
import JSON.JsonPendingSP;

import java.util.ArrayList;
import java.util.List;

public class PendingSP
{
    private static List<JsonPendingSP> listPending;
    private static String path = "data/requests/pending.json";

    public static ArrayList<String> getStrList()
    {
        ArrayList<String> ret = new ArrayList<String>();
        for(JsonPendingSP x: listPending)
        {
            //System.out.println(x.getDomain());
            ret.add(x.getPending());
        }
        return ret;
    }

    private static JsonPendingSP getPending(String element)
    {
        return listPending.stream().filter(dm -> element.equals(dm.getPending())).findAny().orElse(null);
    }

    private static int getIndex(String element)
    {
        return listPending.indexOf(getPending(element));
    }

    public static void deleteElement(String element)
    {
        int pos = getIndex(element);
        if(pos != -1)
        {
            listPending.remove(pos);
            JsonController.writeArrayPending(path, listPending);
        }
    }

    public static void addElement(String element)
    {
        JsonPendingSP jd = new JsonPendingSP();
        jd.setPending(element);
        listPending.add(jd);
        JsonController.writeArrayPending(path, listPending);
    }

    public static boolean exists(String element)
    {
        if(getPending(element) == null)
            return false;
        return true;
    }


    public static void updateList()
    {
        listPending = JsonController.readArrayPending(path);
    }


}
