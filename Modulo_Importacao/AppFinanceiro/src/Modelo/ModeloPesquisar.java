package Modelo;

/**
 *
 * @author E. Cardoso de Araújo
 */
public class ModeloPesquisar {
    private String sParamentros;
    private String sTabela;
    private String sJoin;
    private String sTipoFiltro;
    private String sFiltro;
    private String sCampoFiltro;
    private String sCondicao; 
    private CreateModel mArvore;
    
    public String getParamentros() {
        return sParamentros;
    }

    public void setParamentros(String sParamentros) {
        this.sParamentros = sParamentros;
    }

    public String getTabela() {
        return sTabela;
    }

    public void setTabela(String sTabela) {
        this.sTabela = sTabela;
    }

    public String getJoin() {
        return sJoin;
    }

    public void setJoin(String sJoin) {
        this.sJoin = sJoin;
    }

    public String getTipoFiltro() {
        return sTipoFiltro;
    }

    public void setTipoFiltro(String sTipoFiltro) {
        this.sTipoFiltro = sTipoFiltro;
    }

    public String getFiltro() {
        return sFiltro.replace("'", "''");
    }

    public void setFiltro(String sFiltro) {
        this.sFiltro = sFiltro;
    }

    public String getCampoFiltro() {
        return sCampoFiltro;
    }

    public void setCampoFiltro(String sCampoFiltro) {
        this.sCampoFiltro = sCampoFiltro;
    }

    public String getCondicao() {
        return sCondicao;
    }

    public void setCondicao(String sCondicao) {
        this.sCondicao = sCondicao;
    }

    /**
     * @return 
     * @add Rafael 22/05/16
     * @desordenando a consulta
     */
    public String getOrderBy() {   
        return "order by sys_guid() desc ";
    }
    
    /**
     * @return 
     * @add Rafael 22/05/16
     * @desordenando a consulta
     */
    public CreateModel geModeloArvore() {   
        return mArvore;
    }
    
   /**
     * @param mArvore the mArvore to set
     */
    public void setModeloArvore(CreateModel mArvore) {
        this.mArvore = mArvore;
    }
}
