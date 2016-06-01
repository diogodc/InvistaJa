--------------------------------------------------------
--  Arquivo criado - Quarta-feira-Junho-01-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence BVSP_BPA_DADOS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "BOVESPA"."BVSP_BPA_DADOS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence BVSP_BPA_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "BOVESPA"."BVSP_BPA_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence BVSP_BPA_SEQ1
--------------------------------------------------------

   CREATE SEQUENCE  "BOVESPA"."BVSP_BPA_SEQ1"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence BVSP_BPA_SEQ2
--------------------------------------------------------

   CREATE SEQUENCE  "BOVESPA"."BVSP_BPA_SEQ2"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence BVSP_BPP_DADOS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "BOVESPA"."BVSP_BPP_DADOS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence BVSP_BPP_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "BOVESPA"."BVSP_BPP_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence BVSP_BPP_SEQ1
--------------------------------------------------------

   CREATE SEQUENCE  "BOVESPA"."BVSP_BPP_SEQ1"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence BVSP_BPP_SEQ2
--------------------------------------------------------

   CREATE SEQUENCE  "BOVESPA"."BVSP_BPP_SEQ2"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence BVSP_DRE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "BOVESPA"."BVSP_DRE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence BVSP_EMPRESA_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "BOVESPA"."BVSP_EMPRESA_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 61 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence BVSP_EMPRESAS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "BOVESPA"."BVSP_EMPRESAS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence BVSP_ISF_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "BOVESPA"."BVSP_ISF_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence TAB_DRE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "BOVESPA"."TAB_DRE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence TABLE1_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "BOVESPA"."TABLE1_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence TAB_TESTE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "BOVESPA"."TAB_TESTE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 25961 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table BVSP_BPA
