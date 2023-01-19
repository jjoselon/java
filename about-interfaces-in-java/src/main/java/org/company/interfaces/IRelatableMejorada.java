package org.company.interfaces;

/**
 * Si queremos agregar nuevos funcionamientos (métodos abstractos) a nuestra interface {@link IRelatable}
 * podriamos simplemente adicionar nuevos métodos a nuestra interfaz pero eso obligaria a que todas sus
 * implementaciones deben implementar esta nueva funcionalidad.
 * Hay otra manera incluso recomendada por la documentación y es crear una nueva interfaz "mejorada" que extienda
 * esa interfaz (recordar que las interfaces extienden interfaces no implementan interfaces)
 *
 * Ahora los usuarios pueden optar por migrar a la nueva interfaz mejorada o seguir utilizando la anterior
 *
 * Hay otra manera de agregar nuevos métodos a la interfaz actual sin tener que obligar a sus implementaciones a
 * implementar los nuevos metodos; Definiendo métodos predeterminados (default)
 */
public interface IRelatableMejorada extends IRelatable {
    String doingSomethingElse();
}
