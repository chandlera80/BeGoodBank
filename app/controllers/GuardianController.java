package controllers;

import models.*;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.guardians;

import javax.inject.Inject;
import javax.persistence.Temporal;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class GuardianController extends Controller
{
    private JPAApi jpaApi;
    private FormFactory formFactory;

    @Inject
    public GuardianController(FormFactory formFactory, JPAApi jpaApi)
    {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
    }

    @Transactional(readOnly = true)
    public Result getGuardians()
    {
        DynamicForm form = formFactory.form().bindFromRequest();

        String searchName = form.get("searchname");
        if (searchName == null)
        {
            searchName = " ";
        }

        searchName += "%";

        String sql = "SELECT g FROM Guardian g WHERE LastName LIKE :searchName ORDER BY LastName,FirstName,RelationshipToChild";

        List<Guardian> guardians = jpaApi.em().createQuery(sql, Guardian.class).setParameter("searchName", searchName).getResultList();

        return ok();


    }

    @Transactional(readOnly = true)
    public Result getGuardian(int guardianId)
    {
        String sql = " SELECT g FROM Guardian g WHERE guardianId = :guardianId";

        Guardian guardian = jpaApi.em().createQuery(sql, Guardian.class).setParameter("guardianId", guardianId).getSingleResult();

        return ok();

    }
}