# Single sign on (SSO) implementation with Spring Oauth

`auth-server` - authorization server

`resource-server` - secured REST API getting data by token

`ui-angular` - simple client-side application allowing to receive resources after authenticating on the auth-server side.

Simple scheme of relations between this apps are showing in the drawing.



The following clients are available for access to the authorization server:

- `implicit-flow-client` with 'implicit flow' authorization grant. This client uses for authentication from client-side app (using in ui-angular application). UML diagram
- `curl-client` with 'client-credentials' authorization grant. Using this client, it is possible to access the authorization server directly. 
<br/>For example by curl: 
<br/>get token:   
`curl -i -H "Accept: application/json" -H "Content-Type: application/json" -H "Authorization: Bearer $TOKEN" -X GET http://localhost:8082/resource-server/rest/candidates`, 
<br/>get resource by token:  
`curl -X POST --user 'curl-client:client-secret' -d 'grant_type=client_credentials&username=tom&password=123' http://localhost:8081/auth/oauth/token`
<br/>UML diagram



1.	To start backend (auth-server and resource-server)

- `mvn clean install`
- `java -jar auth/target/auth-0.0.1-SNAPSHOT.jar`
- `java -jar resource-server/target/resource-server-0.0.1-SNAPSHOT.jar`

2.	To start frontend (ui-angular). Angular CLI must be installed

- `cd ui-angular`
- `npm install`
- `ng serve`
- go to http://localhost:4200

