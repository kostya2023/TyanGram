package org.konstantin.tyangram;

public interface GenericProvider<F, T> {
    T provide(F obj);
}
