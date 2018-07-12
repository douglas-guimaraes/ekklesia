package br.com.ipsamambaia.cadastromembrosserver.util;

import org.jboss.logging.Logger;

public interface Loggable {

    default Logger getLogger() {
        return Logger.getLogger(getClass());
    }
}
