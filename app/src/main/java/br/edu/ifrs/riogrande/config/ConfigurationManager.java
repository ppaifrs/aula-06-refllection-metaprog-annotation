package br.edu.ifrs.riogrande.config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Properties;
import java.util.Scanner;

public class ConfigurationManager {

  private final Properties properties;

  public ConfigurationManager() {
    // try-with-resources, fecha o recurso automaticamente
    try (InputStream inputStream = ConfigurationManager.class
        .getClassLoader()
        .getResourceAsStream("configuration.properties")) {

      this.properties = new Properties();
      this.properties.load(inputStream);

    } catch (IOException e) {
      throw new RuntimeException(e); // re-throw
    }
  }

  public Optional<Integer> getInteger(String prop) {
    return get(prop).map(Integer::parseInt);
  }

  // design de API
  public Optional<String> get(String prop) {
    return Optional
      .ofNullable(this.properties.getProperty(prop));
  }
  
  public String get(String prop, String defaultValue) {
    return get(prop).orElse(defaultValue);
  }
 
    // System.out.println("ENV----------------------");
    // System.out.println(System.getenv());
}
