SELECT
    TRUNC(NVL(BPA.BPA_VALOR1/(BPP1.BPP_VALOR1 + BPP2.BPP_VALOR1),0),2) AS LG
FROM BVSP_BPA BPA
INNER JOIN BVSP_BPP BPP1 ON BPP1.ID_EMPRESA = BPA.ID_EMPRESA
INNER JOIN BVSP_BPP BPP2 ON BPP2.ID_EMPRESA = BPA.ID_EMPRESA
WHERE BPA.ID_EMPRESA = 65
AND BPA.BPA_CONTA_CONTABIL = '1.02.01'
AND BPP1.BPP_CONTA_CONTABIL = '2.01'
AND BPP2.BPP_CONTA_CONTABIL = '2.02'
AND ROWNUM < 2;