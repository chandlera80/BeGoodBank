package controllers;


import models.Child;
import models.RewardOptions;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.helper.form;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;


    public class RewardsController extends Controller
    {
        private JPAApi jpaApi;

        @Inject
        public RewardsController(JPAApi jpaApi)

        {
            this.jpaApi = jpaApi;
        }

        @Transactional(readOnly = true)
        public Result getRewardOptions()
        {
            String sql = "SELECT r FROM RewardOptions r ORDER BY rewardType";

            List<RewardOptions> rewardTypes = jpaApi.em().createQuery(sql, RewardOptions.class).getResultList();


            return ok(views.html.rewardOptions.render(rewardTypes));
        }
}
