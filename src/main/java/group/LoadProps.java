package group;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProps {

    static Properties props;
    static FileInputStream inputstream;

    public String getProperty(String key){

        props = new Properties();

        try {
            inputstream = new FileInputStream("src\\main\\Resources\\Browserdriver\\testdataconfig.properties");
            try {
                props.load(inputstream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        {
        }
        return props.getProperty(key);
    }
}
