package com.defenza.colegio.agenda.selection.specification;

/**
 * Patrón de especificación para los productos
 */
public interface MemorySpecification<T> extends Specification{
    boolean isSatisfiedBy(T item);
}
