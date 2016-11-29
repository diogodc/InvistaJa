namespace Projeto.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("BRUNOBRANDAO.BREW_PROFILE")]
    public partial class Perfil
    {
        [Key]
        public decimal ID_PROFILE { get; set; }
        
        public decimal ID_USER { get; set; }

        [StringLength(50)]
        public string NAME_PROFILE { get; set; }

        [StringLength(500)]
        public string Resumo { get; set; }

        public decimal? TYPE { get; set; }

        public virtual UsuarioSite Usuario { get; set; }
    }
}
