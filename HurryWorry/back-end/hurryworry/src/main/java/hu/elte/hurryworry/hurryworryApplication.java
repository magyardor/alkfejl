package hu.elte.hurryworry;

import java.util.TimeZone;
import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The hurryworryApplication class implements the Spring Boot application.
 * This class contains the only entry point of the application.
 *
 * @author eksztazidzsi
 */
@SpringBootApplication
public class hurryworryApplication {

    /**
     * The setTimeZoneToUTC method sets the JVM timezone to UTC.
     */
    @PostConstruct
    private void setTimeZoneToUTC() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    /**
     * The main method is the only entry point of the application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(hurryworryApplication.class, args);
    }
}
