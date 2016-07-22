CREATE OR REPLACE PROCEDURE BVSP_SP_INDICADORES  (
  vID_EMPRESA INTEGER,
  vANO1 VARCHAR,
  vANO2 VARCHAR,
  vANO3 VARCHAR
)
IS
  vCCL REAL;
  vCE REAL;
  vCF REAL;
  vCO REAL;
  vGA REAL;
  vIPL REAL;
  vLC REAL;
  vLG REAL;
  vLS REAL;
  vML REAL;
  vPCT REAL;
  vPME REAL;
  vPMP REAL;
  vPMR REAL;
  vRA REAL;
  vRPL REAL;
BEGIN
        --#########ANO 1#########--
        
        --CCL:
        SELECT 
            TRUNC(NVL(BVSP_BPA.BPA_VALOR1 - BVSP_BPP.BPP_VALOR1,0),2) AS CCL INTO vCCL
        FROM BVSP_BPP
        INNER JOIN BVSP_BPA ON BVSP_BPA.ID_EMPRESA = BVSP_BPP.ID_EMPRESA
        WHERE BVSP_BPP.ID_EMPRESA = vID_EMPRESA
        AND BVSP_BPA.BPA_CONTA_CONTABIL = '1.01'
        AND BVSP_BPP.BPP_CONTA_CONTABIL = '2.01'
        AND ROWNUM < 2;
        
        --CE:
        SELECT 
             NVL(TRUNC((BPP1.BPP_VALOR1/
             (CASE (BPP1.BPP_VALOR1+BPP2.BPP_VALOR1) WHEN 0 THEN 1 ELSE (BPP1.BPP_VALOR1+BPP2.BPP_VALOR1) END)
             * 100),2),0) AS CE INTO vCE
        FROM BVSP_BPP
        INNER JOIN BVSP_BPP BPP1 ON BPP1.ID_EMPRESA = BVSP_BPP.ID_EMPRESA
        INNER JOIN BVSP_BPP BPP2 ON BPP2.ID_EMPRESA = BVSP_BPP.ID_EMPRESA
        WHERE BVSP_BPP.ID_EMPRESA = vID_EMPRESA
        AND BPP1.BPP_CONTA_CONTABIL = '2.01'
        AND BPP2.BPP_CONTA_CONTABIL = '2.02'
        AND ROWNUM < 2;   
        
        --CF:
        SELECT
            (SELECT 
              TRUNC(NVL((((BPP.BPP_VALOR1/
              (CASE (DRE.DRE_VALOR1 * -1) WHEN 0 THEN 1 ELSE (DRE.DRE_VALOR1 * -1) END)
              ) + (BPA.BPA_VALOR1 - BPA.BPA_VALOR2)) * 360),0),2) AS PMP
            FROM BVSP_DRE DRE
            INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
            INNER JOIN BVSP_BPP BPP ON BPP.ID_EMPRESA = DRE.ID_EMPRESA
            WHERE DRE.ID_EMPRESA = BVSP_DRE.ID_EMPRESA
            AND DRE.DRE_CONTA_CONTABIL = '3.02'
            AND BPA.BPA_CONTA_CONTABIL = '1.01.04'
            AND BPP.BPP_CONTA_CONTABIL = '2.01.02'
            AND ROWNUM < 2)
            -
            ((SELECT 
                TRUNC(NVL(((BPA.BPA_VALOR1/
                (CASE (DRE.DRE_VALOR1 * -1) WHEN 0 THEN 1 ELSE (DRE.DRE_VALOR1 * -1) END)
                ) * 360),0),2) AS PME
              FROM BVSP_DRE DRE
              INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
              WHERE DRE.ID_EMPRESA = BVSP_DRE.ID_EMPRESA
              AND DRE.DRE_CONTA_CONTABIL = '3.02'
              AND BPA.BPA_CONTA_CONTABIL = '1.01.04'
              AND ROWNUM < 2)
              +
              (SELECT 
                TRUNC(NVL(((BPA.BPA_VALOR1/
                (CASE DRE.DRE_VALOR1 WHEN 0 THEN 1 ELSE DRE.DRE_VALOR1 END)
                ) * 360),0),2) AS PMR
              FROM BVSP_DRE DRE
              INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
              WHERE DRE.ID_EMPRESA = BVSP_DRE.ID_EMPRESA
              AND DRE.DRE_CONTA_CONTABIL = '3.01'
              AND BPA.BPA_CONTA_CONTABIL = '1.01.03'
              AND ROWNUM < 2)
            ) AS CF INTO vCF
        FROM BVSP_DRE
        WHERE BVSP_DRE.ID_EMPRESA = vID_EMPRESA
        AND ROWNUM < 2;
        
        --CO:
        SELECT
            TRUNC(NVL(
            (SELECT 
              TRUNC(NVL(((BPA.BPA_VALOR1/
              (CASE (DRE.DRE_VALOR1 * -1) WHEN 0 THEN 1 ELSE (DRE.DRE_VALOR1 * -1) END)
              ) * 360),0),2)
            FROM BVSP_DRE DRE
            INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
            WHERE DRE.ID_EMPRESA = vID_EMPRESA
            AND DRE.DRE_CONTA_CONTABIL = '3.02'
            AND BPA.BPA_CONTA_CONTABIL = '1.01.04'
            AND ROWNUM < 2)
          +
            (SELECT 
              TRUNC(NVL(((BPA.BPA_VALOR1/
              (CASE DRE.DRE_VALOR1 WHEN 0 THEN 1 ELSE DRE.DRE_VALOR1 END)
              ) * 360),0),2)
            FROM BVSP_DRE DRE
            INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
            WHERE DRE.ID_EMPRESA = vID_EMPRESA
            AND DRE.DRE_CONTA_CONTABIL = '3.01'
            AND BPA.BPA_CONTA_CONTABIL = '1.01.03'
            AND ROWNUM < 2)
            ,0),2) AS CO INTO vCO
        FROM BVSP_DRE
        WHERE BVSP_DRE.ID_EMPRESA = vID_EMPRESA
        AND ROWNUM < 2;
        
        
        --GA:
        SELECT 
            TRUNC(NVL(DRE.DRE_VALOR1/
            (CASE BPA.BPA_VALOR1 WHEN 0 THEN 1 ELSE BPA.BPA_VALOR2 END) 
            ,0),2) AS GA INTO vGA
        FROM BVSP_DRE DRE
        INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
        WHERE DRE.ID_EMPRESA = vID_EMPRESA
        AND DRE.DRE_CONTA_CONTABIL = '3.01'
        AND BPA.BPA_CONTA_CONTABIL = '1'
        AND ROWNUM < 2;
        
        --IPL:
        SELECT 
             NVL(TRUNC((((BPA1.BPA_VALOR1 + BPA2.BPA_VALOR1 + BPA3.BPA_VALOR1) /
             (CASE BPP1.BPP_VALOR1 WHEN 0 THEN 1 ELSE BPP1.BPP_VALOR1 END)
             ) * 100),2),0)  AS IPL INTO vIPL
        FROM BVSP_BPA
        INNER JOIN BVSP_BPA BPA1 ON BPA1.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        INNER JOIN BVSP_BPA BPA2 ON BPA2.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        INNER JOIN BVSP_BPA BPA3 ON BPA3.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        INNER JOIN BVSP_BPP BPP1 ON BPP1.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        WHERE BVSP_BPA.ID_EMPRESA = vID_EMPRESA
        AND BPA1.BPA_CONTA_CONTABIL = '1.02.02'
        AND BPA2.BPA_CONTA_CONTABIL = '1.02.03'
        AND BPA3.BPA_CONTA_CONTABIL = '1.02.04'
        AND BPP1.BPP_CONTA_CONTABIL = '2.03'
        AND ROWNUM < 2;
        
        --LC:
        SELECT 
            TRUNC(NVL(BVSP_BPA.BPA_VALOR1 / 
            (CASE BVSP_BPP.BPP_VALOR1 WHEN 0 THEN 1 ELSE BVSP_BPP.BPP_VALOR1 END)
            ,0),2) AS LC INTO vLC
        FROM BVSP_BPA
        INNER JOIN BVSP_BPP ON BVSP_BPP.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        WHERE BVSP_BPP.ID_EMPRESA = vID_EMPRESA
        AND BVSP_BPP.BPP_CONTA_CONTABIL = '2.01'
        AND BVSP_BPA.BPA_CONTA_CONTABIL = '1.01'
        AND ROWNUM < 2;

        --LG:
        SELECT
            TRUNC(NVL(BPA.BPA_VALOR1/
            (CASE (BPP1.BPP_VALOR1 + BPP2.BPP_VALOR1) WHEN 0 THEN 1 ELSE (BPP1.BPP_VALOR1 + BPP2.BPP_VALOR1) END)
            ,0),2) AS LG INTO vLG
        FROM BVSP_BPA BPA
        INNER JOIN BVSP_BPP BPP1 ON BPP1.ID_EMPRESA = BPA.ID_EMPRESA
        INNER JOIN BVSP_BPP BPP2 ON BPP2.ID_EMPRESA = BPA.ID_EMPRESA
        WHERE BPA.ID_EMPRESA = vID_EMPRESA
        AND BPA.BPA_CONTA_CONTABIL = '1.02.01'
        AND BPP1.BPP_CONTA_CONTABIL = '2.01'
        AND BPP2.BPP_CONTA_CONTABIL = '2.02'
        AND ROWNUM < 2;
        
        --LS:
        SELECT 
           TRUNC(NVL(((BPA1.BPA_VALOR1 + BPA2.BPA_VALOR1 + BPA3.BPA_VALOR1) / 
           (CASE BPP1.BPP_VALOR1 WHEN 0 THEN 1 ELSE BPP1.BPP_VALOR1 END)
           ),0),2) AS LS INTO vLS
        FROM BVSP_BPA
        INNER JOIN BVSP_BPA BPA1 ON BPA1.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        INNER JOIN BVSP_BPA BPA2 ON BPA2.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        INNER JOIN BVSP_BPA BPA3 ON BPA3.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        INNER JOIN BVSP_BPP BPP1 ON BPP1.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        WHERE BVSP_BPA.ID_EMPRESA = vID_EMPRESA
        AND BPA1.BPA_CONTA_CONTABIL = '1.01.01'
        AND BPA2.BPA_CONTA_CONTABIL = '1.01.02'
        AND BPA3.BPA_CONTA_CONTABIL = '1.01.03'
        AND BPP1.BPP_CONTA_CONTABIL = '2.01'
        AND ROWNUM < 2;
      
        --ML:
        SELECT 
          TRUNC(NVL(((DRE.DRE_VALOR1/
          (CASE DRE1.DRE_VALOR1 WHEN 0 THEN 1 ELSE DRE1.DRE_VALOR1 END)
          ) * 100),0),2) AS ML INTO vML
        FROM BVSP_DRE DRE
        INNER JOIN BVSP_DRE DRE1 ON DRE1.ID_EMPRESA = DRE.ID_EMPRESA
        WHERE DRE.ID_EMPRESA = vID_EMPRESA
        AND DRE.DRE_CONTA_CONTABIL = '3.09'
        AND DRE1.DRE_CONTA_CONTABIL = '3.01'
        AND ROWNUM < 2;
        
        --PCT:
        SELECT 
              NVL(TRUNC((((BPP2.BPP_VALOR1 + BPP3.BPP_VALOR1) / 
              (CASE BPP4.BPP_VALOR1 WHEN 0 THEN 1 ELSE BPP4.BPP_VALOR1 END)
              ) * 100),2),2) AS PCT INTO vPCT
        FROM BVSP_BPP BPP1
        INNER JOIN BVSP_BPP BPP2 ON BPP2.ID_EMPRESA = BPP1.ID_EMPRESA
        INNER JOIN BVSP_BPP BPP3 ON BPP3.ID_EMPRESA = BPP1.ID_EMPRESA
        INNER JOIN BVSP_BPP BPP4 ON BPP4.ID_EMPRESA = BPP1.ID_EMPRESA
        WHERE BPP1.ID_EMPRESA = vID_EMPRESA
        AND BPP2.BPP_CONTA_CONTABIL = '2.01'
        AND BPP3.BPP_CONTA_CONTABIL = '2.02'
        AND BPP4.BPP_CONTA_CONTABIL = '2.03'
        AND ROWNUM < 2;
        
        --PME:
        SELECT 
          TRUNC(NVL(((BPA.BPA_VALOR1/
          (CASE (DRE.DRE_VALOR1 * -1) WHEN 0 THEN 1 ELSE (DRE.DRE_VALOR1 * -1) END)
          ) * 360),0),2) AS PME INTO vPME
        FROM BVSP_DRE DRE
        INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
        WHERE DRE.ID_EMPRESA = vID_EMPRESA
        AND DRE.DRE_CONTA_CONTABIL = '3.02'
        AND BPA.BPA_CONTA_CONTABIL = '1.01.04'
        AND ROWNUM < 2;
        
        --PMP:
        SELECT 
          TRUNC(NVL((((BPP.BPP_VALOR1/
          (CASE (DRE.DRE_VALOR1 * -1) WHEN 0 THEN 1 ELSE (DRE.DRE_VALOR1 * -1) END)
          ) + (BPA.BPA_VALOR1 - BPA.BPA_VALOR2)) * 360),0),2) AS PMP INTO vPMP
        FROM BVSP_DRE DRE
        INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
        INNER JOIN BVSP_BPP BPP ON BPP.ID_EMPRESA = DRE.ID_EMPRESA
        WHERE DRE.ID_EMPRESA = vID_EMPRESA
        AND DRE.DRE_CONTA_CONTABIL = '3.02'
        AND BPA.BPA_CONTA_CONTABIL = '1.01.04'
        AND BPP.BPP_CONTA_CONTABIL = '2.01.02'
        AND ROWNUM < 2;
        
        --PMR:
        SELECT 
          TRUNC(NVL(((BPA.BPA_VALOR1/
          (CASE DRE.DRE_VALOR1 WHEN 0 THEN 1 ELSE DRE.DRE_VALOR1 END)
          ) * 360),0),2) AS PMR INTO vPMR
        FROM BVSP_DRE DRE
        INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
        WHERE DRE.ID_EMPRESA = vID_EMPRESA
        AND DRE.DRE_CONTA_CONTABIL = '3.01'
        AND BPA.BPA_CONTA_CONTABIL = '1.01.03'
        AND ROWNUM < 2;
        
        --RA:
        SELECT 
          TRUNC(NVL((DRE.DRE_VALOR1/
          (CASE BPA.BPA_VALOR1 WHEN 0 THEN 1 ELSE BPA.BPA_VALOR1 END)
          ) * 100,0),2) AS RA INTO vRA
        FROM BVSP_DRE DRE
        INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
        WHERE DRE.ID_EMPRESA = vID_EMPRESA
        AND DRE.DRE_CONTA_CONTABIL = '3.09'
        AND BPA.BPA_CONTA_CONTABIL = '1'
        AND ROWNUM < 2;
        
        --RPL:
        SELECT 
          TRUNC(NVL((DRE.DRE_VALOR1/
          (CASE BPP.BPP_VALOR1 WHEN 0 THEN 1 ELSE BPP.BPP_VALOR1 END)
          ) * 100,0),2) AS RPL INTO vRPL
        FROM BVSP_DRE DRE
        INNER JOIN BVSP_BPP BPP ON BPP.ID_EMPRESA = DRE.ID_EMPRESA
        WHERE DRE.ID_EMPRESA = vID_EMPRESA
        AND DRE.DRE_CONTA_CONTABIL = '3.09'
        AND BPP.BPP_CONTA_CONTABIL = '2.03'
        AND ROWNUM < 2;
        
        
        --INSERE DADOS CALCULADOS NA TABELA:
        INSERT INTO BVSP_INDICADORES 
              (ID_INDICADORES,
               ID_EMPRESA,
               ANO,
               IE_PCT,
               IE_CE,
               IE_IPL,
               IL_LG,
               IL_LC,
               IL_LS,
               IL_CCL,
               IR_GA,
               IR_ML,
               IR_RA,
               IR_RPL,
               IA_PME,
               IA_PMR,
               IA_PMP,
               IA_CO,
               IA_CF) 
         VALUES 
              (BVSP_INDICADORES_SEQ3.NEXTVAL,
               vID_EMPRESA,
               vANO1,
               vPCT,
               vCE,
               vIPL,
               vLG,
               vLC,
               vLS,
               vCCL,
               vGA,
               vML,
               vRA,
               vRPL,
               vPME,
               vPMR,
               vPMP,
               vCO,
               vCF);
               
               
               
        --#########ANO 2#########--
        --CCL:
        SELECT 
            TRUNC(NVL(BVSP_BPA.BPA_VALOR2 - BVSP_BPP.BPP_VALOR2,0),2) AS CCL INTO vCCL
        FROM BVSP_BPP
        INNER JOIN BVSP_BPA ON BVSP_BPA.ID_EMPRESA = BVSP_BPP.ID_EMPRESA
        WHERE BVSP_BPP.ID_EMPRESA = vID_EMPRESA
        AND BVSP_BPA.BPA_CONTA_CONTABIL = '1.01'
        AND BVSP_BPP.BPP_CONTA_CONTABIL = '2.01'
        AND ROWNUM < 2;
        
        --CE:
        SELECT 
             NVL(TRUNC((BPP1.BPP_VALOR2/
             (CASE (BPP1.BPP_VALOR2+BPP2.BPP_VALOR2) WHEN 0 THEN 1 ELSE (BPP1.BPP_VALOR2+BPP2.BPP_VALOR2) END)
             * 100),2),0) AS CE INTO vCE
        FROM BVSP_BPP
        INNER JOIN BVSP_BPP BPP1 ON BPP1.ID_EMPRESA = BVSP_BPP.ID_EMPRESA
        INNER JOIN BVSP_BPP BPP2 ON BPP2.ID_EMPRESA = BVSP_BPP.ID_EMPRESA
        WHERE BVSP_BPP.ID_EMPRESA = vID_EMPRESA
        AND BPP1.BPP_CONTA_CONTABIL = '2.01'
        AND BPP2.BPP_CONTA_CONTABIL = '2.02'
        AND ROWNUM < 2;   
        
        --CF:
        SELECT
            (SELECT 
              TRUNC(NVL((((BPP.BPP_VALOR2/
              (CASE (DRE.DRE_VALOR2 * -1) WHEN 0 THEN 1 ELSE (DRE.DRE_VALOR2 * -1) END)
              ) + (BPA.BPA_VALOR2 - BPA.BPA_VALOR3)) * 360),0),2) AS PMP
            FROM BVSP_DRE DRE
            INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
            INNER JOIN BVSP_BPP BPP ON BPP.ID_EMPRESA = DRE.ID_EMPRESA
            WHERE DRE.ID_EMPRESA = BVSP_DRE.ID_EMPRESA
            AND DRE.DRE_CONTA_CONTABIL = '3.02'
            AND BPA.BPA_CONTA_CONTABIL = '1.01.04'
            AND BPP.BPP_CONTA_CONTABIL = '2.01.02'
            AND ROWNUM < 2)
            -
            ((SELECT 
                TRUNC(NVL(((BPA.BPA_VALOR2/
                (CASE (DRE.DRE_VALOR2 * -1) WHEN 0 THEN 1 ELSE (DRE.DRE_VALOR2 * -1) END)
                ) * 360),0),2) AS PME
              FROM BVSP_DRE DRE
              INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
              WHERE DRE.ID_EMPRESA = BVSP_DRE.ID_EMPRESA
              AND DRE.DRE_CONTA_CONTABIL = '3.02'
              AND BPA.BPA_CONTA_CONTABIL = '1.01.04'
              AND ROWNUM < 2)
              +
              (SELECT 
                TRUNC(NVL(((BPA.BPA_VALOR2/
                (CASE DRE.DRE_VALOR2 WHEN 0 THEN 1 ELSE DRE.DRE_VALOR2 END)
                ) * 360),0),2) AS PMR
              FROM BVSP_DRE DRE
              INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
              WHERE DRE.ID_EMPRESA = BVSP_DRE.ID_EMPRESA
              AND DRE.DRE_CONTA_CONTABIL = '3.01'
              AND BPA.BPA_CONTA_CONTABIL = '1.01.03'
              AND ROWNUM < 2)
            ) AS CF INTO vCF
        FROM BVSP_DRE
        WHERE BVSP_DRE.ID_EMPRESA = vID_EMPRESA
        AND ROWNUM < 2;
        
        --CO:
        SELECT
            TRUNC(NVL(
            (SELECT 
              TRUNC(NVL(((BPA.BPA_VALOR2/
              (CASE (DRE.DRE_VALOR2 * -1) WHEN 0 THEN 1 ELSE (DRE.DRE_VALOR2 * -1) END)
              ) * 360),0),2)
            FROM BVSP_DRE DRE
            INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
            WHERE DRE.ID_EMPRESA = vID_EMPRESA
            AND DRE.DRE_CONTA_CONTABIL = '3.02'
            AND BPA.BPA_CONTA_CONTABIL = '1.01.04'
            AND ROWNUM < 2)
          +
            (SELECT 
              TRUNC(NVL(((BPA.BPA_VALOR2/
              (CASE DRE.DRE_VALOR2 WHEN 0 THEN 1 ELSE DRE.DRE_VALOR2 END)
              ) * 360),0),2)
            FROM BVSP_DRE DRE
            INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
            WHERE DRE.ID_EMPRESA = vID_EMPRESA
            AND DRE.DRE_CONTA_CONTABIL = '3.01'
            AND BPA.BPA_CONTA_CONTABIL = '1.01.03'
            AND ROWNUM < 2)
            ,0),2) AS CO INTO vCO
        FROM BVSP_DRE
        WHERE BVSP_DRE.ID_EMPRESA = vID_EMPRESA
        AND ROWNUM < 2;
        
        
        --GA:
        SELECT 
            TRUNC(NVL(DRE.DRE_VALOR2/
            (CASE BPA.BPA_VALOR2 WHEN 0 THEN 1 ELSE BPA.BPA_VALOR2 END) 
            ,0),2) AS GA INTO vGA
        FROM BVSP_DRE DRE
        INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
        WHERE DRE.ID_EMPRESA = vID_EMPRESA
        AND DRE.DRE_CONTA_CONTABIL = '3.01'
        AND BPA.BPA_CONTA_CONTABIL = '1'
        AND ROWNUM < 2;
        
        --IPL:
        SELECT 
             NVL(TRUNC((((BPA1.BPA_VALOR2 + BPA2.BPA_VALOR2 + BPA3.BPA_VALOR2) /
             (CASE BPP1.BPP_VALOR2 WHEN 0 THEN 1 ELSE BPP1.BPP_VALOR2 END)
             ) * 100),2),0)  AS IPL INTO vIPL
        FROM BVSP_BPA
        INNER JOIN BVSP_BPA BPA1 ON BPA1.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        INNER JOIN BVSP_BPA BPA2 ON BPA2.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        INNER JOIN BVSP_BPA BPA3 ON BPA3.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        INNER JOIN BVSP_BPP BPP1 ON BPP1.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        WHERE BVSP_BPA.ID_EMPRESA = vID_EMPRESA
        AND BPA1.BPA_CONTA_CONTABIL = '1.02.02'
        AND BPA2.BPA_CONTA_CONTABIL = '1.02.03'
        AND BPA3.BPA_CONTA_CONTABIL = '1.02.04'
        AND BPP1.BPP_CONTA_CONTABIL = '2.03'
        AND ROWNUM < 2;
        
        --LC:
        SELECT 
            TRUNC(NVL(BVSP_BPA.BPA_VALOR2 / 
            (CASE BVSP_BPP.BPP_VALOR2 WHEN 0 THEN 1 ELSE BVSP_BPP.BPP_VALOR2 END)
            ,0),2) AS LC INTO vLC
        FROM BVSP_BPA
        INNER JOIN BVSP_BPP ON BVSP_BPP.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        WHERE BVSP_BPP.ID_EMPRESA = vID_EMPRESA
        AND BVSP_BPP.BPP_CONTA_CONTABIL = '2.01'
        AND BVSP_BPA.BPA_CONTA_CONTABIL = '1.01'
        AND ROWNUM < 2;

        --LG:
        SELECT
            TRUNC(NVL(BPA.BPA_VALOR2/
            (CASE (BPP1.BPP_VALOR2 + BPP2.BPP_VALOR2) WHEN 0 THEN 1 ELSE (BPP1.BPP_VALOR2 + BPP2.BPP_VALOR2) END)
            ,0),2) AS LG INTO vLG
        FROM BVSP_BPA BPA
        INNER JOIN BVSP_BPP BPP1 ON BPP1.ID_EMPRESA = BPA.ID_EMPRESA
        INNER JOIN BVSP_BPP BPP2 ON BPP2.ID_EMPRESA = BPA.ID_EMPRESA
        WHERE BPA.ID_EMPRESA = vID_EMPRESA
        AND BPA.BPA_CONTA_CONTABIL = '1.02.01'
        AND BPP1.BPP_CONTA_CONTABIL = '2.01'
        AND BPP2.BPP_CONTA_CONTABIL = '2.02'
        AND ROWNUM < 2;
        
        --LS:
        SELECT 
           TRUNC(NVL(((BPA1.BPA_VALOR2 + BPA2.BPA_VALOR2 + BPA3.BPA_VALOR2) / 
           (CASE BPP1.BPP_VALOR2 WHEN 0 THEN 1 ELSE BPP1.BPP_VALOR2 END)
           ),0),2) AS LS INTO vLS
        FROM BVSP_BPA
        INNER JOIN BVSP_BPA BPA1 ON BPA1.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        INNER JOIN BVSP_BPA BPA2 ON BPA2.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        INNER JOIN BVSP_BPA BPA3 ON BPA3.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        INNER JOIN BVSP_BPP BPP1 ON BPP1.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        WHERE BVSP_BPA.ID_EMPRESA = vID_EMPRESA
        AND BPA1.BPA_CONTA_CONTABIL = '1.01.01'
        AND BPA2.BPA_CONTA_CONTABIL = '1.01.02'
        AND BPA3.BPA_CONTA_CONTABIL = '1.01.03'
        AND BPP1.BPP_CONTA_CONTABIL = '2.01'
        AND ROWNUM < 2;
      
        --ML:
        SELECT 
          TRUNC(NVL(((DRE.DRE_VALOR2/
          (CASE DRE1.DRE_VALOR2 WHEN 0 THEN 1 ELSE DRE1.DRE_VALOR2 END)
          ) * 100),0),2) AS ML INTO vML
        FROM BVSP_DRE DRE
        INNER JOIN BVSP_DRE DRE1 ON DRE1.ID_EMPRESA = DRE.ID_EMPRESA
        WHERE DRE.ID_EMPRESA = vID_EMPRESA
        AND DRE.DRE_CONTA_CONTABIL = '3.09'
        AND DRE1.DRE_CONTA_CONTABIL = '3.01'
        AND ROWNUM < 2;
        
        --PCT:
        SELECT 
              NVL(TRUNC((((BPP2.BPP_VALOR2 + BPP3.BPP_VALOR2) / 
              (CASE BPP4.BPP_VALOR2 WHEN 0 THEN 1 ELSE BPP4.BPP_VALOR2 END)
              ) * 100),2),2) AS PCT INTO vPCT
        FROM BVSP_BPP BPP1
        INNER JOIN BVSP_BPP BPP2 ON BPP2.ID_EMPRESA = BPP1.ID_EMPRESA
        INNER JOIN BVSP_BPP BPP3 ON BPP3.ID_EMPRESA = BPP1.ID_EMPRESA
        INNER JOIN BVSP_BPP BPP4 ON BPP4.ID_EMPRESA = BPP1.ID_EMPRESA
        WHERE BPP1.ID_EMPRESA = vID_EMPRESA
        AND BPP2.BPP_CONTA_CONTABIL = '2.01'
        AND BPP3.BPP_CONTA_CONTABIL = '2.02'
        AND BPP4.BPP_CONTA_CONTABIL = '2.03'
        AND ROWNUM < 2;
        
        --PME:
        SELECT 
          TRUNC(NVL(((BPA.BPA_VALOR2/
          (CASE (DRE.DRE_VALOR2 * -1) WHEN 0 THEN 1 ELSE (DRE.DRE_VALOR2 * -1) END)
          ) * 360),0),2) AS PME INTO vPME
        FROM BVSP_DRE DRE
        INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
        WHERE DRE.ID_EMPRESA = vID_EMPRESA
        AND DRE.DRE_CONTA_CONTABIL = '3.02'
        AND BPA.BPA_CONTA_CONTABIL = '1.01.04'
        AND ROWNUM < 2;
        
        --PMP:
        SELECT 
          TRUNC(NVL((((BPP.BPP_VALOR2/
          (CASE (DRE.DRE_VALOR2 * -1) WHEN 0 THEN 1 ELSE (DRE.DRE_VALOR2 * -1) END)
          ) + (BPA.BPA_VALOR2 - BPA.BPA_VALOR3)) * 360),0),2) AS PMP INTO vPMP
        FROM BVSP_DRE DRE
        INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
        INNER JOIN BVSP_BPP BPP ON BPP.ID_EMPRESA = DRE.ID_EMPRESA
        WHERE DRE.ID_EMPRESA = vID_EMPRESA
        AND DRE.DRE_CONTA_CONTABIL = '3.02'
        AND BPA.BPA_CONTA_CONTABIL = '1.01.04'
        AND BPP.BPP_CONTA_CONTABIL = '2.01.02'
        AND ROWNUM < 2;
        
        --PMR:
        SELECT 
          TRUNC(NVL(((BPA.BPA_VALOR2/
          (CASE DRE.DRE_VALOR2 WHEN 0 THEN 1 ELSE DRE.DRE_VALOR2 END)
          ) * 360),0),2) AS PMR INTO vPMR
        FROM BVSP_DRE DRE
        INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
        WHERE DRE.ID_EMPRESA = vID_EMPRESA
        AND DRE.DRE_CONTA_CONTABIL = '3.01'
        AND BPA.BPA_CONTA_CONTABIL = '1.01.03'
        AND ROWNUM < 2;
        
        --RA:
        SELECT 
          TRUNC(NVL((DRE.DRE_VALOR2/
          (CASE BPA.BPA_VALOR2 WHEN 0 THEN 1 ELSE BPA.BPA_VALOR2 END)
          ) * 100,0),2) AS RA INTO vRA
        FROM BVSP_DRE DRE
        INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
        WHERE DRE.ID_EMPRESA = vID_EMPRESA
        AND DRE.DRE_CONTA_CONTABIL = '3.09'
        AND BPA.BPA_CONTA_CONTABIL = '1'
        AND ROWNUM < 2;
        
        --RPL:
        SELECT 
          TRUNC(NVL((DRE.DRE_VALOR2/
          (CASE BPP.BPP_VALOR2 WHEN 0 THEN 1 ELSE BPP.BPP_VALOR2 END)
          ) * 100,0),2) AS RPL INTO vRPL
        FROM BVSP_DRE DRE
        INNER JOIN BVSP_BPP BPP ON BPP.ID_EMPRESA = DRE.ID_EMPRESA
        WHERE DRE.ID_EMPRESA = vID_EMPRESA
        AND DRE.DRE_CONTA_CONTABIL = '3.09'
        AND BPP.BPP_CONTA_CONTABIL = '2.03'
        AND ROWNUM < 2;
        
        
        --INSERE DADOS CALCULADOS NA TABELA:
        INSERT INTO BVSP_INDICADORES 
              (ID_INDICADORES,
               ID_EMPRESA,
               ANO,
               IE_PCT,
               IE_CE,
               IE_IPL,
               IL_LG,
               IL_LC,
               IL_LS,
               IL_CCL,
               IR_GA,
               IR_ML,
               IR_RA,
               IR_RPL,
               IA_PME,
               IA_PMR,
               IA_PMP,
               IA_CO,
               IA_CF) 
         VALUES 
              (BVSP_INDICADORES_SEQ3.NEXTVAL,
               vID_EMPRESA,
               vANO2,
               vPCT,
               vCE,
               vIPL,
               vLG,
               vLC,
               vLS,
               vCCL,
               vGA,
               vML,
               vRA,
               vRPL,
               vPME,
               vPMR,
               vPMP,
               vCO,
               vCF);
               
               
      --#########ANO 3#########--
        --CCL:
        SELECT 
            TRUNC(NVL(BVSP_BPA.BPA_VALOR3 - BVSP_BPP.BPP_VALOR3,0),2) AS CCL INTO vCCL
        FROM BVSP_BPP
        INNER JOIN BVSP_BPA ON BVSP_BPA.ID_EMPRESA = BVSP_BPP.ID_EMPRESA
        WHERE BVSP_BPP.ID_EMPRESA = vID_EMPRESA
        AND BVSP_BPA.BPA_CONTA_CONTABIL = '1.01'
        AND BVSP_BPP.BPP_CONTA_CONTABIL = '2.01'
        AND ROWNUM < 2;
        
        --CE:
        SELECT 
             NVL(TRUNC((BPP1.BPP_VALOR3/
             (CASE (BPP1.BPP_VALOR3+BPP2.BPP_VALOR3) WHEN 0 THEN 1 ELSE (BPP1.BPP_VALOR3+BPP2.BPP_VALOR3) END)
             * 100),2),0) AS CE INTO vCE
        FROM BVSP_BPP
        INNER JOIN BVSP_BPP BPP1 ON BPP1.ID_EMPRESA = BVSP_BPP.ID_EMPRESA
        INNER JOIN BVSP_BPP BPP2 ON BPP2.ID_EMPRESA = BVSP_BPP.ID_EMPRESA
        WHERE BVSP_BPP.ID_EMPRESA = vID_EMPRESA
        AND BPP1.BPP_CONTA_CONTABIL = '2.01'
        AND BPP2.BPP_CONTA_CONTABIL = '2.02'
        AND ROWNUM < 2;   
        
        --CF:
        SELECT
            (SELECT 
              TRUNC(NVL((((BPP.BPP_VALOR3/
              (CASE (DRE.DRE_VALOR3 * -1) WHEN 0 THEN 1 ELSE (DRE.DRE_VALOR3 * -1) END)
              ) + (BPA.BPA_VALOR2 - 0)) * 360),0),2) AS PMP
            FROM BVSP_DRE DRE
            INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
            INNER JOIN BVSP_BPP BPP ON BPP.ID_EMPRESA = DRE.ID_EMPRESA
            WHERE DRE.ID_EMPRESA = BVSP_DRE.ID_EMPRESA
            AND DRE.DRE_CONTA_CONTABIL = '3.02'
            AND BPA.BPA_CONTA_CONTABIL = '1.01.04'
            AND BPP.BPP_CONTA_CONTABIL = '2.01.02'
            AND ROWNUM < 2)
            -
            ((SELECT 
                TRUNC(NVL(((BPA.BPA_VALOR3/
                (CASE (DRE.DRE_VALOR3 * -1) WHEN 0 THEN 1 ELSE (DRE.DRE_VALOR3 * -1) END)
                ) * 360),0),2) AS PME
              FROM BVSP_DRE DRE
              INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
              WHERE DRE.ID_EMPRESA = BVSP_DRE.ID_EMPRESA
              AND DRE.DRE_CONTA_CONTABIL = '3.02'
              AND BPA.BPA_CONTA_CONTABIL = '1.01.04'
              AND ROWNUM < 2)
              +
              (SELECT 
                TRUNC(NVL(((BPA.BPA_VALOR3/
                (CASE DRE.DRE_VALOR3 WHEN 0 THEN 1 ELSE DRE.DRE_VALOR3 END)
                ) * 360),0),2) AS PMR
              FROM BVSP_DRE DRE
              INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
              WHERE DRE.ID_EMPRESA = BVSP_DRE.ID_EMPRESA
              AND DRE.DRE_CONTA_CONTABIL = '3.01'
              AND BPA.BPA_CONTA_CONTABIL = '1.01.03'
              AND ROWNUM < 2)
            ) AS CF INTO vCF
        FROM BVSP_DRE
        WHERE BVSP_DRE.ID_EMPRESA = vID_EMPRESA
        AND ROWNUM < 2;
        
        --CO:
        SELECT
            TRUNC(NVL(
            (SELECT 
              TRUNC(NVL(((BPA.BPA_VALOR3/
              (CASE (DRE.DRE_VALOR3 * -1) WHEN 0 THEN 1 ELSE (DRE.DRE_VALOR3 * -1) END)
              ) * 360),0),2)
            FROM BVSP_DRE DRE
            INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
            WHERE DRE.ID_EMPRESA = vID_EMPRESA
            AND DRE.DRE_CONTA_CONTABIL = '3.02'
            AND BPA.BPA_CONTA_CONTABIL = '1.01.04'
            AND ROWNUM < 2)
          +
            (SELECT 
              TRUNC(NVL(((BPA.BPA_VALOR3/
              (CASE DRE.DRE_VALOR3 WHEN 0 THEN 1 ELSE DRE.DRE_VALOR3 END)
              ) * 360),0),2)
            FROM BVSP_DRE DRE
            INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
            WHERE DRE.ID_EMPRESA = vID_EMPRESA
            AND DRE.DRE_CONTA_CONTABIL = '3.01'
            AND BPA.BPA_CONTA_CONTABIL = '1.01.03'
            AND ROWNUM < 2)
            ,0),2) AS CO INTO vCO
        FROM BVSP_DRE
        WHERE BVSP_DRE.ID_EMPRESA = vID_EMPRESA
        AND ROWNUM < 2;
        
        
        --GA:
        SELECT 
            TRUNC(NVL(DRE.DRE_VALOR3/
            (CASE BPA.BPA_VALOR3 WHEN 0 THEN 1 ELSE BPA.BPA_VALOR3 END) 
            ,0),2) AS GA INTO vGA
        FROM BVSP_DRE DRE
        INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
        WHERE DRE.ID_EMPRESA = vID_EMPRESA
        AND DRE.DRE_CONTA_CONTABIL = '3.01'
        AND BPA.BPA_CONTA_CONTABIL = '1'
        AND ROWNUM < 2;
        
        --IPL:
        SELECT 
             NVL(TRUNC((((BPA1.BPA_VALOR3 + BPA2.BPA_VALOR3 + BPA3.BPA_VALOR3) /
             (CASE BPP1.BPP_VALOR3 WHEN 0 THEN 1 ELSE BPP1.BPP_VALOR3 END)
             ) * 100),2),0)  AS IPL INTO vIPL
        FROM BVSP_BPA
        INNER JOIN BVSP_BPA BPA1 ON BPA1.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        INNER JOIN BVSP_BPA BPA2 ON BPA2.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        INNER JOIN BVSP_BPA BPA3 ON BPA3.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        INNER JOIN BVSP_BPP BPP1 ON BPP1.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        WHERE BVSP_BPA.ID_EMPRESA = vID_EMPRESA
        AND BPA1.BPA_CONTA_CONTABIL = '1.02.02'
        AND BPA2.BPA_CONTA_CONTABIL = '1.02.03'
        AND BPA3.BPA_CONTA_CONTABIL = '1.02.04'
        AND BPP1.BPP_CONTA_CONTABIL = '2.03'
        AND ROWNUM < 2;
        
        --LC:
        SELECT 
            TRUNC(NVL(BVSP_BPA.BPA_VALOR3 / 
            (CASE BVSP_BPP.BPP_VALOR3 WHEN 0 THEN 1 ELSE BVSP_BPP.BPP_VALOR3 END)
            ,0),2) AS LC INTO vLC
        FROM BVSP_BPA
        INNER JOIN BVSP_BPP ON BVSP_BPP.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        WHERE BVSP_BPP.ID_EMPRESA = vID_EMPRESA
        AND BVSP_BPP.BPP_CONTA_CONTABIL = '2.01'
        AND BVSP_BPA.BPA_CONTA_CONTABIL = '1.01'
        AND ROWNUM < 2;

        --LG:
        SELECT
            TRUNC(NVL(BPA.BPA_VALOR3/
            (CASE (BPP1.BPP_VALOR3 + BPP2.BPP_VALOR3) WHEN 0 THEN 1 ELSE (BPP1.BPP_VALOR3 + BPP2.BPP_VALOR3) END)
            ,0),2) AS LG INTO vLG
        FROM BVSP_BPA BPA
        INNER JOIN BVSP_BPP BPP1 ON BPP1.ID_EMPRESA = BPA.ID_EMPRESA
        INNER JOIN BVSP_BPP BPP2 ON BPP2.ID_EMPRESA = BPA.ID_EMPRESA
        WHERE BPA.ID_EMPRESA = vID_EMPRESA
        AND BPA.BPA_CONTA_CONTABIL = '1.02.01'
        AND BPP1.BPP_CONTA_CONTABIL = '2.01'
        AND BPP2.BPP_CONTA_CONTABIL = '2.02'
        AND ROWNUM < 2;
        
        --LS:
        SELECT 
           TRUNC(NVL(((BPA1.BPA_VALOR3 + BPA2.BPA_VALOR3 + BPA3.BPA_VALOR3) / 
           (CASE BPP1.BPP_VALOR3 WHEN 0 THEN 1 ELSE BPP1.BPP_VALOR3 END)
           ),0),2) AS LS INTO vLS
        FROM BVSP_BPA
        INNER JOIN BVSP_BPA BPA1 ON BPA1.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        INNER JOIN BVSP_BPA BPA2 ON BPA2.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        INNER JOIN BVSP_BPA BPA3 ON BPA3.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        INNER JOIN BVSP_BPP BPP1 ON BPP1.ID_EMPRESA = BVSP_BPA.ID_EMPRESA
        WHERE BVSP_BPA.ID_EMPRESA = vID_EMPRESA
        AND BPA1.BPA_CONTA_CONTABIL = '1.01.01'
        AND BPA2.BPA_CONTA_CONTABIL = '1.01.02'
        AND BPA3.BPA_CONTA_CONTABIL = '1.01.03'
        AND BPP1.BPP_CONTA_CONTABIL = '2.01'
        AND ROWNUM < 2;
      
        --ML:
        SELECT 
          TRUNC(NVL(((DRE.DRE_VALOR3/
          (CASE DRE1.DRE_VALOR3 WHEN 0 THEN 1 ELSE DRE1.DRE_VALOR3 END)
          ) * 100),0),2) AS ML INTO vML
        FROM BVSP_DRE DRE
        INNER JOIN BVSP_DRE DRE1 ON DRE1.ID_EMPRESA = DRE.ID_EMPRESA
        WHERE DRE.ID_EMPRESA = vID_EMPRESA
        AND DRE.DRE_CONTA_CONTABIL = '3.09'
        AND DRE1.DRE_CONTA_CONTABIL = '3.01'
        AND ROWNUM < 2;
        
        --PCT:
        SELECT 
              NVL(TRUNC((((BPP2.BPP_VALOR3 + BPP3.BPP_VALOR3) / 
              (CASE BPP4.BPP_VALOR3 WHEN 0 THEN 1 ELSE BPP4.BPP_VALOR3 END)
              ) * 100),2),2) AS PCT INTO vPCT
        FROM BVSP_BPP BPP1
        INNER JOIN BVSP_BPP BPP2 ON BPP2.ID_EMPRESA = BPP1.ID_EMPRESA
        INNER JOIN BVSP_BPP BPP3 ON BPP3.ID_EMPRESA = BPP1.ID_EMPRESA
        INNER JOIN BVSP_BPP BPP4 ON BPP4.ID_EMPRESA = BPP1.ID_EMPRESA
        WHERE BPP1.ID_EMPRESA = vID_EMPRESA
        AND BPP2.BPP_CONTA_CONTABIL = '2.01'
        AND BPP3.BPP_CONTA_CONTABIL = '2.02'
        AND BPP4.BPP_CONTA_CONTABIL = '2.03'
        AND ROWNUM < 2;
        
        --PME:
        SELECT 
          TRUNC(NVL(((BPA.BPA_VALOR3/
          (CASE (DRE.DRE_VALOR3 * -1) WHEN 0 THEN 1 ELSE (DRE.DRE_VALOR3 * -1) END)
          ) * 360),0),2) AS PME INTO vPME
        FROM BVSP_DRE DRE
        INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
        WHERE DRE.ID_EMPRESA = vID_EMPRESA
        AND DRE.DRE_CONTA_CONTABIL = '3.02'
        AND BPA.BPA_CONTA_CONTABIL = '1.01.04'
        AND ROWNUM < 2;
        
        --PMP:
        SELECT 
          TRUNC(NVL((((BPP.BPP_VALOR3/
          (CASE (DRE.DRE_VALOR3 * -1) WHEN 0 THEN 1 ELSE (DRE.DRE_VALOR3 * -1) END)
          ) + (BPA.BPA_VALOR3 - 0)) * 360),0),2) AS PMP INTO vPMP
        FROM BVSP_DRE DRE
        INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
        INNER JOIN BVSP_BPP BPP ON BPP.ID_EMPRESA = DRE.ID_EMPRESA
        WHERE DRE.ID_EMPRESA = vID_EMPRESA
        AND DRE.DRE_CONTA_CONTABIL = '3.02'
        AND BPA.BPA_CONTA_CONTABIL = '1.01.04'
        AND BPP.BPP_CONTA_CONTABIL = '2.01.02'
        AND ROWNUM < 2;
        
        --PMR:
        SELECT 
          TRUNC(NVL(((BPA.BPA_VALOR3/
          (CASE DRE.DRE_VALOR3 WHEN 0 THEN 1 ELSE DRE.DRE_VALOR3 END)
          ) * 360),0),2) AS PMR INTO vPMR
        FROM BVSP_DRE DRE
        INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
        WHERE DRE.ID_EMPRESA = vID_EMPRESA
        AND DRE.DRE_CONTA_CONTABIL = '3.01'
        AND BPA.BPA_CONTA_CONTABIL = '1.01.03'
        AND ROWNUM < 2;
        
        --RA:
        SELECT 
          TRUNC(NVL((DRE.DRE_VALOR3/
          (CASE BPA.BPA_VALOR3 WHEN 0 THEN 1 ELSE BPA.BPA_VALOR3 END)
          ) * 100,0),2) AS RA INTO vRA
        FROM BVSP_DRE DRE
        INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
        WHERE DRE.ID_EMPRESA = vID_EMPRESA
        AND DRE.DRE_CONTA_CONTABIL = '3.09'
        AND BPA.BPA_CONTA_CONTABIL = '1'
        AND ROWNUM < 2;
        
        --RPL:
        SELECT 
          TRUNC(NVL((DRE.DRE_VALOR3/
          (CASE BPP.BPP_VALOR3 WHEN 0 THEN 1 ELSE BPP.BPP_VALOR3 END)
          ) * 100,0),2) AS RPL INTO vRPL
        FROM BVSP_DRE DRE
        INNER JOIN BVSP_BPP BPP ON BPP.ID_EMPRESA = DRE.ID_EMPRESA
        WHERE DRE.ID_EMPRESA = vID_EMPRESA
        AND DRE.DRE_CONTA_CONTABIL = '3.09'
        AND BPP.BPP_CONTA_CONTABIL = '2.03'
        AND ROWNUM < 2;
        
        
        --INSERE DADOS CALCULADOS NA TABELA:
        INSERT INTO BVSP_INDICADORES 
              (ID_INDICADORES,
               ID_EMPRESA,
               ANO,
               IE_PCT,
               IE_CE,
               IE_IPL,
               IL_LG,
               IL_LC,
               IL_LS,
               IL_CCL,
               IR_GA,
               IR_ML,
               IR_RA,
               IR_RPL,
               IA_PME,
               IA_PMR,
               IA_PMP,
               IA_CO,
               IA_CF) 
         VALUES 
              (BVSP_INDICADORES_SEQ3.NEXTVAL,
               vID_EMPRESA,
               vANO3,
               vPCT,
               vCE,
               vIPL,
               vLG,
               vLC,
               vLS,
               vCCL,
               vGA,
               vML,
               vRA,
               vRPL,
               vPME,
               vPMR,
               vPMP,
               vCO,
               vCF);
        
  
END BVSP_SP_INDICADORES;