--------------------------------------------------------

  CREATE TABLE "BOVESPA"."BVSP_BPA" 
   (	"ID_BPA" NUMBER(20,0), 
	"ID_EMPRESA" NUMBER(20,0), 
	"BPA_PERIODO" DATE, 
	"BPP_CONTA_CONTABIL" VARCHAR2(40 BYTE), 
	"BPA_DESCRICAO" VARCHAR2(40 BYTE), 
	"BPA_VALOR" FLOAT(10)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table BVSP_BPP
--------------------------------------------------------

  CREATE TABLE "BOVESPA"."BVSP_BPP" 
   (	"ID_BPP" NUMBER(20,0), 
	"ID_EMPRESA" NUMBER(20,0), 
	"BPP_PERIODO" DATE, 
	"BPP_CONTA_CONTABIL" VARCHAR2(40 BYTE), 
	"BPP_DESCRICAO" VARCHAR2(40 BYTE), 
	"BPP_VALOR" FLOAT(20)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table BVSP_DRE
--------------------------------------------------------

  CREATE TABLE "BOVESPA"."BVSP_DRE" 
   (	"ID_DRE" NUMBER(20,0), 
	"ID_EMPRESA" NUMBER(20,0), 
	"DRE_PERIODO" DATE, 
	"DRE_CONTA_CONTABIL" VARCHAR2(40 BYTE), 
	"DRE_DESCRICAO" VARCHAR2(40 BYTE), 
	"DRE_VALOR" FLOAT(20)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table BVSP_EMPRESA
--------------------------------------------------------

  CREATE TABLE "BOVESPA"."BVSP_EMPRESA" 
   (	"ID_EMPRESA" NUMBER(20,0), 
	"RAZAO_SOCIAL" VARCHAR2(50 BYTE), 
	"NOME_FANTASIA" VARCHAR2(50 BYTE), 
	"CNPJ" VARCHAR2(14 BYTE), 
	"ATIVIDADE" VARCHAR2(140 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table BVSP_IDRENTA
--------------------------------------------------------

  CREATE TABLE "BOVESPA"."BVSP_IDRENTA" 
   (	"ID_RENT" NUMBER(20,0), 
	"ID_EMPRESA" NUMBER(20,0), 
	"RENTABILIDADE_ATIVO" NUMBER(20,0), 
	"RENT_PAT_LIQUIDO" NUMBER(20,0), 
	"MARGEM_LIQUIDA" NUMBER(20,0), 
	"GIRO_ATIVO" NUMBER(20,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table BVSP_ISF
--------------------------------------------------------

  CREATE TABLE "BOVESPA"."BVSP_ISF" 
   (	"ID_ISF" NUMBER(20,0), 
	"ID_EMPRESA" NUMBER(20,0), 
	"ENDIVIDAMENTO" FLOAT(63) DEFAULT 0, 
	"LIQUIDEZ_SECA" FLOAT(63) DEFAULT 0, 
	"LIQUIDEZ_CORRENTE" FLOAT(63) DEFAULT 0, 
	"LIQUIDEZ_GERAL" FLOAT(63) DEFAULT 0, 
	"IMOBILIZACAO_PL" FLOAT(63) DEFAULT 0, 
	"COMPOSICAO_ENDIVIDAMENTO" FLOAT(63) DEFAULT 0
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into BOVESPA.BVSP_BPA
SET DEFINE OFF;
REM INSERTING into BOVESPA.BVSP_BPP
SET DEFINE OFF;
REM INSERTING into BOVESPA.BVSP_DRE
SET DEFINE OFF;
REM INSERTING into BOVESPA.BVSP_EMPRESA
SET DEFINE OFF;
Insert into BOVESPA.BVSP_EMPRESA (ID_EMPRESA,RAZAO_SOCIAL,NOME_FANTASIA,CNPJ,ATIVIDADE) values ('3','EVERALDO CARDOSO DE ARAUJO','CARDOSO E SILVA FABRICA DE SOFTWARE','14644293750111','DESENVOLVIMENTO');
Insert into BOVESPA.BVSP_EMPRESA (ID_EMPRESA,RAZAO_SOCIAL,NOME_FANTASIA,CNPJ,ATIVIDADE) values ('5','EVERALDO CARDOSO DE ARAUJO','CARDOSO E SILVA FABRICA DE SOFTWARE','14644293750111','DESENVOLVIMENTO');
Insert into BOVESPA.BVSP_EMPRESA (ID_EMPRESA,RAZAO_SOCIAL,NOME_FANTASIA,CNPJ,ATIVIDADE) values ('21','EVERALDO CARDDOSO DE ARAUJO','EVERALDO CARDOSO DE ARAUJO','14644293750111','INFORMATICA');
Insert into BOVESPA.BVSP_EMPRESA (ID_EMPRESA,RAZAO_SOCIAL,NOME_FANTASIA,CNPJ,ATIVIDADE) values ('30','KDLKAKD�ALKD�LASSKD�L''','KDASDLAKSD�LAKDS�LAK�DLAK�LD','99999999999999','DKAPLSDKALKD�L');
Insert into BOVESPA.BVSP_EMPRESA (ID_EMPRESA,RAZAO_SOCIAL,NOME_FANTASIA,CNPJ,ATIVIDADE) values ('31','AL�DKA�LSDK','DAMKSLDA�K�L''','44444444444444','ASL�DKASL�D');
Insert into BOVESPA.BVSP_EMPRESA (ID_EMPRESA,RAZAO_SOCIAL,NOME_FANTASIA,CNPJ,ATIVIDADE) values ('32','DAMKSLDA�K�L''','AL�DKA�LSDK','44444444444444','ASL�DKASL�D-----dkal�sdladlsa�');
Insert into BOVESPA.BVSP_EMPRESA (ID_EMPRESA,RAZAO_SOCIAL,NOME_FANTASIA,CNPJ,ATIVIDADE) values ('33','KALDJKOAJ''','LKCMALKSDLKASJDA''','99999999999999','LDKASLKDALKSDJ');
Insert into BOVESPA.BVSP_EMPRESA (ID_EMPRESA,RAZAO_SOCIAL,NOME_FANTASIA,CNPJ,ATIVIDADE) values ('34','CARDOSO & SILVA LTDA','CARDOSO & SILVA LTDA','14644293750999','COMERCIO EXTERIOR - merda');
Insert into BOVESPA.BVSP_EMPRESA (ID_EMPRESA,RAZAO_SOCIAL,NOME_FANTASIA,CNPJ,ATIVIDADE) values ('35','323423434','342rfsdfs','22222222222222','232342424');
Insert into BOVESPA.BVSP_EMPRESA (ID_EMPRESA,RAZAO_SOCIAL,NOME_FANTASIA,CNPJ,ATIVIDADE) values ('40','ssssssss','sssssss','          ','sssssssssss');
Insert into BOVESPA.BVSP_EMPRESA (ID_EMPRESA,RAZAO_SOCIAL,NOME_FANTASIA,CNPJ,ATIVIDADE) values ('41','teste','teste','99999999999999','teste');
REM INSERTING into BOVESPA.BVSP_IDRENTA
SET DEFINE OFF;
REM INSERTING into BOVESPA.BVSP_ISF
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index BVSP_BPA_INDEX1
--------------------------------------------------------

  CREATE UNIQUE INDEX "BOVESPA"."BVSP_BPA_INDEX1" ON "BOVESPA"."BVSP_BPA" ("ID_EMPRESA" DESC) 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index BVSP_IDRENTA_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "BOVESPA"."BVSP_IDRENTA_PK" ON "BOVESPA"."BVSP_IDRENTA" ("ID_RENT", "ID_EMPRESA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index BVSP_EMPRESAS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "BOVESPA"."BVSP_EMPRESAS_PK" ON "BOVESPA"."BVSP_EMPRESA" ("ID_EMPRESA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index BVSP_IND_SITUACAO_FINANCEI_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "BOVESPA"."BVSP_IND_SITUACAO_FINANCEI_PK" ON "BOVESPA"."BVSP_ISF" ("ID_ISF") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index BVSP_BPP_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "BOVESPA"."BVSP_BPP_PK" ON "BOVESPA"."BVSP_BPP" ("ID_BPP", "ID_EMPRESA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index BVSP_DRE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "BOVESPA"."BVSP_DRE_PK" ON "BOVESPA"."BVSP_DRE" ("ID_DRE", "ID_EMPRESA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index BVSP_BPA_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "BOVESPA"."BVSP_BPA_PK" ON "BOVESPA"."BVSP_BPA" ("ID_BPA", "ID_EMPRESA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table BVSP_BPA
--------------------------------------------------------

  ALTER TABLE "BOVESPA"."BVSP_BPA" ADD CONSTRAINT "BVSP_BPA_PK" PRIMARY KEY ("ID_BPA", "ID_EMPRESA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "BOVESPA"."BVSP_BPA" MODIFY ("ID_EMPRESA" NOT NULL ENABLE);
  ALTER TABLE "BOVESPA"."BVSP_BPA" MODIFY ("ID_BPA" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table BVSP_DRE
--------------------------------------------------------

  ALTER TABLE "BOVESPA"."BVSP_DRE" MODIFY ("DRE_PERIODO" NOT NULL ENABLE);
  ALTER TABLE "BOVESPA"."BVSP_DRE" ADD CONSTRAINT "BVSP_DRE_PK" PRIMARY KEY ("ID_DRE", "ID_EMPRESA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "BOVESPA"."BVSP_DRE" MODIFY ("ID_EMPRESA" NOT NULL ENABLE);
  ALTER TABLE "BOVESPA"."BVSP_DRE" MODIFY ("ID_DRE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table BVSP_BPP
--------------------------------------------------------

  ALTER TABLE "BOVESPA"."BVSP_BPP" ADD CONSTRAINT "BVSP_BPP_PK" PRIMARY KEY ("ID_BPP", "ID_EMPRESA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "BOVESPA"."BVSP_BPP" MODIFY ("ID_EMPRESA" NOT NULL ENABLE);
  ALTER TABLE "BOVESPA"."BVSP_BPP" MODIFY ("ID_BPP" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table BVSP_ISF
--------------------------------------------------------

  ALTER TABLE "BOVESPA"."BVSP_ISF" ADD CONSTRAINT "BVSP_IND_SITUACAO_FINANCEI_PK" PRIMARY KEY ("ID_ISF")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "BOVESPA"."BVSP_ISF" MODIFY ("COMPOSICAO_ENDIVIDAMENTO" NOT NULL ENABLE);
  ALTER TABLE "BOVESPA"."BVSP_ISF" MODIFY ("IMOBILIZACAO_PL" NOT NULL ENABLE);
  ALTER TABLE "BOVESPA"."BVSP_ISF" MODIFY ("LIQUIDEZ_GERAL" NOT NULL ENABLE);
  ALTER TABLE "BOVESPA"."BVSP_ISF" MODIFY ("LIQUIDEZ_CORRENTE" NOT NULL ENABLE);
  ALTER TABLE "BOVESPA"."BVSP_ISF" MODIFY ("LIQUIDEZ_SECA" NOT NULL ENABLE);
  ALTER TABLE "BOVESPA"."BVSP_ISF" MODIFY ("ENDIVIDAMENTO" NOT NULL ENABLE);
  ALTER TABLE "BOVESPA"."BVSP_ISF" MODIFY ("ID_EMPRESA" NOT NULL ENABLE);
  ALTER TABLE "BOVESPA"."BVSP_ISF" MODIFY ("ID_ISF" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table BVSP_IDRENTA
--------------------------------------------------------

  ALTER TABLE "BOVESPA"."BVSP_IDRENTA" MODIFY ("RENTABILIDADE_ATIVO" NOT NULL ENABLE);
  ALTER TABLE "BOVESPA"."BVSP_IDRENTA" ADD CONSTRAINT "BVSP_IDRENTA_PK" PRIMARY KEY ("ID_RENT", "ID_EMPRESA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "BOVESPA"."BVSP_IDRENTA" MODIFY ("ID_EMPRESA" NOT NULL ENABLE);
  ALTER TABLE "BOVESPA"."BVSP_IDRENTA" MODIFY ("ID_RENT" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table BVSP_EMPRESA
--------------------------------------------------------

  ALTER TABLE "BOVESPA"."BVSP_EMPRESA" ADD CONSTRAINT "BVSP_EMPRESAS_PK" PRIMARY KEY ("ID_EMPRESA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "BOVESPA"."BVSP_EMPRESA" MODIFY ("ATIVIDADE" NOT NULL ENABLE);
  ALTER TABLE "BOVESPA"."BVSP_EMPRESA" MODIFY ("CNPJ" NOT NULL ENABLE);
  ALTER TABLE "BOVESPA"."BVSP_EMPRESA" MODIFY ("NOME_FANTASIA" NOT NULL ENABLE);
  ALTER TABLE "BOVESPA"."BVSP_EMPRESA" MODIFY ("RAZAO_SOCIAL" NOT NULL ENABLE);
  ALTER TABLE "BOVESPA"."BVSP_EMPRESA" MODIFY ("ID_EMPRESA" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table BVSP_BPA
--------------------------------------------------------

  ALTER TABLE "BOVESPA"."BVSP_BPA" ADD CONSTRAINT "BVSP_BPA_FK1" FOREIGN KEY ("ID_EMPRESA")
	  REFERENCES "BOVESPA"."BVSP_EMPRESA" ("ID_EMPRESA") ENABLE;
--------------------------------------------------------
--  DDL for Trigger BVSP_BPA_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BOVESPA"."BVSP_BPA_TRG" 
BEFORE INSERT ON BVSP_BPA 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    NULL;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "BOVESPA"."BVSP_BPA_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger BVSP_BPP_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BOVESPA"."BVSP_BPP_TRG" 
BEFORE INSERT ON BVSP_BPP 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    NULL;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "BOVESPA"."BVSP_BPP_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger BVSP_EMPRESAS_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BOVESPA"."BVSP_EMPRESAS_TRG" 
BEFORE INSERT ON BVSP_EMPRESA 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    NULL;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "BOVESPA"."BVSP_EMPRESAS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger BVSP_EMPRESA_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BOVESPA"."BVSP_EMPRESA_TRG" 
BEFORE INSERT ON BVSP_EMPRESA 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID_EMPRESA IS NULL THEN
      SELECT BVSP_EMPRESA_SEQ.NEXTVAL INTO :NEW.ID_EMPRESA FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "BOVESPA"."BVSP_EMPRESA_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger BVSP_ISF_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BOVESPA"."BVSP_ISF_TRG" 
BEFORE INSERT ON BVSP_ISF 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    NULL;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "BOVESPA"."BVSP_ISF_TRG" ENABLE;