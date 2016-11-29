namespace Projeto.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("BRUNOBRANDAO.BREW_USER_MANAGEMENT")]
    public partial class UsuarioAdmin
    {
        [Key]
        public decimal ID_USER_MANAGEMENT { get; set; }

        [StringLength(50)]
        [Required(ErrorMessage = "O Digite seu email!")]
        [DataType(DataType.EmailAddress)]
        [DisplayName("Email")]
        public string USER_MANAGEMENT { get; set; }

        [StringLength(100)]
        [Required(ErrorMessage ="Digite Um Nome!")]
        [DataType(DataType.Text)]
        [DisplayName("Nome")]
        public string NAME_USER_MANAGEMENT { get; set; }

        [StringLength(10)]
        [Required(ErrorMessage = "Digite sua senha!")]
        [DataType(DataType.Password)]
        [DisplayName("Senha")]
        public string PASSWORD_USER_MANAGEMENT { get; set; }
    }
}
