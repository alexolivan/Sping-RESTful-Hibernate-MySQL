A very basic (vanilla as possible, and following IOC java guidelines as much as
possible in project structure), starting point, or reference project for a java 
web based backend, featuring:

- Spring Framework RESTful JSON web application
- Hibernate for JPA persistence
- MySQL as configured database

It consists of a single class: User
It features separated packaging for domain, controller, service, repository and
their implementations.
It allows basic CRUD operations on User class.
It enforces basic HTTP authentication on all operations (admin/admin).
It uses JSON on body to retrieve/send data.

REST Endpoints are:

GET /users -> get a list of all users
GET /users/{id} -> get some user by its id
POST /users -> add a new user (id is autogenerated)
POST /users/{id} -> updates user by id
DELETE /users/{id} -> deletes user by {id}


Note on libraries:
When deploying into glassfish 4.1, I needed to manually replace libraries 
by those newer ones bellow:

jboss-logging-3.3.0.Final.jar
jackson-annotations-2.6.3.jar      
jackson-core-2.6.3.jar	       
jackson-databind-2.6.3.jar
jackson-jaxrs-base-2.6.3.jar
jackson-jaxrs-json-provider-2.6.3.jar

Note on glassfish:
Ensure to create and configure a JDBC connection pool and resources on glassfish
Admin panel. Then update project config file to point to that connection.

Note on MySQL:
NO Hibernate auto database initialization in features in place... so, creating 
db, table, and updating annotations on java domain class acordingly is 
required.