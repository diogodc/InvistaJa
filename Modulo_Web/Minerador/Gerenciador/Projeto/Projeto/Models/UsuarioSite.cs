namespace Projeto.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("BRUNOBRANDAO.BREW_USER")]
    public partial class UsuarioSite
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public UsuarioSite()
        {
            BREW_PROFILE = new HashSet<Perfil>();
        }

        [Key]
        public decimal ID_USER { get; set; }
        
        [StringLength(50)]
        [Required(ErrorMessage = "O Digite seu email!")]
        [DataType(DataType.EmailAddress)]
        [DisplayName("Email")]
        public string LOGIN { get; set; }

        [StringLength(100)]
        [Required(ErrorMessage = "Digite Um Nome!")]
        [DataType(DataType.Text)]
        [DisplayName("Nome")]
        public string NAME_USER { get; set; }

        [StringLength(50)]
        [Required(ErrorMessage = "Digite sua senha!")]
        [DataType(DataType.Password)]
        [DisplayName("Senha")]
        public string PASSWORD_USER { get; set; }
        
        [StringLength(20)]
        [Required(ErrorMessage = "O telefone deve ser informado.!")]
        [DataType(DataType.PhoneNumber, ErrorMessage = "Forneça o número do telefone no formato (00) 00000-0000")]
        [DisplayName("Número do Telefone")]
        public string PHONE_NUMBER_USER { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<Perfil> BREW_PROFILE { get; set; }
    }
}
