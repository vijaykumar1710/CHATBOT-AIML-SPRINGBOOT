/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.main.testSudeep;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConfigReader {
  private final IconfigMapper configMapper;
  Map<String, String> defaults = Stream.of(new String[][] {
    { "displayFormat", "2x4" },
    { "brightness", "medium" },
    { "orientation", "landscape"}
  }).collect(Collectors.toMap(data -> data[0], data -> data[1]));


  public ConfigReader(IconfigMapper configMap) {
    configMapper = configMap;
    /**final JSONParser jsonParser = new JSONParser();
    try (FileReader reader = new FileReader("src/main/java/config.json"))
    {
      configObject = (JSONObject) jsonParser.parse(reader);
    } catch (final FileNotFoundException e) {
      System.out.println("File not found, all defaults assumed");
    } catch (final IOException e) {
      System.out.println("Error reading file, all defaults assumed");
    } catch (final ParseException e) {
      System.out.println("Error parsing file, all defaults assumed");
    }*/


  }
  public String getParameterValue(String parameterName)
  {
    String parameterValue = defaults.get(parameterName);
    if(configMapper.containsKey(parameterName)) {
      parameterValue = configMapper.get(parameterName);
    }
    return parameterValue;
  }

  //  public static void main(String[] args) {
  //    final ConfigReader confReader = new ConfigReader();
  //    System.out.println(confReader.getParameterValue("displayFormat"));
  //  }
}