package org.gestiondestitresimportationbcp.events;

import org.springframework.context.ApplicationEvent;

public class FileAddedEvent extends ApplicationEvent {
    private String filePath;

    public FileAddedEvent(Object source, String filePath) {
        super(source);
        this.filePath = filePath;
    }
    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
