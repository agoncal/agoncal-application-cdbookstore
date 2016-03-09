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
jpa-setup --persistenceUnitName applicationCDBookStorePostgresPU --dataSourceName java:jboss/datasources/PostgresDS --dbType POSTGRES --schemaGenerationType DROP_CREATE ;

cdi-setup --cdiVersion 1.1 ;
ejb-setup --ejbVersion 3.2 ;
faces-setup --facesVersion 2.2 ;
servlet-setup --servletVersion 3.1 ;
rest-setup --jaxrsVersion 2.0 ;
# TODO constraint-setup --beanValidation 1.1

#  Setup Arquillian
#  ############
arquillian-setup --arquillianVersion 1.1.11.Final --testFramework junit --testFrameworkVersion 4.12 --containerAdapter wildfly-remote --containerAdapterVersion 8.2.1.Final ;



#  ########################  #
#  Creates the domain model  #
#  ########################  #


#  Constraints
#  ############
constraint-new-annotation --named Email ;
constraint-new-annotation --named NotEmpty ;


#  Country entity
#  ############
jpa-new-entity --named Country ;
jpa-new-field --named isoCode --length 2 --columnName iso_code --not-nullable ;
jpa-new-field --named name --length 80 --not-nullable ;
jpa-new-field --named printableName --length 80 --columnName printable_name --not-nullable ;
jpa-new-field --named iso3 --length 3 ;
jpa-new-field --named numcode --length 3 ;
# Constraints
constraint-add --onProperty isoCode --constraint NotNull ;
constraint-add --onProperty isoCode --constraint Size --min 2 --max 2 ;
constraint-add --onProperty name --constraint NotNull ;
constraint-add --onProperty name --constraint Size --min 2 --max 80 ;
constraint-add --onProperty printableName --constraint NotNull ;
constraint-add --onProperty printableName --constraint Size --min 2 --max 80 ;
constraint-add --onProperty iso3 --constraint NotNull ;
constraint-add --onProperty iso3 --constraint Size --min 3 --max 3 ;
constraint-add --onProperty numcode --constraint NotNull ;
constraint-add --onProperty numcode --constraint Size --min 3 --max 3 ;
# Cache
java-add-annotation --annotation javax.persistence.Cacheable ;


#  Address embeddable
#  ############
jpa-new-embeddable --named Address ;
jpa-new-field --named street1 --length 50 --not-nullable ;
jpa-new-field --named street2 ;
jpa-new-field --named city  --length 50 --not-nullable ;
jpa-new-field --named state ;
jpa-new-field --named zipcode --columnName zip_code --length 10 --not-nullable ;
# Relationships
# TODO FORGE-2464
# jpa-new-field --named country --type ~.model.Country --relationshipType Many-to-One ;
jpa-new-field --named country --type org.agoncal.application.cdbookstore.model.Country --relationshipType Many-to-One ;
# Constraints
constraint-add --onProperty street1 --constraint Size --min 5 --max 50 ;
constraint-add --onProperty street1 --constraint NotNull ;
constraint-add --onProperty city --constraint Size --min 2 --max 50 ;
constraint-add --onProperty city --constraint NotNull ;
constraint-add --onProperty zipcode --constraint Size --min 1 --max 10 ;
constraint-add --onProperty zipcode --constraint NotNull ;
constraint-add --onProperty country --constraint NotNull ;


#  CreditCardType enumeration
#  ############
java-new-enum --named CreditCardType --targetPackage ~.model ;
java-new-enum-const VISA ;
java-new-enum-const MASTER_CARD ;
java-new-enum-const AMERICAN_EXPRESS ;


#  CreditCardType converter
#  ############
# TODO being able to create a converter
java-new-class --named CreditCardConverter --targetPackage ~.model ;


