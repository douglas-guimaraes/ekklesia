package br.com.ipsamambaia.cadastromembrosserver.dto;

import java.io.Serializable;

public abstract class BaseDTO<PK extends Serializable> implements Serializable {

    public abstract PK getId();
}
