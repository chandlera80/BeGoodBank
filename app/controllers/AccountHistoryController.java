package controllers;

import models.*;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


public class AccountHistoryController extends Controller
{
    private JPAApi jpaApi;
    private FormFactory formFactory;

    @Inject
    public AccountHistoryController(JPAApi jpaApi, FormFactory formFactory)
    {
        this.jpaApi = jpaApi;
        this.formFactory = formFactory;
    }


    @Transactional
    public Result getAccountHistory(int childId)
    {
        String childSQL = "SELECT c FROM Child c where childId = :childId";

        Child child = jpaApi.em().createQuery(childSQL, Child.class).setParameter("childId", childId).getSingleResult();

        String goodDeedSQL = "SELECT d FROM DepositType d WHERE childId = :childId";
        List<DepositType> goodDeeds = jpaApi.em().createQuery(goodDeedSQL, DepositType.class).setParameter("childId", childId).getResultList();

        String misbehaviorSQL = "SELECT w FROM WithdrawalType w WHERE childId = :childId";
        List<WithdrawalType> misbehaviors = jpaApi.em().createQuery(misbehaviorSQL, WithdrawalType.class).setParameter("childId", childId).getResultList();


        return ok(views.html.accountHistory.render(child, goodDeeds, misbehaviors));


    }

    @Transactional
    public Result postAccountHistory(int childId)
    {
        String childSQL = "SELECT c FROM Child c where childId = :childId";

        Child child = jpaApi.em().createQuery(childSQL, Child.class).setParameter("childId", childId).getSingleResult();


        DynamicForm form = formFactory.form().bindFromRequest();
        String goodDeed = form.get("goodDeed");
        String misbehavior = form.get("misbehavior");

        if (!goodDeed.equalsIgnoreCase("N/A"))
        {
            DepositType newDepositType = new DepositType();
            String goodDeedDescription = form.get("gooddeeddescription");
            LocalDate goodDeedDate = LocalDate.parse(form.get("gooddeeddate"));
            newDepositType.setGoodDeed(goodDeed);
            newDepositType.setGoodDeedDate(goodDeedDate);
            newDepositType.setGoodDeedDescription(goodDeedDescription);
            newDepositType.setAmountDeposited(new BigDecimal("2.00"));
            newDepositType.setChildId(childId);
            jpaApi.em().persist(newDepositType);
            BigDecimal newbalance = child.getCurrentAccountBalance().add(new BigDecimal("2.00"));
            child.setCurrentAccountBalance(newbalance);
        }
        else
        {
            WithdrawalType newWithdrawalType = new WithdrawalType();
            String misbehaviorDescription = form.get("misbehaviordescription");
            LocalDate misbehaviorDate = LocalDate.parse(form.get("misbehaviordate"));
            newWithdrawalType.setMisbehavior(misbehavior);
            newWithdrawalType.setMisbehaviorDescription(misbehaviorDescription);
            newWithdrawalType.setMisbehaviorDate(misbehaviorDate);
            newWithdrawalType.setAmountWithdrawn(new BigDecimal("-2.00"));
            newWithdrawalType.setChildId(childId);
            jpaApi.em().persist(newWithdrawalType);
            BigDecimal newbalance = child.getCurrentAccountBalance().subtract(new BigDecimal("2.00"));
            child.setCurrentAccountBalance(newbalance);

        }


        return ok("saved");
    }


}