# CreditCard embeddable
# ############
jpa-new-embeddable --named CreditCard ;
jpa-new-field --named creditCardNumber --columnName credit_card_number --length 30 --not-nullable ;
# TODO
# jpa-new-field --named creditCardType --type ~.model.CreditCardType --columnName credit_card_type ;
jpa-new-field --named creditCardType --type org.agoncal.application.cdbookstore.model.CreditCardType --columnName credit_card_type ;
jpa-new-field --named creditCardExpDate --columnName credit_card_expiry_date --length 5 --not-nullable ;
# Constraints
constraint-add --onProperty creditCardNumber --constraint NotNull ;
constraint-add --onProperty creditCardNumber --constraint Size --min 1 --max 30 ;
constraint-add --onProperty creditCardType --constraint NotNull ;
constraint-add --onProperty creditCardExpDate --constraint NotNull ;
constraint-add --onProperty creditCardExpDate --constraint Size --min 1 --max 5 ;


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
# jpa-new-field --named role --type ~.model.UserRole --columnName user_role
jpa-new-field --named role --type org.agoncal.application.cdbookstore.model.UserRole --columnName user_role ;
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
# Lifecycle
java-new-method --methodName digestPassword --accessType public --returnType void ;
java-add-annotation --annotation javax.persistence.PostPersist --onMethod digestPassword ;


#  Language enum
#  ############
java-new-enum --named Language --targetPackage ~.model ;
java-new-enum-const ENGLISH ;
java-new-enum-const FRENCH ;
java-new-enum-const SPANISH ;
java-new-enum-const PORTUGUESE ;
java-new-enum-const ITALIAN ;
java-new-enum-const FINISH ;
java-new-enum-const GERMAN ;
java-new-enum-const DEUTSCH ;
java-new-enum-const RUSSIAN ;

#  Artist Mapped Superclass
#  ############
jpa-new-mapped-superclass --named Artist ;
jpa-new-field --named firstName --length 50 --columnName first_name  --not-nullable ;
jpa-new-field --named lastName --length 50 --columnName last_name --not-nullable ;
jpa-new-field --named bio --length 5000 ;
jpa-new-field --named dateOfBirth --type java.util.Date --temporalType DATE --columnName date_of_birth ;
jpa-new-field --named age --type java.lang.Integer --transient ;
# Constraints
constraint-add --onProperty firstName --constraint NotNull ;
constraint-add --onProperty firstName --constraint Size --min 2 --max 50 ;
constraint-add --onProperty lastName --constraint NotNull ;
constraint-add --onProperty lastName --constraint Size --min 2 --max 50 ;
constraint-add --onProperty bio --constraint Size --max 5000 ;
constraint-add --onProperty dateOfBirth --constraint Past ;
# Lifecycle
java-new-method --methodName calculateAge --accessType private --returnType void ;
java-add-annotation --annotation javax.persistence.PostLoad --onMethod calculateAge ;
java-add-annotation --annotation javax.persistence.PostPersist --onMethod calculateAge ;
java-add-annotation --annotation javax.persistence.PostUpdate --onMethod calculateAge ;


#  Author Entity
#  ############
jpa-new-entity --named Author ;

# TODO extends Artist
jpa-new-field --named firstName --length 50 --columnName first_name  --not-nullable ;
jpa-new-field --named lastName --length 50 --columnName last_name --not-nullable ;
jpa-new-field --named bio --length 5000 ;
jpa-new-field --named dateOfBirth --type java.util.Date --temporalType DATE --columnName date_of_birth ;
jpa-new-field --named age --type java.lang.Integer --transient ;
constraint-add --onProperty firstName --constraint NotNull ;
constraint-add --onProperty firstName --constraint Size --min 2 --max 50 ;
constraint-add --onProperty lastName --constraint NotNull ;
constraint-add --onProperty lastName --constraint Size --min 2 --max 50 ;
constraint-add --onProperty bio --constraint Size --max 5000 ;
constraint-add --onProperty dateOfBirth --constraint Past ;

# TODO FORGE-2464
# jpa-new-field --named preferredLanguage --type ~.model.Language ;
jpa-new-field --named preferredLanguage --type org.agoncal.application.cdbookstore.model.Language --columnName preferred_language ;


