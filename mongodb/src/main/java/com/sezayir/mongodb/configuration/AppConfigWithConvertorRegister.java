package com.sezayir.mongodb.configuration;


public class AppConfigWithConvertorRegister{
}
/*package com.sezayir.mongodb.configuration;


import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.mongodb.client.MongoClient;
import com.sezayir.mongodb.convertor.ZonedDateTimeReadConverter;
import com.sezayir.mongodb.convertor.ZonedDateTimeWriteConverter;

@Configuration
public class AppConfig extends AbstractMongoConfiguration {

    @Override
    public MongoClient mongoClient() {
        return new MongoClient("localhost");
    }

    @Override
    protected String getDatabaseName() {
        return "trackzilla";
    }

    @Bean
    public MongoTemplate getMongoTemplate() throws UnknownHostException {
        MappingMongoConverter converter = new MappingMongoConverter(
                new DefaultDbRefResolver(mongoDbFactory()), new MongoMappingContext());
        converter.setCustomConversions(customConversions());
        converter.afterPropertiesSet();
        return new MongoTemplate(mongoDbFactory(), converter);
    }

    public @Bean
    MongoDbFactory mongoDbFactory()  {
        return new SimpleMongoDbFactory(new MongoClient(), "trackzilla");
    }

     @Bean
     public ReleaseCascadeConvertMongoEventListener releaseCascadingMongoEventListener() {
        return new ReleaseCascadeConvertMongoEventListener();
     }

    @Bean
    public MongoCustomConversions customConversions() {
        List<Converter<?, ?>> converters = new ArrayList<>();
        converters.add(new ZonedDateTimeReadConverter());
        converters.add(new ZonedDateTimeWriteConverter());
        return new MongoCustomConversions(converters);
    }
    
}
*/