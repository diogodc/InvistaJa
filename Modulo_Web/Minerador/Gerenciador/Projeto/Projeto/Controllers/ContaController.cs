using System;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Projeto.Models;


namespace Projeto.Controllers
{
    public class ContaController : Controller
    {
        // GET: Conta
        public ActionResult Login()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Login(UsuarioAdmin user)
        {
            using (Model1 db = new Model1())
            {
                //var usr = db.BREW_USER_MANAGEMENT.Where(u => u.USER_MANAGEMENT == user.USER_MANAGEMENT && u.PASSWORD_USER_MANAGEMENT == user.PASSWORD_USER_MANAGEMENT);
                var usr = db.BREW_USER_MANAGEMENT.Where(u => u.USER_MANAGEMENT == user.USER_MANAGEMENT && u.PASSWORD_USER_MANAGEMENT == user.PASSWORD_USER_MANAGEMENT).FirstOrDefault();


                if (usr != null)
                {
                    System.Web.Security.FormsAuthentication.SetAuthCookie(user.USER_MANAGEMENT, false);
                    return RedirectToAction("../Home/Index");
                }
                else
                {
                    ModelState.AddModelError("","Usuário ou Senha Incorreto.");
                }
            }
            return View();
        }

        public ActionResult Logoff()
        {
            System.Web.Security.FormsAuthentication.SignOut();

            return Redirect("Login");
        }
    }
}