#  Musician Entity
#  ############
jpa-new-entity --named Musician ;

# TODO extends Artist
jpa-new-field --named firstName --length 50 --columnName first_name  --not-nullable ;
jpa-new-field --named lastName --length 50 --columnName last_name --not-nullable ;
jpa-new-field --named bio --length 5000 ;
jpa-new-field --named dateOfBirth --type java.util.Date --temporalType DATE --columnName date_of_birth ;
jpa-new-field --named age --type java.lang.Integer --transient ;
constraint-add --onProperty firstName --constraint NotNull ;
constraint-add --onProperty firstName --constraint Size --min 2 --max 50 ;
constraint-add --onProperty lastName --constraint NotNull ;
constraint-add --onProperty lastName --constraint Size --min 2 --max 50 ;
constraint-add --onProperty bio --constraint Size --max 5000 ;
constraint-add --onProperty dateOfBirth --constraint Past ;

jpa-new-field --named preferredInstrument  --columnName preferred_instrument ;


#  Publisher Entity
#  ############
jpa-new-entity --named Publisher ;
jpa-new-field --named name --length 30 ;
# Constraints
constraint-add --onProperty name --constraint NotNull ;
constraint-add --onProperty name --constraint Size --max 30 ;

#  Item Entity
#  ############
jpa-new-entity --named Item ;
jpa-new-field --named title --length 200 ;
jpa-new-field --named description --length 10000 ;
jpa-new-field --named unitCost --type java.lang.Float ;
jpa-new-field --named rank --type java.lang.Integer ;
jpa-new-field --named smallImageURL --columnName small_image_url ;
jpa-new-field --named mediumImageURL --columnName medium_image_url ;
# Constraints
constraint-add --onProperty title --constraint NotNull ;
constraint-add --onProperty title --constraint Size --min 1 --max 200 ;
constraint-add --onProperty description --constraint Size --min 1 --max 10000 ;
constraint-add --onProperty unitCost --constraint Min --value 1 ;


#  Category entity
#  ############
jpa-new-entity --named Category ;
jpa-new-field --named name --length 100 ;
# Constraints
constraint-add --onProperty name --constraint NotNull ;
constraint-add --onProperty name --constraint Size --max 100 ;


#  Book Entity
#  ############
jpa-new-entity --named Book ;

# TODO extends Item
jpa-new-field --named title --length 200 ;
jpa-new-field --named description --length 10000 ;
jpa-new-field --named unitCost --type java.lang.Float ;
constraint-add --onProperty title --constraint NotNull ;
constraint-add --onProperty title --constraint Size --min 1 --max 200 ;
constraint-add --onProperty description --constraint Size --min 1 --max 10000 ;
constraint-add --onProperty unitCost --constraint Min --value 1 ;

jpa-new-field --named isbn --length 15 ;
jpa-new-field --named nbOfPage --type java.lang.Integer --columnName nb_of_pages ;
jpa-new-field --named publicationDate --type java.util.Date --temporalType DATE --columnName publication_date ;
# TODO FORGE-2464
# jpa-new-field --named language --type ~.model.Language ;
jpa-new-field --named language --type org.agoncal.application.cdbookstore.model.Language ;
# Relationships
# TODO FORGE-2464
jpa-new-field --named category --type org.agoncal.application.cdbookstore.model.Category --relationshipType Many-to-One ;
jpa-new-field --named authors --type org.agoncal.application.cdbookstore.model.Author --relationshipType One-to-Many ;
jpa-new-field --named publisher --type org.agoncal.application.cdbookstore.model.Publisher --relationshipType Many-to-One ;
# Constraints
constraint-add --onProperty isbn --constraint NotNull ;
constraint-add --onProperty isbn --constraint Size --max 15 ;
constraint-add --onProperty nbOfPage --constraint Min --value 1 ;


