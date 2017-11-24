package com.venus.boot.orika;

import com.venus.boot.orika.model.PersonDestination;
import com.venus.boot.orika.model.PersonSource;
import ma.glasnost.orika.MapperFacade;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class VenusBootOrikaApplication implements ApplicationRunner {

    /**
     * The Orika's mapper interface.
     */
    private final MapperFacade orikaMapperFacade;

    public VenusBootOrikaApplication(MapperFacade orikaMapperFacade) {
      super();
      this.orikaMapperFacade = orikaMapperFacade;
    }

    /** {@inheritDoc} */
    @Override
    public void run(ApplicationArguments args) {

        PersonSource source = new PersonSource();
        source.setFirstName("John");
        source.setLastName("Smith");
        source.setAge(23);

        System.out.println(source);  // => "PersonSource(firstName=John, lastName=Smith, age=23)"
        PersonDestination destination = orikaMapperFacade.map(source, PersonDestination.class);
        System.out.println(destination);  // => "PersonDestination(givenName=John, sirName=Smith, age=23)"

    }

    public static void main(String[] args) {
        SpringApplication.run(VenusBootOrikaApplication.class, args);
    }

}
