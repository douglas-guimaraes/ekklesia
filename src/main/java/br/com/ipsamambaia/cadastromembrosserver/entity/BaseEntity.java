package br.com.ipsamambaia.cadastromembrosserver.entity;

import java.io.Serializable;

public abstract class BaseEntity<PK extends Serializable> implements Serializable {

    private static final long serialVersionUID = -3783090506212908384L;

    public abstract PK getId();

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return getId().equals(((BaseEntity<?>) obj).getId());
    }
    
    
}
