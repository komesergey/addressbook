package com.addressbook.ignite;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class GridStarter implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(GridStarter.class);

    @Override
    public void onApplicationEvent(@NotNull ContextRefreshedEvent event) {
        logger.info("--------------- Ignite client node startup -----------------");
        GridDAO.startClient();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.info("--------------- Ignite client node shutdown -----------------");
            try {
                Thread.sleep(5_000);
            } catch (Exception e) {
                logger.error("Error during Ignite client shutdown", e);
            }
            GridDAO.stopClient();
        }));
    }
}