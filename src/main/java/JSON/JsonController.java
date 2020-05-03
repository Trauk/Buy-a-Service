package JSON;

import org.json.*;
import org.json.simple.parser.*;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class JsonController
{
    private JSONObject jsonData;
    private String fileName;
    public JsonController(String fileName)
    {
        this.jsonData = new JSONObject();
        this.fileName = fileName;
    }

    public void writeJson()
    {
        try (FileWriter file = new FileWriter(this.fileName)) {

            file.write(jsonData.toString(4));
            file.flush();

        } catch (IOException err) {
            err.printStackTrace();
        }
    }
    public void writeJson(String fileName)
    {
        try (FileWriter file = new FileWriter(fileName)) {

            file.write(jsonData.toString(4));
            file.flush();

        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    public void readJson()
    {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(this.fileName))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            jsonData = (JSONObject) obj;
            System.out.println(jsonData);
            //JSONArray dataList = (JSONArray) obj;
            //System.out.println(dataList);
            //Iterate over employee array
            //dataList.forEach( el -> parseFunction( (JSONObject) el ) );

        } catch (Exception err) {
            err.printStackTrace();
        }

    }
    public void readJson(String fileName)
    {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(fileName))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray dataList = (JSONArray) obj;
            //Iterate over employee array
            dataList.forEach( el -> parseFunction( (JSONObject) el ) );

        } catch (Exception err) {
            err.printStackTrace();
        }
    }



    public abstract void parseFunction(JSONObject obj);

}
