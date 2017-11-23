package com.venus.boot.orika.mapping;

import com.venus.boot.orika.OrikaMapperFactoryConfigurer;
import com.venus.boot.orika.model.PersonDestination;
import com.venus.boot.orika.model.PersonSource;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class PersonMapping implements OrikaMapperFactoryConfigurer {

    /** {@inheritDoc} */
    @Override
    public void configure(MapperFactory orikaMapperFactory) {
        orikaMapperFactory.classMap(PersonSource.class, PersonDestination.class)
                .field("firstName", "givenName")
                .field("lastName", "sirName")
                .byDefault()
                .register();
    }

}
