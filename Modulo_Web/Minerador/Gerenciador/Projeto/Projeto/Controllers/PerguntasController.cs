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
    public class PerguntasController : Controller
    {
        private Model1 db = new Model1();

        // GET: Perguntas
        public ActionResult Index()
        {
            return View(db.BREW_QUESTION.ToList());
        }

        // GET: Perguntas/Details/5
        public ActionResult Details(decimal? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Perguntas perguntas = db.BREW_QUESTION.Find(id);
            if (perguntas == null)
            {
                return HttpNotFound();
            }
            return View(perguntas);
        }

        // GET: Perguntas/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Perguntas/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "ID_QUESTION,QUESTION,QUESTION_NUMBER")] Perguntas perguntas)
        {
            if (ModelState.IsValid)
            {
                db.BREW_QUESTION.Add(perguntas);
                db.SaveChanges();
                return RedirectToAction("../Respostas/Create");
            }

            return View(perguntas);
        }

        // GET: Perguntas/Edit/5
        public ActionResult Edit(decimal? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Perguntas perguntas = db.BREW_QUESTION.Find(id);
            if (perguntas == null)
            {
                return HttpNotFound();
            }
            return View(perguntas);
        }

        // POST: Perguntas/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "ID_QUESTION,QUESTION,QUESTION_NUMBER")] Perguntas perguntas)
        {
            if (ModelState.IsValid)
            {
                db.Entry(perguntas).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(perguntas);
        }

        // GET: Perguntas/Delete/5
        public ActionResult Delete(decimal? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Perguntas perguntas = db.BREW_QUESTION.Find(id);
            if (perguntas == null)
            {
                return HttpNotFound();
            }
            return View(perguntas);
        }

        // POST: Perguntas/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(decimal id)
        {
            Perguntas perguntas = db.BREW_QUESTION.Find(id);
            db.BREW_QUESTION.Remove(perguntas);
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
