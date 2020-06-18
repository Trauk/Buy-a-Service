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

    public static JsonClient readClient(String filePath)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);
        JsonClient jsonObj = null;
        try
        {
            jsonObj = objectMapper.readValue(file, JsonClient.class);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return jsonObj;
    }

    public static void writeClient(String filePath, JsonClient jc)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        try
        {
            File file = new File(filePath);
            file.getParentFile().mkdirs();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, jc);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static JsonSP readSP(String filePath)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);
        JsonSP jsonObj = null;
        try
        {
            jsonObj = objectMapper.readValue(file, JsonSP.class);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return jsonObj;
    }

    public static void writeSP(String filePath, JsonSP jc)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        try
        {
            File file = new File(filePath);
            file.getParentFile().mkdirs();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, jc);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static List<JsonDomain> readArrayDomain(String filePath)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);
        List<JsonDomain> jsonList = null;
        try
        {
            jsonList = objectMapper.readValue(file, new TypeReference<List<JsonDomain>>(){});
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return jsonList;
    }

    public static void writeArrayDomain(String filePath, List<JsonDomain> lst)
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