#  Genre entity
#  ############
jpa-new-entity --named Genre ;
jpa-new-field --named name --length 100 ;
# Constraints
constraint-add --onProperty name --constraint NotNull ;
constraint-add --onProperty name --constraint Size --max 100 ;

#  Label Entity
#  ############
jpa-new-entity --named Label ;
jpa-new-field --named name --length 30 ;
# Constraints
constraint-add --onProperty name --constraint NotNull ;
constraint-add --onProperty name --constraint Size --max 30 ;


#  CD Entity
#  ############
jpa-new-entity --named CD ;

# TODO extends Item
jpa-new-field --named title --length 200 ;
jpa-new-field --named description --length 10000 ;
jpa-new-field --named unitCost --type java.lang.Float ;
constraint-add --onProperty title --constraint NotNull ;
constraint-add --onProperty title --constraint Size --min 1 --max 200 ;
constraint-add --onProperty description --constraint Size --min 1 --max 10000 ;
constraint-add --onProperty unitCost --constraint Min --value 1 ;

jpa-new-field --named nbOfDiscs --type java.lang.Integer --columnName nb_of_discs ;
# TODO FORGE-2464
jpa-new-field --named label --type org.agoncal.application.cdbookstore.model.Label --relationshipType Many-to-One ;
jpa-new-field --named musicians --type org.agoncal.application.cdbookstore.model.Musician --relationshipType Many-to-Many ;
jpa-new-field --named genre --type org.agoncal.application.cdbookstore.model.Genre --relationshipType Many-to-One ;


#  Musician Entity
#  ############
cd ../Musician.java ;
jpa-new-field --named cds --type org.agoncal.application.cdbookstore.model.CD --relationshipType Many-to-Many ;


#  OrderLine entity
#  ############
jpa-new-entity --named OrderLine --tableName order_line ;
jpa-new-field --named quantity --type java.lang.Integer --not-nullable;
# Relationships
jpa-new-field --named item --type org.agoncal.application.cdbookstore.model.Item --relationshipType Many-to-One --cascadeType PERSIST ;
# Constraints
constraint-add --onProperty quantity --constraint Min --value 1 ;


#  PurchaseOrder entity
#  ############
jpa-new-entity --named PurchaseOrder --tableName purchase_order ;
jpa-new-field --named orderDate --type java.util.Date --temporalType DATE --columnName order_date --not-updatable ;
jpa-new-field --named totalWithoutVat --type java.lang.Float ;
jpa-new-field --named vatRate --type java.lang.Float --columnName vat_rate ;
jpa-new-field --named vat --type java.lang.Float ;
jpa-new-field --named totalWithVat --type java.lang.Float ;
jpa-new-field --named total --type java.lang.Float ;
# Relationships
# TODO FORGE-2466
jpa-new-field --named customer --type org.agoncal.application.cdbookstore.model.User --relationshipType Many-to-One ;
jpa-new-field --named orderLines --type org.agoncal.application.cdbookstore.model.OrderLine --relationshipType One-to-Many ;
# Constraints
constraint-add --constraint Past --onProperty orderDate ;


# TODO being able to add an embeddable for scaffolding
# Address embeddable
jpa-new-field --named street1 --length 50 ;
jpa-new-field --named street2 ;
jpa-new-field --named city --length 50 ;
jpa-new-field --named state ;
jpa-new-field --named zipcode --columnName zip_code --length 10 ;
constraint-add --constraint NotNull --onProperty street1 ;
constraint-add --constraint Size --min 5 --max 50 --onProperty street1 ;
constraint-add --constraint NotNull --onProperty city ;
constraint-add --constraint Size --min 5 --max 50 --onProperty city ;
constraint-add --constraint NotNull --onProperty zipcode ;
constraint-add --constraint Size --min 1 --max 10 --onProperty zipcode ;

