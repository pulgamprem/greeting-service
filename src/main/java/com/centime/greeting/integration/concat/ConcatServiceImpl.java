package com.centime.greeting.integration.concat;

import com.centime.greeting.infrastructure.web.RequestContext;
import com.centime.greeting.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.centime.greeting.infrastructure.web.RequestContext.CORRELATION_ID_KEY;

@Service
public class ConcatServiceImpl implements ConcatService {

    @Autowired
    private ConcatClient concatClient;

    @Override
    public String concat(PersonDTO person) {
        return concatClient.concat(RequestContext.get(CORRELATION_ID_KEY), person);
    }
}
