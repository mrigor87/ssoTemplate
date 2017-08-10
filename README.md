# Single sign on (SSO) with Spring Oauth 2.0

## Description

**auth-server** - authorization server

**resource-server** - secured REST API getting data by token

**ui-angular** - simple client-side application allowing to receive resources after authenticating on the auth-server side.

Simple scheme of interaction between this apps is shown in [`the drawing`](https://github.com/mrigor87/ssoTemplate/tree/master/doc/scheme.jpg).



The following clients are available for access to the authorization server:

- **implicit-flow-client** with 'implicit flow' authorization grant. This client is used for authentication from client-side app (ui-angular application). [`UML Diagram`](https://github.com/mrigor87/ssoTemplate/tree/master/doc/implicit-flow.jpg).

- **curl-client** with 'client-credentials' authorization grant. Using this client, it is possible to access the authorization server directly. For example by curl: 
<br/>get token:   
`curl -X POST --user 'curl-client:client-secret' -d 'grant_type=client_credentials&username=tom&password=123' http://localhost:8081/auth/oauth/token`
<br/>get resource by token:  
`curl -i -H "Accept: application/json" -H "Content-Type: application/json" -H "Authorization: Bearer $TOKEN" -X GET http://localhost:8082/resource-server/rest/candidates` 
<br/> [`UML Diagram`](https://github.com/mrigor87/ssoTemplate/tree/master/doc/client-credentials-flow.jpg)
- **check-token-client** - this client is used only by resource-server for interaction with auth-server when cheking the token.


## Instruction 

1.	To start backend (auth-server and resource-server)

- `mvn clean install`
- `java -jar auth-server/target/auth-server-0.0.1-SNAPSHOT.jar`
- `java -jar resource-server/target/resource-server-0.0.1-SNAPSHOT.jar`

2.	To start frontend (ui-angular). Angular CLI must be installed

- `cd ui-angular`
- `npm install`
- `ng serve`
- go to http://localhost:4200

