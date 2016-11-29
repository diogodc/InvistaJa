namespace Projeto.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("BRUNOBRANDAO.BREW_QUESTION")]
    public partial class Perguntas
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public Perguntas()
        {
            Respostas = new HashSet<Respostas>();
        }

        [Key]
        public decimal ID_QUESTION { get; set; }

        [StringLength(4000)]
        [Required(ErrorMessage = "Informe a descrição da pergunta.")]
        [DisplayName("Descrição")]
        [DataType(DataType.MultilineText)]
        public string QUESTION { get; set; }

        [Required(ErrorMessage = "Informe a número da pergunta.")]
        [DisplayName("Número da Pergunta")]
        [DataType(DataType.MultilineText)]
        public decimal? QUESTION_NUMBER { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<Respostas> Respostas { get; set; }
    }
}
