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
java-new-enum --named UserRole --targetPackage ~.model
java-new-enum-const USER ;
java-new-enum-const ADMIN ;


#  User entity
#  ############
jpa-new-entity --named User --tableName t_user ;
jpa-new-named-query --named User.findByEmail --query 'SELECT u FROM User u WHERE u.email = :email' ;
jpa-new-named-query --named User.findByUUID --query 'SELECT u FROM User u WHERE u.uuid = :uuid' ;
jpa-new-named-query --named User.findByLogin --query 'SELECT u FROM User u WHERE u.login = :login' ;
jpa-new-named-query --named User.findByLoginPassword --query 'SELECT u FROM User u WHERE u.login = :login AND u.password = :password' ;
jpa-new-named-query --named User.findAll --query 'SELECT u FROM User u' ;
jpa-new-field --named firstName --length 50 --columnName first_name --not-nullable ;
jpa-new-field --named lastName --length 50 --columnName last_name --not-nullable ;
jpa-new-field --named telephone ;
jpa-new-field --named email ;
jpa-new-field --named login --length 10 --not-nullable ;
jpa-new-field --named password --length 256 --not-nullable ;
jpa-new-field --named uuid --length 256 ;
# TODO FORGE-2464
# jpa-new-field --named UserRole --type ~.model.UserRole --columnName user_role
jpa-new-field --named UserRole --type org.agoncal.application.cdbookstore.model.UserRole --columnName user_role ;
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



#  #######################  #
#  Creates utility classes  #
#  #######################  #

#  Resource Producer
#  ############
java-new-class --named ResourcProducer --targetPackage ~.util ;

java-new-method --methodName produceFacesContext --returnType javax.faces.context.FacesContext --accessType private ;
java-add-annotation --annotation javax.enterprise.inject.Produces --onMethod produceFacesContext ;

java-new-method --methodName produceHttpServletResponse --returnType javax.servlet.http.HttpServletResponse --accessType private ;
java-add-annotation --annotation javax.enterprise.inject.Produces --onMethod produceHttpServletResponse ;

java-new-method --methodName produceLogger --returnType java.util.logging.Logger --accessType private ;
java-add-annotation --annotation javax.enterprise.inject.Produces --onMethod produceLogger ;


#  Exception
#  ############
cdi-new-interceptor-binding --named CatchException --targetPackage ~.view.util ;
# TODO FORGE-2466
# cdi-new-interceptor --named CatchExceptionInterceptor --interceptorBinding ~.view.util.CatchException  --targetPackage ~.view.util ;
cdi-new-interceptor --named CatchExceptionInterceptor --interceptorBinding org.agoncal.application.cdbookstore.view.util.CatchException  --targetPackage ~.view.util ;
cdi-add-injection-point --named logger --type java.util.logging.Logger ;