package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.events.FileCreatedEvent;
import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import java.io.File;
import java.nio.file.*;

@Service
public class WatchFolder implements FileServices {

    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public WatchFolder(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }
    @Override
    public DemandeDomiciliationMessage parseFile(File file) {
        return null;
    }
@Override
    public void fileswatcher() {
        Path path = Paths.get("C:\\Users\\lenovo\\OneDrive\\Desktop\\myDesktop\\BCP PFE\\Livrable\\Files");
        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
            System.out.println("Monitoring directory: " + path.toString());

            while (true) {
                WatchKey key = watchService.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                        File createdFile = new File(path.toAbsolutePath().toString(), event.context().toString());
                        eventPublisher.publishEvent(new FileCreatedEvent(this, createdFile));
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