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
    public class UsuarioSiteController : Controller
    {
        private Model1 db = new Model1();

        // GET: UsuarioSites
        public ActionResult Index()
        {
            return View(db.BREW_USER.ToList());
        }

        // GET: UsuarioSites/Details/5
        public ActionResult Details(decimal? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            UsuarioSite usuarioSite = db.BREW_USER.Find(id);
            if (usuarioSite == null)
            {
                return HttpNotFound();
            }
            return View(usuarioSite);
        }

        // GET: UsuarioSites/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: UsuarioSites/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "ID_USER,LOGIN,NAME_USER,PASSWORD_USER,PHONE_NUMBER_USER")] UsuarioSite usuarioSite)
        {
            if (ModelState.IsValid)
            {
                db.BREW_USER.Add(usuarioSite);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(usuarioSite);
        }

        // GET: UsuarioSites/Edit/5
        public ActionResult Edit(decimal? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            UsuarioSite usuarioSite = db.BREW_USER.Find(id);
            if (usuarioSite == null)
            {
                return HttpNotFound();
            }
            return View(usuarioSite);
        }

        // POST: UsuarioSites/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "ID_USER,LOGIN,NAME_USER,PASSWORD_USER,PHONE_NUMBER_USER")] UsuarioSite usuarioSite)
        {
            if (ModelState.IsValid)
            {
                db.Entry(usuarioSite).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(usuarioSite);
        }

        // GET: UsuarioSites/Delete/5
        public ActionResult Delete(decimal? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            UsuarioSite usuarioSite = db.BREW_USER.Find(id);
            if (usuarioSite == null)
            {
                return HttpNotFound();
            }
            return View(usuarioSite);
        }

        // POST: UsuarioSites/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(decimal id)
        {
            UsuarioSite usuarioSite = db.BREW_USER.Find(id);
            db.BREW_USER.Remove(usuarioSite);
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
