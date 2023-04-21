package com.mr.nopi.concurrency.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public interface ConcurrencyApi {
    @RequestMapping(path = "/concurrences{isConcurrency}")
    void concurrencyCalculate(@PathVariable Boolean isConcurrency);
}
