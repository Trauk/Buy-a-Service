package misc;

import JSON.JsonController;
import JSON.JsonDomain;

import java.util.ArrayList;
import java.util.List;

public class Domain
{
    private static List<JsonDomain> listDomain;
    private static String path = "data/domains/domains.json";

    public static ArrayList<String> getStrList()
    {
        ArrayList<String> ret = new ArrayList<String>();
        for(JsonDomain x:listDomain)
        {
            //System.out.println(x.getDomain());
            ret.add(x.getDomain());
        }
        return ret;
    }

    private static JsonDomain getDomain(String domain)
    {
        return listDomain.stream().filter(dm -> domain.equals(dm.getDomain())).findAny().orElse(null);
    }

    public static int getIndex(String domain)
    {
        return listDomain.indexOf(getDomain(domain));
    }

    public static void deleteElement(String domain)
    {
        int pos = getIndex(domain);
        if(pos != -1)
        {
            listDomain.remove(pos);
            JsonController.writeArrayDomain(path, listDomain);
        }
    }

    public static boolean exists(String element)
    {
        if(getDomain(element) == null)
            return false;
        return true;
    }

    public static void addElement(String domain)
    {
        JsonDomain jd = new JsonDomain();
        jd.setDomain(domain);
        listDomain.add(jd);
        JsonController.writeArrayDomain(path, listDomain);
    }

    public static void updateList()
    {
        listDomain = JsonController.readArrayDomain(path);
    }


}
