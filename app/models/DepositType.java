package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class DepositType
{
    @Id
    private int depositTypeId;
    private String goodDeed;
    private String goodDeedDescription;
    private Date dateOfDeed;
    private BigDecimal amountDesposited;
    private boolean behavioralObjective;

    public int getDepositTypeId()
    {
        return depositTypeId;
    }

    public void setDepositTypeId(int depositTypeId)
    {
        this.depositTypeId = depositTypeId;
    }

    public String getGoodDeed()
    {
        return goodDeed;
    }

    public void setGoodDeed(String goodDeed)
    {
        this.goodDeed = goodDeed;
    }

    public String getGoodDeedDescription()
    {
        return goodDeedDescription;
    }

    public void setGoodDeedDescription(String goodDeedDescription)
    {
        this.goodDeedDescription = goodDeedDescription;
    }

    public Date getDateOfDeed()
    {
        return dateOfDeed;
    }

    public void setDateOfDeed(Date dateOfDeed)
    {
        this.dateOfDeed = dateOfDeed;
    }

    public BigDecimal getAmountDesposited()
    {
        return amountDesposited;
    }

    public void setAmountDesposited(BigDecimal amountDesposited)
    {
        this.amountDesposited = amountDesposited;
    }

    public boolean isBehavioralObjective()
    {
        return behavioralObjective;
    }

    public void setBehavioralObjective(boolean behavioralObjective)
    {
        this.behavioralObjective = behavioralObjective;
    }

    public DepositType(int depositTypeId, String goodDeed, String goodDeedDescription, Date dateOfDeed, BigDecimal amountDesposited, boolean behavioralObjective)
    {
        this.depositTypeId = depositTypeId;
        this.goodDeed = goodDeed;
        this.goodDeedDescription = goodDeedDescription;
        this.dateOfDeed = dateOfDeed;
        this.amountDesposited = amountDesposited;
        this.behavioralObjective = behavioralObjective;
    }
}
