package com.kinaltoys.dominio;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-07-21T17:31:49", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Noticias.class)
public class Noticias_ { 

    public static volatile SingularAttribute<Noticias, String> informacion;
    public static volatile SingularAttribute<Noticias, LocalDateTime> fechaNoticia;
    public static volatile SingularAttribute<Noticias, String> categoria;
    public static volatile SingularAttribute<Noticias, String> encabezado;
    public static volatile SingularAttribute<Noticias, Integer> codigoNoticia;

}