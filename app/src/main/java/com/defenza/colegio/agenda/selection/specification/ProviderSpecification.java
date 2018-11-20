package com.defenza.colegio.agenda.selection.specification;

import android.net.Uri;

/**
 * Representación de especificaciones basadas en SQL
 */

public interface ProviderSpecification extends Specification {

    Uri asProvider();
}
