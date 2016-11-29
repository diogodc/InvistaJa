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
    public class RespostasController : Controller
    {
        private Model1 db = new Model1();

        // GET: Respostas
        public ActionResult Index()
        {
            var bREW_ANSWER = db.BREW_ANSWER.Include(r => r.Pergunta);
            return View(bREW_ANSWER.ToList());
        }

        // GET: Respostas/Details/5
        public ActionResult Details(decimal? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Respostas respostas = db.BREW_ANSWER.Find(id);
            if (respostas == null)
            {
                return HttpNotFound();
            }
            return View(respostas);
        }

        // GET: Respostas/Create
        public ActionResult Create()
        {
            ViewBag.ID_QUESTION = new SelectList(db.BREW_QUESTION, "ID_QUESTION", "QUESTION");
            return View();
        }

        // POST: Respostas/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "ID_ANSWER,ANSWER_TEXT,WEIGHT_ANSWER,ID_QUESTION")] Respostas respostas)
        {
            if (ModelState.IsValid)
            {
                db.BREW_ANSWER.Add(respostas);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.ID_QUESTION = new SelectList(db.BREW_QUESTION, "ID_QUESTION", "QUESTION", respostas.ID_QUESTION);
            return View(respostas);
        }

        // GET: Respostas/Edit/5
        public ActionResult Edit(decimal? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Respostas respostas = db.BREW_ANSWER.Find(id);
            if (respostas == null)
            {
                return HttpNotFound();
            }
            ViewBag.ID_QUESTION = new SelectList(db.BREW_QUESTION, "ID_QUESTION", "QUESTION", respostas.ID_QUESTION);
            return View(respostas);
        }

        // POST: Respostas/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "ID_ANSWER,ANSWER_TEXT,WEIGHT_ANSWER,ID_QUESTION")] Respostas respostas)
        {
            if (ModelState.IsValid)
            {
                db.Entry(respostas).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.ID_QUESTION = new SelectList(db.BREW_QUESTION, "ID_QUESTION", "QUESTION", respostas.ID_QUESTION);
            return View(respostas);
        }

        // GET: Respostas/Delete/5
        public ActionResult Delete(decimal? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Respostas respostas = db.BREW_ANSWER.Find(id);
            if (respostas == null)
            {
                return HttpNotFound();
            }
            return View(respostas);
        }

        // POST: Respostas/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(decimal id)
        {
            Respostas respostas = db.BREW_ANSWER.Find(id);
            db.BREW_ANSWER.Remove(respostas);
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
