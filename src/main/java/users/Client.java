package users;

import JSON.JsonClient;
import JSON.JsonController;

public class Client
{
   public static JsonClient readClient(String path)
   {
       return JsonController.readClient(path);
   }

   public static void writeClient(String path, JsonClient jc)
   {
       JsonController.writeClient(path,jc);
   }

}
