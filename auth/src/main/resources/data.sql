

INSERT INTO oauth_client_details
  (client_id,             client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove)
VALUES
  ('read-only-client', NULL, 'read', 'implicit', 'http://localhost:4200', NULL, 7200, 0, NULL, 'false');

INSERT INTO oauth_client_details
(client_id,  client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove)
VALUES
  ('curl-client',  'client-secret', 'read,write', 'client_credentials', '', 'role_admin', 7200, 0, NULL, 'false');

INSERT INTO oauth_client_details
(client_id, client_secret)
VALUES
  ('resource-server', 'resource-server');


INSERT INTO users (user_id, username, password, enabled) VALUES
  ('1', 'user1', 'user', true);

insert into authorities (username, authority) values ('user1', 'ROLE_ADMIN');