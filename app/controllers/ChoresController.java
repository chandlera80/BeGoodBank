package controllers;

import models.Chores;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

public class ChoresController extends Controller
{
        private JPAApi jpaApi;

        @Inject
        public ChoresController(JPAApi jpaApi)

        {
            this.jpaApi = jpaApi;
        }

        @Transactional(readOnly = true)
        public Result getChores()
        {
            String sql = "SELECT c FROM Chore c ORDER BY choreName";

            List<Chores> chores = jpaApi.em().createQuery(sql, Chores.class).getResultList();

            return ok(views.html.chores.render(chores));
        }
}
