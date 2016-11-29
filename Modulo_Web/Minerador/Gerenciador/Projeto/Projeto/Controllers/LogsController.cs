using System.Collections.Generic;
using System.Linq;
using System.Web.Mvc;
using Projeto.Models;

namespace Projeto.Controllers
{
    [Authorize]
    public class LogsController : Controller
    {
        private readonly IEnumerable<Logs> TodosOsLogs;
        // GET: Logs
        public LogsController()
        {
            TodosOsLogs = new Logs().TodosOsLogs().OrderByDescending(x => x.data);
        }

        public ActionResult Index()
        {
            var ultimosLogs = TodosOsLogs;
            return View(ultimosLogs);
        }
    }
}