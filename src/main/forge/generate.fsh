#  ##############  #
#  Install Addons  #
#  ##############  #
#  If the following plugins are not installed
#  addon-install-from-git --url https://github.com/forge/addon-arquillian.git --coordinate org.arquillian.forge:arquillian-addon



#  #####################  #
#  Creates a new project  #
#  #####################  #

project-new --named agoncal-application-cdbookstore --topLevelPackage org.agoncal.application.cdbookstore --finalName applicationCDBookStore ;


#  Setup the deployment descriptors to Java EE 7
#  ############
jpa-setup --persistenceUnitName applicationCDBookStorePU --jpaVersion 2.1 ;
cdi-setup --cdiVersion 1.1 ;
ejb-setup --ejbVersion 3.2 ;
faces-setup --facesVersion 2.2 ;
servlet-setup --servletVersion 3.1 ;
rest-setup --jaxrsVersion 2.0 ;

#  Setup Arquillian
#  ############
arquillian-setup --arquillianVersion 1.1.8.Final --testFramework junit --testFrameworkVersion 4.12 --containerAdapter wildfly-remote --containerAdapterVersion 8.2.1.Final ;



#  ########################  #
#  Creates the domain model  #
#  ########################  #

#  User role enumeration
#  ############
java-new-enum --named UserRole --targetPackage ~.model ;
java-new-enum-const USER ;
java-new-enum-const ADMIN ;


#  User entity
#  ############
jpa-new-entity --named User ;
jpa-new-field --named firstName --length 50 --columnName first_name --not-nullable ;
jpa-new-field --named lastName --length 50 --columnName last_name --not-nullable ;
jpa-new-field --named telephone ;
jpa-new-field --named email ;
jpa-new-field --named login --length 10 --not-nullable ;
jpa-new-field --named password --length 256 --not-nullable ;
jpa-new-field --named uuid --length 256 ;
jpa-new-field --named UserRole --type ~.model.UserRole --columnName user_role ;
jpa-new-field --named dateOfBirth --type java.util.Date --temporalType DATE --columnName date_of_birth ;
# Constraints
constraint-add --onProperty login --constraint NotNull ;
constraint-add --onProperty login --constraint Size --min 1 --max 10 ;
constraint-add --onProperty email --constraint NotNull ;
constraint-add --onProperty password --constraint NotNull ;
constraint-add --onProperty password --constraint Size --min 1 --max 256 ;
constraint-add --onProperty uuid --constraint Size --min 1 --max 256 ;
constraint-add --onProperty firstName --constraint NotNull ;
constraint-add --onProperty firstName --constraint Size --min 2 --max 50 ;
constraint-add --onProperty lastName --constraint NotNull ;
constraint-add --onProperty lastName --constraint Size --min 2 --max 50 ;
constraint-add --onProperty dateOfBirth --constraint Past ;


#  Package Vetoed
#  ############
java-new-package --named ~.model --createPackageInfo ;
# java-add-annotation --annotation javax.enterprie.inject.Vetoed --targetClass ~.model.package-info ;


