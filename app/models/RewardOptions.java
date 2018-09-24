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
    private byte rewardPicture;

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

    public byte getRewardPicture()
    {
        return rewardPicture;
    }

    public void setRewardPicture(byte rewardPicture)
    {
        this.rewardPicture = rewardPicture;
    }

    public RewardOptions(int rewardOptionId, String rewardType, BigDecimal rewardCost, String rewardDescription, byte rewardPicture)
    {
        this.rewardOptionId = rewardOptionId;
        this.rewardType = rewardType;
        this.rewardCost = rewardCost;
        this.rewardDescription = rewardDescription;
        this.rewardPicture = rewardPicture;
    }
}
