package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class RedeemedRewards
{
    @Id
    private int redeemedRewardsId;
    private String redeemededRewardsType;
    private BigDecimal redeemedRewardsCost;

    public int getRedeemedRewardsId()
    {
        return redeemedRewardsId;
    }

    public void setRedeemedRewardsId(int redeemedRewardsId)
    {
        this.redeemedRewardsId = redeemedRewardsId;
    }

    public String getRedeemededRewardsType()
    {
        return redeemededRewardsType;
    }

    public void setRedeemededRewardsType(String redeemededRewardsType)
    {
        this.redeemededRewardsType = redeemededRewardsType;
    }

    public BigDecimal getRedeemedRewardsCost()
    {
        return redeemedRewardsCost;
    }

    public void setRedeemedRewardsCost(BigDecimal redeemedRewardsCost)
    {
        this.redeemedRewardsCost = redeemedRewardsCost;
    }

    public RedeemedRewards(int redeemedRewardsId, String redeemededRewardsType, BigDecimal redeemedRewardsCost)
    {
        this.redeemedRewardsId = redeemedRewardsId;
        this.redeemededRewardsType = redeemededRewardsType;
        this.redeemedRewardsCost = redeemedRewardsCost;
    }
}
