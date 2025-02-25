package org.gestiondestitresimportationbcp.events;

import org.springframework.context.ApplicationEvent;

import java.io.File;

    public class FileCreatedEvent extends ApplicationEvent {
        private final File file;

        public FileCreatedEvent(Object source, File file) {
            super(source);
            this.file = file;
        }
        public File getFile() {
            return file;
        }

}
