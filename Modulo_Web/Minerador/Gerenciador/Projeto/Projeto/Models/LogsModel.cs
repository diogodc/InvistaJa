using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Web;

namespace Projeto.Models
{
    public class Logs
    {
        public string email { get; set; }
        public string senha { get; set; }
        public string data { get; set; }

        public Logs()
        {
            email = email;
            data = data;
            senha = senha;
        }

        public List<Logs> TodosOsLogs()
        {
            Logs log;
            var retorno = new List<Logs>();
            try
            {
                string strPathFile = @"C:\xampp\htdocs\invistaja\invistaja\logs.txt";
                StreamReader rd = new StreamReader(strPathFile);
                while (!rd.EndOfStream)
                {
                    log = new Logs();
                    log.email = rd.ReadLine();
                    log.senha = rd.ReadLine();
                    log.data = rd.ReadLine();
                    retorno.Add(log);
                }
                rd.Close();
            }
            catch (Exception e)
            {
                throw e;
            }
            return retorno;

        }
    }
}
  
