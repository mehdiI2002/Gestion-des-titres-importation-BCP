package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.events.FileCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import java.io.File;
import java.nio.file.*;

@Service
public class WatchFolderServicesDefault implements WatchFolderServices {

    private final ApplicationEventPublisher eventPublisher;
    private static final Logger logger = LoggerFactory.getLogger("FilesLogger");
    @Autowired
    public WatchFolderServicesDefault(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }
   @Override
    public void fileswatcher() {
        Path path = Paths.get("C:\\Users\\lenovo\\OneDrive\\Desktop\\myDesktop\\BCP_PFE\\Livrable\\Files");
        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE);
            logger.info("Monitoring directory: " + path.toString());
            while (true) {
                WatchKey key = watchService.take();
                for (WatchEvent<?> event : key.pollEvents()) {//file d'attente
                    WatchEvent.Kind<?> kind = event.kind();
                    File file = new File(path.toAbsolutePath().toString(), event.context().toString());
                    if (kind == StandardWatchEventKinds.ENTRY_CREATE) {


                        eventPublisher.publishEvent(new FileCreatedEvent(this, file));
                        logger.info("File created: " + file.getName());
                    } else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
                        logger.info("File deleted: " + file.getName());
                    }
                }
                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}