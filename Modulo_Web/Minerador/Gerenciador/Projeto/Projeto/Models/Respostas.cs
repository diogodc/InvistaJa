namespace Projeto.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("BRUNOBRANDAO.BREW_ANSWER")]
    public partial class Respostas
    {
        [Key]
        public decimal ID_ANSWER { get; set; }
        
        [Required(ErrorMessage = "Informe a descrição da resposta.")]
        [DisplayName("Resposta")]
        [DataType(DataType.MultilineText)]
        public string ANSWER_TEXT { get; set; }

        [Required(ErrorMessage ="Informe o Peso da resposta")]
        [DisplayName("Peso da Resposta")]
        [DataType(DataType.Custom)]
        public decimal? WEIGHT_ANSWER { get; set; }
        
        public decimal? ID_QUESTION { get; set; }

        public virtual Perguntas Pergunta { get; set; }
    }
}
