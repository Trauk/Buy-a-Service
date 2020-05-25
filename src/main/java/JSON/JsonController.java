package JSON;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonController
{
    public static List<JsonUser> readArrayUser(String filePath)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);
        List<JsonUser> jsonList = null;
        try
        {
            jsonList = objectMapper.readValue(file, new TypeReference<List<JsonUser>>(){});
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return jsonList;
    }
    public static void writeArrayUser(String filePath, List<JsonUser> lst)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        try
        {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), lst);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
