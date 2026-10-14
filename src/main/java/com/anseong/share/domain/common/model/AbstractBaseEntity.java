package com.anseong.share.domain.common.model;

import java.io.Serializable;

public abstract class AbstractBaseEntity implements Serializable {

     private static final long serialVersionUID = -3597898281276406698L;

     public abstract boolean equals(Object o);

     public abstract int hashCode();

     public abstract String toString();
}
