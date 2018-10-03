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



    public class AccountHistory extends Controller
    {
        private JPAApi jpaApi;
        private FormFactory formFactory;

        @Inject
        public AccountHistory(JPAApi jpaApi, FormFactory formFactory)
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

     /*   @Transactional
        public Result postAccountHistory(int childId)
        {


            DynamicForm form = formFactory.form().bindFromRequest();
            LocalDate dateOfDeed = LocalDate.parse(form.get("dateOfDeed"));
            LocalDate misbehaviorDate = LocalDate.parse(form.get("misbehaviorDate"));
            String goodDeedDescription = form.get("gooddeeddescription");
            BigDecimal amountDeposited = new BigDecimal(form.get("amountDeposited"));
            String misbehavior = form.get("misbehavior");
            String goodDeed = form.get("goodDeed");
            String misbehaviorDescription = form.get("misbehaviordescription");
            BigDecimal amountWithdrawn = new BigDecimal(form.get("amountWithdrawn"));
            BigDecimal CurrentAccountBalance = new BigDecimal(form.get("currentAccountBalance"));



            AccountHistory accountHistory = new AccountHistory();
            childchore.setDateAssigned(dateAssigned);
            childchore.getChildChoreId();
            childchore.getChildId();
            childchore.getChoreId();

            jpaApi.em().persist(childchore);

            return ok("Saved");
        }*/
    }