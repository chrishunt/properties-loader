package net.progeny.uswdss.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.ArrayList;

public class PropertiesLoader {

  private final static String PROPERTIES_FILE = "config.properties";

  public static void main (String args[]) {
    // read properties from PROPERTIES_FILE
    Properties properties = new Properties();
    try {
      String filePath = PROPERTIES_FILE;
      if (System.getenv("CHCI_HOME") != null){
        filePath = System.getenv("CHCI_HOME") + "\\" + filePath;
      }
      System.out.println("FilePath: " + filePath);
      FileInputStream file = new FileInputStream(new File(filePath));
      properties.load(file);
      file.close();
    } catch (Exception e){
      System.out.println("Error reading properties file. Exiting.");
      System.exit(1);
    }
    
    ArrayList<String> flipList = new ArrayList<String>();
    if (properties.getProperty("flip") != null){
      String[] ids = properties.getProperty("flip").split(",");
      for (int i=0; i<ids.length; i++){
        flipList.add(ids[i].trim());
      }
    }

    if (flipList.contains("nsms5")){
      System.out.println("YES!");
    } else {
      System.out.println("NO!");
    }

    System.out.println("Done.");
    System.exit(0);
  }
}
