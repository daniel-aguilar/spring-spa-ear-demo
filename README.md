# Spring Boot Single Page Application (SPA) EAR Demo

The following is a demonstration of serving a single page application
(SPA) by the same Spring Web MVC servlet, packaged as an EAR for
enterprise application servers.

The SPA sources are placed in the `webapp` directory, which is
convinient for hot-reloading (i.e. you don't need to restart the java
app to reload front-end changes).

The most significant configuration is the use of a servlet filter to
programatically redirect requests based on a list of "reserved valid
paths". Credits go to this
[answer](https://stackoverflow.com/a/62012466) by Stack Overflow user
Piotr Müller.

## Running the Application

Requirements:

* JDK 8
* Maven 3.8
* Node 20

To create an EAR run:

`mvn package`

To run the spring boot app:

`mvn jetty:run`

To run the SPA app (Vue.js), install its dependencies (`npm i`) and
then:

`npm run dev`

Visit http://localhost:8080/Demo/ to view the running web
application. You can try navigating to an undefined route such as
[`/foo`](http://localhost:8080/Demo/foo) and see the SPA handle a 404
error (and not Spring's whitelabel error page).
