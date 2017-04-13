CREATE SCHEMA timetable
  AUTHORIZATION sa;

SET SCHEMA timetable;

CREATE TABLE change_in_plan (
  old_date             DATE,
  new_date             DATE,
  change_in_plan_ID    INT AUTO_INCREMENT NOT NULL,
  lesson_lesson_ID     NUMBER             NOT NULL,
  teacher_teacher_ID   NUMBER             NOT NULL,
  plan_row_plan_row_ID NUMBER             NOT NULL
);

CREATE UNIQUE INDEX change_in_plan__IDx
  ON change_in_plan (lesson_lesson_ID ASC);

CREATE UNIQUE INDEX change_in_plan__IDxv1
  ON change_in_plan (teacher_teacher_ID ASC);

ALTER TABLE change_in_plan
  ADD CONSTRAINT change_in_plan_pk PRIMARY KEY (change_in_plan_ID);

CREATE TABLE contact (
  contact_ID         NUMBER AUTO_INCREMENT NOT NULL,
  email              VARCHAR2(30 CHAR),
  phone_number       VARCHAR2(12 CHAR),
  teacher_teacher_ID NUMBER NOT NULL
);

CREATE TABLE group (
  department   VARCHAR2(30 CHAR),
  faculty      VARCHAR2(30 CHAR),
  year         NUMBER(1),
  group_number VARCHAR2(3 CHAR),
  group_ID     INT AUTO_INCREMENT NOT NULL
);

ALTER TABLE group
  ADD CONSTRAINT group_pk PRIMARY KEY (group_ID);

CREATE TABLE lesson (
  subject   VARCHAR2(30 CHAR),
  hour      VARCHAR2(30 CHAR),
  classroom VARCHAR2(30 CHAR),
  type      VARCHAR2(10 CHAR),
  lesson_ID INT AUTO_INCREMENT NOT NULL
);

ALTER TABLE lesson
  ADD CONSTRAINT lesson_pk PRIMARY KEY (lesson_ID);

CREATE TABLE "on-call_time" (
  on_call_time_ID    NUMBER AUTO_INCREMENT NOT NULL,
  day                VARCHAR2(10 CHAR),
  room               VARCHAR2(10 CHAR),
  "from"             DATE,
  "to"               DATE,
  teacher_teacher_ID NUMBER NOT NULL
);

CREATE TABLE plan (
  semester       VARCHAR2(10 CHAR),
  plan_ID        INT AUTO_INCREMENT NOT NULL,
  group_group_ID NUMBER             NOT NULL
);


CREATE UNIQUE INDEX plan__IDx
  ON plan (group_group_ID ASC);

ALTER TABLE plan
  ADD CONSTRAINT plan_pk PRIMARY KEY (plan_ID);

CREATE TABLE plan_row (
  day_of_the_week    VARCHAR2(10 CHAR),
  week               VARCHAR2(10 CHAR),
  plan_row_ID        INT AUTO_INCREMENT NOT NULL,
  teacher_teacher_ID NUMBER             NOT NULL,
  lesson_lesson_ID   NUMBER             NOT NULL
);

CREATE UNIQUE INDEX plan_row__IDx
  ON
    plan_row (lesson_lesson_ID ASC);

ALTER TABLE plan_row
  ADD CONSTRAINT plan_row_pk PRIMARY KEY (plan_row_ID);

CREATE TABLE row_in_plan (
  id                   NUMBER AUTO_INCREMENT NOT NULL,
  plan_row_plan_row_ID NUMBER                NOT NULL,
  plan_plan_ID         INT                   NOT NULL
);

ALTER TABLE row_in_plan
  ADD CONSTRAINT relation_3_pk PRIMARY KEY (plan_row_plan_row_ID, plan_plan_ID);

CREATE TABLE teacher (
  first_name VARCHAR2(30 CHAR)  NOT NULL,
  last_name  VARCHAR2(30 CHAR)  NOT NULL,
  degree     VARCHAR2(30 CHAR),
  teacher_ID INT AUTO_INCREMENT NOT NULL
);

ALTER TABLE teacher
  ADD CONSTRAINT teacher_pk PRIMARY KEY (teacher_ID);

ALTER TABLE change_in_plan
  ADD CONSTRAINT change_in_plan_lesson_fk FOREIGN KEY (lesson_lesson_ID)
REFERENCES lesson (lesson_ID);

ALTER TABLE change_in_plan
  ADD CONSTRAINT change_in_plan_plan_row_fk FOREIGN KEY (plan_row_plan_row_ID)
REFERENCES plan_row (plan_row_ID);

ALTER TABLE change_in_plan
  ADD CONSTRAINT change_in_plan_teacher_fk FOREIGN KEY (teacher_teacher_ID)
REFERENCES teacher (teacher_ID);

ALTER TABLE contact
  ADD CONSTRAINT contact_teacher_fk FOREIGN KEY (teacher_teacher_ID)
REFERENCES teacher (teacher_ID);

ALTER TABLE row_in_plan
  ADD CONSTRAINT fk_ass_4 FOREIGN KEY (plan_row_plan_row_ID)
REFERENCES plan_row (plan_row_ID);

ALTER TABLE row_in_plan
  ADD CONSTRAINT fk_ass_5 FOREIGN KEY (plan_plan_ID)
REFERENCES plan (plan_ID);

ALTER TABLE "on-call_time"
  ADD CONSTRAINT "on-call_time_teacher_FK" FOREIGN KEY (teacher_teacher_ID)
REFERENCES teacher (teacher_ID);

ALTER TABLE plan
  ADD CONSTRAINT plan_group_fk FOREIGN KEY (group_group_ID)
REFERENCES "group" (group_ID);

ALTER TABLE plan_row
  ADD CONSTRAINT plan_row_lesson_fk FOREIGN KEY (lesson_lesson_ID)
REFERENCES lesson (lesson_ID);

ALTER TABLE plan_row
  ADD CONSTRAINT plan_row_teacher_fk FOREIGN KEY (teacher_teacher_ID)
REFERENCES teacher (teacher_ID);


