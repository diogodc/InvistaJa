SELECT 
  TRUNC(NVL((DRE.DRE_VALOR1/BPP.BPP_VALOR1) * 100,0),2) AS RPL
FROM BVSP_DRE DRE
INNER JOIN BVSP_BPP BPP ON BPP.ID_EMPRESA = DRE.ID_EMPRESA
WHERE DRE.ID_EMPRESA = 65
AND DRE.DRE_CONTA_CONTABIL = '3.09'
AND BPP.BPP_CONTA_CONTABIL = '2.03'
AND ROWNUM < 2;