# Credit card embeddable
# TODO being able to add an embeddable for scaffolding
jpa-new-field --named creditCardNumber --columnName credit_card_number ;
jpa-new-field --named creditCardType --type org.agoncal.application.cdbookstore.model.CreditCardType --columnName credit_card_type ;
jpa-new-field --named creditCardExpDate --columnName credit_card_expiry_date  ;
constraint-add --constraint NotNull --onProperty creditCardNumber ;
constraint-add --constraint Size --min 1 --max 30 --onProperty creditCardNumber ;
constraint-add --constraint NotNull --onProperty creditCardType ;
constraint-add --constraint NotNull --onProperty creditCardExpDate ;
constraint-add --constraint Size --min 5 --max 5 --onProperty creditCardExpDate ;


#  Package Vetoed
#  ############
# TODO FORGE-2464
java-new-package --named org.agoncal.application.cdbookstore.model --createPackageInfo ;
# java-add-annotation --annotation javax.enterprie.inject.Vetoed --targetClass ~.model.package-info ;



#  #######################  #
#  Creates utility classes  #
#  #######################  #


#  Password Utils
#  ############
java-new-class --named PasswordUtils --targetPackage ~.util ;
java-new-method --methodName digestPassword --returnType String --accessType public ;


#  Resource Producer
#  ############
java-new-class --named ResourceProducer --targetPackage ~.util ;

java-new-method --methodName produceFacesContext --returnType javax.faces.context.FacesContext --accessType private ;
java-add-annotation --annotation javax.enterprise.inject.Produces --onMethod produceFacesContext ;
java-add-annotation --annotation javax.enterprise.context.RequestScoped --onMethod produceFacesContext ;

java-new-method --methodName produceHttpServletResponse --returnType javax.servlet.http.HttpServletResponse --accessType private ;
java-add-annotation --annotation javax.enterprise.inject.Produces --onMethod produceHttpServletResponse ;
java-add-annotation --annotation javax.enterprise.context.RequestScoped --onMethod produceHttpServletResponse ;

java-new-method --methodName produceLogger --returnType java.util.logging.Logger --accessType private ;
java-add-annotation --annotation javax.enterprise.inject.Produces --onMethod produceLogger ;


#  Logging Interceptor
#  ############
cdi-new-interceptor-binding --named Loggable --targetPackage ~.util ;
# TODO --interceptorBinding does not have autocompletion
cdi-new-interceptor --named LoggingInterceptor --interceptorBinding org.agoncal.application.cdbookstore.util.Loggable --targetPackage ~.util ;
cdi-add-injection-point --named logger --type java.util.logging.Logger ;


#  Exception Interceptor
#  ############
cdi-new-interceptor-binding --named CatchException --targetPackage ~.view.util ;
# TODO FORGE-2466
# cdi-new-interceptor --named CatchExceptionInterceptor --interceptorBinding ~.view.util.CatchException  --targetPackage ~.view.util ;
cdi-new-interceptor --named CatchExceptionInterceptor --interceptorBinding org.agoncal.application.cdbookstore.view.util.CatchException  --targetPackage ~.view.util ;
cdi-add-injection-point --named logger --type java.util.logging.Logger ;


#  Number generators interface and qualifier
#  ############
cdi-new-qualifier --named EightDigits --targetPackage ~.util ;
cdi-new-qualifier --named ThirteenDigits --targetPackage ~.util ;
cdi-new-qualifier --named Vat --targetPackage ~.util ;
cdi-new-qualifier --named Discount --targetPackage ~.util ;
java-new-interface --named NumberGenerator --targetPackage ~.util ;
java-new-method --methodName generateNumber --returnType String --accessType public ;


#  IsbnGenerator
#  ############
# TODO FORGE-2466
cdi-new-bean --named IsbnGenerator --qualifier org.agoncal.application.cdbookstore.util.ThirteenDigits --targetPackage ~.util ;
cdi-add-injection-point --named logger --type java.util.logging.Logger ;
# TODO FORGE-2466
cdi-add-injection-point --named prefix --type String --qualifiers org.agoncal.application.cdbookstore.util.ThirteenDigits ;
cdi-add-injection-point --named postfix --type int --qualifiers org.agoncal.application.cdbookstore.util.ThirteenDigits ;
# TODO Implement interface
java-new-method --methodName generateNumber --returnType String --accessType public ;

