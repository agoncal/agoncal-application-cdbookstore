package org.agoncal.application.cdbookstore.model;

import javax.persistence.Persistence;
import java.util.logging.Logger;

/**
 * @author Antonio Goncalves
 *         Training - Beginning with The Java EE 7 Platform
 *         http://www.antoniogoncalves.org
 *         --
 * For this class to work, enable the EclipseLink and Derby dependencies in the pom.xml
 */
public class JPASchemaGen {

    // ======================================
    // =             Attributes             =
    // ======================================

    private static final Logger logger = Logger.getLogger(JPASchemaGen.class.getName());

    private static String PERSISTENCE_UNIT_NAME = "applicationCDBookStoreGenPU";

    // ======================================
    // =          Business methods          =
    // ======================================

    public static void main(String[] args) {

        Persistence.generateSchema(PERSISTENCE_UNIT_NAME, null);

        logger.info("DDL have been generated");
    }
}


