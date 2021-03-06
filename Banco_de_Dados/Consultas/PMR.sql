SELECT 
  TRUNC(NVL(((BPA.BPA_VALOR1/DRE.DRE_VALOR1) * 360),0),2) AS PMR
FROM BVSP_DRE DRE
INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
WHERE DRE.ID_EMPRESA = 65
AND DRE.DRE_CONTA_CONTABIL = '3.01'
AND BPA.BPA_CONTA_CONTABIL = '1.01.03'
AND ROWNUM < 2;