package com.mr.nopi.concurency.service.endpoint;

import com.mr.nopi.concurency.service.ConcurrencyService;
import com.mr.nopi.concurrency.api.ConcurrencyApi;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConcurrencyEndpoint implements ConcurrencyApi {
    private final ConcurrencyService service;

    public ConcurrencyEndpoint(ConcurrencyService service) {
        this.service = service;
    }

    @Override
    public void concurrencyCalculate(Boolean isConcurrency) {

    }
}
