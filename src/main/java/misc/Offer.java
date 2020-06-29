package misc;

import JSON.JsonController;
import JSON.JsonOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Offer
{
    private static List<JsonOffer> listOffer;
    private static String path = "data/offers/offers.json";

    public static List<JsonOffer> getBySender(String sender)
    {
        List<JsonOffer> ret = (listOffer).stream().filter(p -> ((p.getSender()).equals(sender))).collect(Collectors.toList());
        return ret;
    }

    public static List<JsonOffer> getByDomain(String domain)
    {
        List<JsonOffer> ret = (listOffer).stream().filter(p -> ((p.getDomain()).equals(domain))).collect(Collectors.toList());
        return ret;
    }

    public static ArrayList<String> getStrListSender()
    {
        ArrayList<String> ret = new ArrayList<String>();
        for(JsonOffer x: listOffer)
        {
            ret.add(x.getSender());
        }
        return ret;
    }

    public static ArrayList<String> getStrListDomain()
    {
        ArrayList<String> ret = new ArrayList<String>();
        for(JsonOffer x: listOffer)
        {
            ret.add(x.getDomain());
        }
        return ret;
    }

    private static JsonOffer getRequest(String domain,String title)
    {
        return listOffer.stream().filter(dm -> domain.equals(dm.getDomain()) && title.equals(dm.getTitle())).findAny().orElse(null);
    }

    public static int getIndex(String domain, String title)
    {
        return listOffer.indexOf(getRequest(domain,title));
    }


    public static void deleteElement(String domain,String title)
    {
        int pos = getIndex(domain,title);
        if(pos != -1)
        {
            listOffer.remove(pos);
            JsonController.writeArrayOffer(path, listOffer);
        }
    }

    public static boolean exists(String domain, String title)
    {
        if(getRequest(domain, title) == null)
            return false;
        return true;
    }

    public static void addElement(String domain,String sender, String details, String title)
    {
        JsonOffer jd = new JsonOffer();
        jd.setDomain(domain);
        jd.setDetails(details);
        jd.setSender(sender);
        jd.setTitle(title);
        listOffer.add(jd);
        JsonController.writeArrayOffer(path, listOffer);
    }

    public static void updateList()
    {
        listOffer = JsonController.readArrayOffer(path);
    }
}
