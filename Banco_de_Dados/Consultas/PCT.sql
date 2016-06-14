SELECT 
      TRUNC(((((SELECT NVL(BPP1.BPP_VALOR1,0) FROM BVSP_BPP BPP1
      WHERE BPP1.ID_EMPRESA = BPP.ID_EMPRESA
      AND BPP1.BPP_CONTA_CONTABIL = '2.01')+
      (SELECT NVL(BPP2.BPP_VALOR1,0) FROM BVSP_BPP BPP2
      WHERE BPP2.ID_EMPRESA = BPP.ID_EMPRESA
      AND BPP2.BPP_CONTA_CONTABIL = '2.02')) / 
      (SELECT NVL(BPP3.BPP_VALOR1,1) FROM BVSP_BPP BPP3 
      WHERE BPP3.ID_EMPRESA = BPP.ID_EMPRESA
      AND BPP3.BPP_CONTA_CONTABIL = '2.03'))*
      100),2) AS PCT
FROM BVSP_BPP BPP
WHERE BPP.ID_EMPRESA = 65
AND ROWNUM < 2;