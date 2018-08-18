package br.com.ipsamambaia.cadastromembrosserver.util;

import br.com.ipsamambaia.cadastromembrosserver.dto.BaseDTO;

public class DTOUtil {

    public static boolean valid(BaseDTO<Long> entity) {
        return entity != null
                && entity.getId() != null
                && entity.getId() != 0L;
    }
}
