using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using Projeto.Models;

namespace Projeto.Controllers
{
    [Authorize]
    public class UsuarioAdminController : Controller
    {
        private Model1 db = new Model1();

        // GET: UsuarioAdmins
        public ActionResult Index()
        {
            return View(db.BREW_USER_MANAGEMENT.ToList());
        }

        // GET: UsuarioAdmins/Details/5
        public ActionResult Details(decimal? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            UsuarioAdmin usuarioAdmin = db.BREW_USER_MANAGEMENT.Find(id);
            if (usuarioAdmin == null)
            {
                return HttpNotFound();
            }
            return View(usuarioAdmin);
        }

        // GET: UsuarioAdmins/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: UsuarioAdmins/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "ID_USER_MANAGEMENT,USER_MANAGEMENT,NAME_USER_MANAGEMENT,PASSWORD_USER_MANAGEMENT")] UsuarioAdmin usuarioAdmin)
        {
            if (ModelState.IsValid)
            {
                db.BREW_USER_MANAGEMENT.Add(usuarioAdmin);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(usuarioAdmin);
        }

        // GET: UsuarioAdmins/Edit/5
        public ActionResult Edit(decimal? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            UsuarioAdmin usuarioAdmin = db.BREW_USER_MANAGEMENT.Find(id);
            if (usuarioAdmin == null)
            {
                return HttpNotFound();
            }
            return View(usuarioAdmin);
        }

        // POST: UsuarioAdmins/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "ID_USER_MANAGEMENT,USER_MANAGEMENT,NAME_USER_MANAGEMENT,PASSWORD_USER_MANAGEMENT")] UsuarioAdmin usuarioAdmin)
        {
            if (ModelState.IsValid)
            {
                db.Entry(usuarioAdmin).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(usuarioAdmin);
        }

        // GET: UsuarioAdmins/Delete/5
        public ActionResult Delete(decimal? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            UsuarioAdmin usuarioAdmin = db.BREW_USER_MANAGEMENT.Find(id);
            if (usuarioAdmin == null)
            {
                return HttpNotFound();
            }
            return View(usuarioAdmin);
        }

        // POST: UsuarioAdmins/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(decimal id)
        {
            UsuarioAdmin usuarioAdmin = db.BREW_USER_MANAGEMENT.Find(id);
            db.BREW_USER_MANAGEMENT.Remove(usuarioAdmin);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
