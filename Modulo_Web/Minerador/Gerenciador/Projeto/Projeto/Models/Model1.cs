namespace Projeto.Models
{
    using System;
    using System.Data.Entity;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Linq;

    public partial class Model1 : DbContext
    {
        public Model1()
            : base("name=Model1")
        {
        }

        public virtual DbSet<Respostas> BREW_ANSWER { get; set; }
        public virtual DbSet<Perfil> BREW_PROFILE { get; set; }
        public virtual DbSet<Perguntas> BREW_QUESTION { get; set; }
        public virtual DbSet<UsuarioSite> BREW_USER { get; set; }
        public virtual DbSet<UsuarioAdmin> BREW_USER_MANAGEMENT { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Respostas>()
                .Property(e => e.ID_ANSWER)
                .HasPrecision(38, 0);

            modelBuilder.Entity<Respostas>()
                .Property(e => e.ANSWER_TEXT)
                .IsUnicode(false);

            modelBuilder.Entity<Respostas>()
                .Property(e => e.WEIGHT_ANSWER)
                .HasPrecision(38, 0);

            modelBuilder.Entity<Respostas>()
                .Property(e => e.ID_QUESTION)
                .HasPrecision(38, 0);

            modelBuilder.Entity<Perfil>()
                .Property(e => e.ID_PROFILE)
                .HasPrecision(38, 0);

            modelBuilder.Entity<Perfil>()
                .Property(e => e.ID_USER)
                .HasPrecision(38, 0);

            modelBuilder.Entity<Perfil>()
                .Property(e => e.NAME_PROFILE)
                .IsUnicode(false);

            modelBuilder.Entity<Perfil>()
                .Property(e => e.Resumo)
                .IsUnicode(false);

            modelBuilder.Entity<Perfil>()
                .Property(e => e.TYPE)
                .HasPrecision(38, 0);

            modelBuilder.Entity<Perguntas>()
                .Property(e => e.ID_QUESTION)
                .HasPrecision(38, 0);

            modelBuilder.Entity<Perguntas>()
                .Property(e => e.QUESTION)
                .IsUnicode(false);

            modelBuilder.Entity<Perguntas>()
                .Property(e => e.QUESTION_NUMBER)
                .HasPrecision(38, 0);

            modelBuilder.Entity<UsuarioSite>()
                .Property(e => e.ID_USER)
                .HasPrecision(38, 0);

            modelBuilder.Entity<UsuarioSite>()
                .Property(e => e.LOGIN)
                .IsUnicode(false);

            modelBuilder.Entity<UsuarioSite>()
                .Property(e => e.NAME_USER)
                .IsUnicode(false);

            modelBuilder.Entity<UsuarioSite>()
                .Property(e => e.PASSWORD_USER)
                .IsUnicode(false);

            modelBuilder.Entity<UsuarioSite>()
                .Property(e => e.PHONE_NUMBER_USER)
                .IsUnicode(false);

            modelBuilder.Entity<UsuarioSite>()
                .HasMany(e => e.BREW_PROFILE)
                .WithRequired(e => e.Usuario)
                .WillCascadeOnDelete(false);

            modelBuilder.Entity<UsuarioAdmin>()
                .Property(e => e.ID_USER_MANAGEMENT)
                .HasPrecision(38, 0);

            modelBuilder.Entity<UsuarioAdmin>()
                .Property(e => e.USER_MANAGEMENT)
                .IsUnicode(false);

            modelBuilder.Entity<UsuarioAdmin>()
                .Property(e => e.NAME_USER_MANAGEMENT)
                .IsUnicode(false);

            modelBuilder.Entity<UsuarioAdmin>()
                .Property(e => e.PASSWORD_USER_MANAGEMENT)
                .IsUnicode(false);
        }
    }
}
