package io.spring.demo.issuedashboard.organisation;

import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

import java.util.UUID;

@Component
public class OrganisationIdToStringConvertor implements Converter<String,OrganisationId>{

    @Override
    public OrganisationId convert(String s) {
        return new OrganisationId(UUID.fromString(s)); //<.>
    }
}
