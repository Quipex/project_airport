ALTER TABLE USERS
  ADD (
  CONSTRAINT user_pk PRIMARY KEY (OBJECT_ID),
  CONSTRAINT user_id_not_null CHECK (OBJECT_ID IS NOT NULL),
  CONSTRAINT user_authority_id_fk FOREIGN KEY (AUTHORITY_ID) REFERENCES AUTHORITY (OBJECT_ID));
