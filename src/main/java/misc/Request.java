package misc;

import JSON.JsonController;
import JSON.JsonRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Request
{
    private static List<JsonRequest> listRequest;
    private static String path = "data/clientRequests/requests.json";

    public static List<JsonRequest> getBySender(String sender)
    {
        List<JsonRequest> ret = (listRequest).stream().filter(p -> ((p.getRequestSender()).equals(sender))).collect(Collectors.toList());
        return ret;
    }

    public static ArrayList<String> getStrListSender()
    {
        ArrayList<String> ret = new ArrayList<String>();
        for(JsonRequest x:listRequest)
        {
            ret.add(x.getRequestSender());
        }
        return ret;
    }

    public static ArrayList<String> getStrListDomain()
    {
        ArrayList<String> ret = new ArrayList<String>();
        for(JsonRequest x:listRequest)
        {
            ret.add(x.getRequestDomain());
        }
        return ret;
    }

    private static JsonRequest getRequest(String domain,String title)
    {
        return listRequest.stream().filter(dm -> domain.equals(dm.getRequestDomain()) && title.equals(dm.getReqeustTitle())).findAny().orElse(null);
    }

    public static int getIndex(String domain, String title)
    {
        return listRequest.indexOf(getRequest(domain,title));
    }


    public static void deleteElement(String domain,String title)
    {
        int pos = getIndex(domain,title);
        if(pos != -1)
        {
            listRequest.remove(pos);
            JsonController.writeArrayRequest(path, listRequest);
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
        JsonRequest jd = new JsonRequest();
        jd.setRequestDomain(domain);
        jd.setRequestDetails(details);
        jd.setRequestSender(sender);
        jd.setReqeustTitle(title);
        listRequest.add(jd);
        JsonController.writeArrayRequest(path, listRequest);
    }

    public static void updateList()
    {
        listRequest = JsonController.readArrayRequest(path);
    }


}
