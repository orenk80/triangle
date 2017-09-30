package com.orenk.triangle.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SystemLoggerService {

    private static Logger logger = LoggerFactory.getLogger(SystemLoggerService.class);
    @Autowired
    StorageService storageService;

    @Scheduled(fixedRateString = "${system.logging.service.fixed.rate.ms}")
    public void logTrianglesCount(){
        Long entityCount = storageService.getEntityCount();
        logger.info("total entity count={}",entityCount);
    }
}