#  IssnGenerator
#  ############
cdi-new-bean --named IssnGenerator --qualifier org.agoncal.application.cdbookstore.util.EightDigits --targetPackage ~.util ;
cdi-add-injection-point --named logger --type java.util.logging.Logger ;
# TODO FORGE-2466
cdi-add-injection-point --named prefix --type String --qualifiers org.agoncal.application.cdbookstore.util.EightDigits ;
cdi-add-injection-point --named postfix --type int --qualifiers org.agoncal.application.cdbookstore.util.EightDigits ;
# TODO Implement interface
java-new-method --methodName generateNumber --returnType String --accessType public ;


#  Number producer
#  ############
java-new-class --named NumberProducer --targetPackage org.agoncal.application.cdbookstore.util ;
# TODO producers
java-new-field --named prefix1 --generateGetter=false --generateSetter=false --updateToString=false ;
java-add-annotation --annotation javax.enterprise.inject.Produces --onProperty prefix1 ;
java-add-annotation --annotation org.agoncal.application.cdbookstore.util.ThirteenDigits --onProperty prefix1 ;
java-new-field --named postfix1 --type int --generateGetter=false --generateSetter=false --updateToString=false ;
java-add-annotation --annotation javax.enterprise.inject.Produces --onProperty postfix1 ;
java-add-annotation --annotation org.agoncal.application.cdbookstore.util.ThirteenDigits --onProperty postfix1 ;

java-new-field --named prefix2 --generateGetter=false --generateSetter=false --updateToString=false ;
java-add-annotation --annotation javax.enterprise.inject.Produces --onProperty prefix2 ;
java-add-annotation --annotation org.agoncal.application.cdbookstore.util.EightDigits --onProperty prefix2 ;
java-new-field --named postfix2 --type int --generateGetter=false --generateSetter=false --updateToString=false ;
java-add-annotation --annotation javax.enterprise.inject.Produces --onProperty postfix2 ;
java-add-annotation --annotation org.agoncal.application.cdbookstore.util.EightDigits --onProperty postfix2 ;

java-new-field --named prefix3 --generateGetter=false --generateSetter=false --updateToString=false ;
java-add-annotation --annotation javax.enterprise.inject.Produces --onProperty prefix3 ;
java-add-annotation --annotation org.agoncal.application.cdbookstore.util.ThirteenDigits --onProperty prefix3 ;
java-add-annotation --annotation org.agoncal.application.cdbookstore.util.EightDigits --onProperty prefix3 ;
java-add-annotation --annotation javax.enterprise.inject.Alternative --onProperty prefix3 ;

java-new-field --named postfix3 --type int --generateGetter=false --generateSetter=false --updateToString=false ;
java-add-annotation --annotation javax.enterprise.inject.Produces --onProperty postfix3 ;
java-add-annotation --annotation org.agoncal.application.cdbookstore.util.ThirteenDigits --onProperty postfix3 ;
java-add-annotation --annotation org.agoncal.application.cdbookstore.util.EightDigits --onProperty postfix3 ;
java-add-annotation --annotation javax.enterprise.inject.Alternative --onProperty postfix3 ;

java-new-field --named vatRate --type java.lang.Float --generateGetter=false --generateSetter=false --updateToString=false ;
java-add-annotation --annotation javax.enterprise.inject.Produces --onProperty vatRate ;
java-add-annotation --annotation org.agoncal.application.cdbookstore.util.Vat --onProperty vatRate ;
java-add-annotation --annotation javax.inject.Named --onProperty vatRate ;

