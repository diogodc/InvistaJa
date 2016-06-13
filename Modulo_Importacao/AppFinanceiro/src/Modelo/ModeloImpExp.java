package Modelo;

/**
 *
 * @author E. Cardoso de Araújo
 */
public class ModeloImpExp {
   private int iEmpresa_ID;
   private String sConta;
   private String sDescricao;
   private String sPeriodo_1;
   private String sPeriodo_2;
   private String sPeriodo_3;
   private String dValor_1;
   private String dValor_2;
   private String dValor_3;
   
   public ModeloImpExp(){
       iEmpresa_ID = 0;
       sConta = "";
       sDescricao = "";
       sPeriodo_1 = "";
       sPeriodo_2 = "";
       sPeriodo_3 = "";
       dValor_1 = "0.0";
       dValor_2 = "0.0";
       dValor_3 = "0.0";
   }
   
    public ModeloImpExp(int iEmpresa_ID,String sConta,String sDescricao,
            String sPeriodo_1,String sPeriodo_2,String sPeriodo_3,
            String dValor_1, String dValor_2, String dValor_3){
       this.iEmpresa_ID = iEmpresa_ID;
       this.sConta = sConta;
       this.sDescricao = sDescricao;
       this.sPeriodo_1 = sPeriodo_1;
       this.sPeriodo_2 = sPeriodo_2;
       this.sPeriodo_3 = sPeriodo_3;
       this.dValor_1 = dValor_1;
       this.dValor_2 = dValor_2;
       this.dValor_3 = dValor_3;
   }
    
    public void setEmpresa_ID(int iEmpresa_ID){
        this.iEmpresa_ID = iEmpresa_ID;
    }
    public void setConta(String sConta){
        this.sConta = sConta;
    }
    public void setDescricao(String sDescricao){
        this.sDescricao = sDescricao;
    }
    public void setPeriodo_1(String sPeriodo_1){
        this.sPeriodo_1 = sPeriodo_1;
    }
    public void setPeriodo_2(String sPeriodo_2){
        this.sPeriodo_2 = sPeriodo_2;
    }
    public void setPeriodo_3(String sPeriodo_3){
        this.sPeriodo_3 = sPeriodo_3;
    }
    public void setValor_1(String dValor_1) {
        this.dValor_1 = dValor_1;
    }
    public void setValor_2(String dValor_2) {
        this.dValor_2 = dValor_2;
    }
    public void setValor_3(String dValor_3) {
        this.dValor_3 = dValor_3;
    }
        
    public int getEmpresa_ID(){
        return this.iEmpresa_ID;
    }
    public String getConta(){
        return this.sConta.replace("'", "''").replace("�", "");
    }
    public String getDescricao(){
        return this.sDescricao.replace("'", "''").replace("�", "");
    }
    public String getPeriodo_1(){
        return this.sPeriodo_1.replace("�", "");
    }
    public String getPeriodo_2(){
        return this.sPeriodo_2.replace("�", "");
    }
    public String getPeriodo_3(){
        return this.sPeriodo_3.replace("�", "");
    }
    public String getValor_1() {
        return dValor_1.replace("�", "").replace(".", "").replace(",", ".");
    }
    public String getValor_2() {
        return dValor_2.replace("�", "").replace(".", "").replace(",", ".");
    }
    public String getValor_3() {
        return dValor_3.replace("�", "").replace(".", "").replace(",", ".");
    }
}
