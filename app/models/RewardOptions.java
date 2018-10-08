package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class RewardOptions
{
    @Id
    private int rewardOptionId;
    private String rewardType;
    private BigDecimal rewardCost;
    private String rewardDescription;
    private String rewardPicture;

    public int getRewardOptionId()
    {
        return rewardOptionId;
    }

    public void setRewardOptionId(int rewardOptionId)
    {
        this.rewardOptionId = rewardOptionId;
    }

    public String getRewardType()
    {
        return rewardType;
    }

    public void setRewardType(String rewardType)
    {
        this.rewardType = rewardType;
    }

    public BigDecimal getRewardCost()
    {
        return rewardCost;
    }

    public void setRewardCost(BigDecimal rewardCost)
    {
        this.rewardCost = rewardCost;
    }

    public String getRewardDescription()
    {
        return rewardDescription;
    }

    public void setRewardDescription(String rewardDescription)
    {
        this.rewardDescription = rewardDescription;
    }

    public String getRewardPicture()
    {
        return rewardPicture;
    }

    public void setRewardPicture(String rewardPicture)
    {
        this.rewardPicture = rewardPicture;
    }

    public RewardOptions(int rewardOptionId, String rewardType, BigDecimal rewardCost, String rewardDescription, String rewardPicture)
    {
        this.rewardOptionId = rewardOptionId;
        this.rewardType = rewardType;
        this.rewardCost = rewardCost;
        this.rewardDescription = rewardDescription;
        this.rewardPicture = rewardPicture;
    }

    public RewardOptions()
    {
    }
}
