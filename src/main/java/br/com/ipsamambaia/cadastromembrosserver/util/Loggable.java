package br.com.ipsamambaia.cadastromembrosserver.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public interface Loggable {

    default Log getLogger() {
        return LogFactory.getLog(getClass());
    }
}

