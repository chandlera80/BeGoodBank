package controllers;

import akka.actor.ProviderSelection;
import models.*;
import play.Logger;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.child;
import views.html.chores;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static play.mvc.Results.ok;


public class ChildController extends Controller
{
    private JPAApi jpaApi;
    private FormFactory formFactory;

    @Inject
    public ChildController(JPAApi jpaApi, FormFactory formFactory)
    {
        this.jpaApi = jpaApi;
        this.formFactory = formFactory;
    }


    public Result getNewChild()
    {
        return ok(views.html.newchild.render());
    }

    @Transactional
    public Result postNewChild()
    {
        DynamicForm form = formFactory.form().bindFromRequest();
        String firstName = form.get("FirstName");
        String lastName = form.get("LastName");
        String guardianfirstName = form.get("GuardianFirstName");
        String guardianlastName = form.get("GuardianLastName");
        String relationshiptochild = form.get("RelationshipToChild");

        Guardian newGuardian = new Guardian();
        newGuardian.setFirstName(guardianfirstName);
        newGuardian.setLastName(guardianlastName);
        newGuardian.setRelationshipToChild(relationshiptochild);
        jpaApi.em().persist(newGuardian);
        Child newChild = new Child();
        newChild.setFirstName(firstName);
        newChild.setLastName(lastName);
        newChild.setGuardianId(newGuardian.getGuardianId());
        newChild.setCurrentAccountBalance(BigDecimal.ZERO);


        jpaApi.em().persist(newChild);

        return ok(firstName);
    }

    @Transactional(readOnly = true)
    public Result getChildDetails()
    {
        String sql = "SELECT NEW models.ChildDetail(c.childId, c.firstName,c.lastName,c.currentAccountBalance,g.guardianId, g.firstName, g.lastName,g.relationshipToChild) " +
                "FROM Child c " +
                "JOIN Guardian g on c.guardianId = g.guardianId ";


        List<ChildDetail> childDetail = jpaApi.em().createQuery(sql, ChildDetail.class).getResultList();

        return ok(views.html.childDetails.render(childDetail));
    }

    @Transactional
    public Result getEditChild(int childId)
    {

        String childSQL = "SELECT c FROM Child c WHERE childId = :childId";
        Child child = jpaApi.em().createQuery(childSQL, Child.class)
                .setParameter("childId", childId)
                .getSingleResult();

        String guardianSQL = "SELECT g FROM Guardian g ORDER BY lastName, firstName";
        List<Guardian> guardians = jpaApi.em().createQuery(guardianSQL, Guardian.class).getResultList();


        return ok(views.html.editChild.render(child, guardians));
    }

    @Transactional
    public Result postEditChild(int childId)
    {

        String childSQL = "SELECT c FROM Child c WHERE childId = :childId";
        Child child = jpaApi.em().createQuery(childSQL, Child.class)
                .setParameter("childId", childId)
                .getSingleResult();

        DynamicForm form = formFactory.form().bindFromRequest();
        String firstname = form.get("firstname");
        String lastname = form.get("lastname");
        BigDecimal currentAccountBalance = new BigDecimal(form.get("currentaccountbalance"));
        Integer guardianId = Integer.parseInt(form.get("guardianId"));




        child.setFirstName(firstname);
        child.setLastName(lastname);
        child.setCurrentAccountBalance(currentAccountBalance);
        child.setGuardianId(guardianId);




        return ok("Saved");
    }

    @Transactional
    public Result getChildChore()
    {

        String childrenSQL = "SELECT c FROM Child c  ORDER BY  firstName, lastName ";
        List<Child> children = jpaApi.em().createQuery(childrenSQL, Child.class).getResultList();

        String choreNameSQL = "SELECT c FROM Chores c";
        List<Chores> choreNames = jpaApi.em().createQuery(choreNameSQL, Chores.class).getResultList();


        return ok(views.html.childChore.render(choreNames, children));


    }

    @Transactional
    public Result postChildChore()
    {

        String childrenSQL = "SELECT c FROM Child c  ORDER BY  firstName, lastName ";
        List<Child> children = jpaApi.em().createQuery(childrenSQL, Child.class).getResultList();

        String choreNameSQL = "SELECT c FROM Chores c";
        List<Chores> choreNames = jpaApi.em().createQuery(choreNameSQL, Chores.class).getResultList();

        DynamicForm form = formFactory.form().bindFromRequest();
        LocalDate dateAssigned = LocalDate.parse(form.get("dateassigned"));
        int choreId = Integer.parseInt(form.get("choreId"));
        String taskCompletion = form.get("taskCompletion");
        int childId = Integer.parseInt(form.get("childId"));


        ChildChore childchore = new ChildChore();
        childchore.setDateAssigned(dateAssigned);
        childchore.setChildId(childId);
        childchore.setChoreId(choreId);
        if (taskCompletion.equalsIgnoreCase("yes"))
        {
            childchore.setTaskCompletion(true);
        }
        else
        {
            childchore.setTaskCompletion(false);
        }


        jpaApi.em().

    persist(childchore);

        return

    ok("Saved");

}


    @Transactional
    public Result getDeleteChild(int childId)
    {
        String deleteSQL = "SELECT c FROM Child c where childId = :childId";

        Child deleteChild = jpaApi.em().createQuery(deleteSQL, Child.class).setParameter("childId", childId).getSingleResult();

        jpaApi.em().remove(deleteChild);

        return redirect("/listchildren");
    }

    @Transactional(readOnly = true)
    public Result getChildBehavior(int childId)
    {
        String depositSQL = "SELECT d FROM DepositType d WHERE childId = :childId";
        List<DepositType> depositTypes = jpaApi.em().createQuery(depositSQL, DepositType.class).setParameter("childId", childId).getResultList();

        String withdrawalSQL = "SELECT w FROM WithdrawalType w WHERE childId = :childId";
        List<WithdrawalType> withdrawalTypes = jpaApi.em().createQuery(withdrawalSQL, WithdrawalType.class).setParameter("childId", childId).getResultList();


        return ok(views.html.childBehavior.render(depositTypes,withdrawalTypes));
    }
}