java-new-field --named discountRate --type java.lang.Float --generateGetter=false --generateSetter=false --updateToString=false ;
java-add-annotation --annotation javax.enterprise.inject.Produces --onProperty discountRate ;
java-add-annotation --annotation org.agoncal.application.cdbookstore.util.Discount --onProperty discountRate ;
java-add-annotation --annotation javax.inject.Named --onProperty discountRate ;


#  #############################  #
#  Generates JSF beans and pages  #
#  #############################  #

# TODO ~ 
scaffold-generate --provider Faces --webRoot /admin --targets org.agoncal.application.cdbookstore.model.* ;
faces-new-bean --named AccountBean --scoped SESSION ;
# TODO
# faces-add-method --named doSignup --outcome index ;
# faces-add-method --named doSignin ;
# faces-add-method --named doLogout --outcome index ;
# faces-add-method --named doForgotPassword ;
# faces-add-method --named doUpdateProfile ;

java-new-field --named loggedIn --type boolean --updateToString=false ;
java-new-field --named admin --type boolean --updateToString=false ;
java-new-field --named rememberMe --type boolean --updateToString=false ;
java-new-field --named password1 --type String --updateToString=false ;
java-new-field --named password2 --type String --updateToString=false ;



#  ########################  #
#  Generates REST endpoints  #
#  ########################  #

# TODO ~
rest-generate-endpoints-from-entities --contentType application/xml application/json --targets org.agoncal.application.cdbookstore.model.CD ;
rest-generate-endpoints-from-entities --contentType application/xml application/json --targets org.agoncal.application.cdbookstore.model.Book ;

#  #########################  #
#  Generate Arquillian tests
#  #########################  #


# JSF Beacking Beans
# ##################

# TODO ~
arquillian-create-test --enableJPA --targets org.agoncal.application.cdbookstore.view.* ;


# REST Endpoints
# ##############

# TODO ~
arquillian-create-test --enableJPA --targets org.agoncal.application.cdbookstore.rest.* ;



#  ##################  #
#  Cleans the pom.xml  #
#  ##################  #
project-remove-dependencies org.hibernate.javax.persistence:hibernate-jpa-2.1-api:jar:: ;
project-remove-dependencies javax.enterprise:cdi-api:jar:: ;
project-remove-dependencies javax.ejb:javax.ejb-api:jar:: ;
project-remove-dependencies javax.faces:javax.faces-api:jar:: ;
project-remove-dependencies javax.servlet:javax.servlet-api:jar:: ;
project-remove-dependencies javax.validation:validation-api:jar:: ;
project-remove-dependencies javax.ws.rs:javax.ws.rs-api:jar:: ;

project-remove-managed-dependencies org.hibernate.javax.persistence:hibernate-jpa-2.1-api:jar::1.0.0.Draft-16 ;
project-remove-managed-dependencies javax.enterprise:cdi-api:jar::1.1 ;
project-remove-managed-dependencies javax.ejb:javax.ejb-api:jar::3.2 ;
project-remove-managed-dependencies javax.faces:javax.faces-api:jar::2.2 ;
project-remove-managed-dependencies javax.servlet:javax.servlet-api:jar::3.1.0 ;
project-remove-managed-dependencies org.jboss.spec:jboss-javaee-6.0:pom::3.0.3.Final ;
project-remove-managed-dependencies javax.ws.rs:javax.ws.rs-api:jar::2.0 ;

#  Adding Java EE and Web Jars dependencies
#  ############################
project-add-dependencies com.thedeanda:lorem:2.0 ;
project-add-dependencies org.webjars:bootstrap:3.3.6 ;
project-add-dependencies org.webjars:jquery:2.1.4 ;
project-add-dependencies org.primefaces:primefaces:5.3 ;
project-add-dependencies org.jboss.spec:jboss-javaee-7.0:1.0.3.Final:provided:pom ;
project-add-dependencies org.jboss.resteasy:resteasy-client:3.0.12.Final:test ;

#  Adding repositories
#  ############################
project-add-repository --named jboss-public --url https://repository.jboss.org/nexus/content/groups/public/ ;


