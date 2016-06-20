SELECT 
  TRUNC(NVL(((BPA.BPA_VALOR1/(DRE.DRE_VALOR1 * -1)) * 360),0),2) AS PME
FROM BVSP_DRE DRE
INNER JOIN BVSP_BPA BPA ON BPA.ID_EMPRESA = DRE.ID_EMPRESA
WHERE DRE.ID_EMPRESA = 65
AND DRE.DRE_CONTA_CONTABIL = '3.02'
AND BPA.BPA_CONTA_CONTABIL = '1.01.04'
AND ROWNUM < 2;