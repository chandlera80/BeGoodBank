package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class WithdrawalType
{
    @Id
    private int withdrawalTypeId;
    private String misbehavior;
    private String misbehaviorDescription;
    private Date misbehaviorDate;
    private BigDecimal amountWithdrawn;
    private boolean undesiredBehavior;

    public int getWithdrawalTypeId()
    {
        return withdrawalTypeId;
    }

    public void setWithdrawalTypeId(int withdrawalTypeId)
    {
        this.withdrawalTypeId = withdrawalTypeId;
    }

    public String getMisbehavior()
    {
        return misbehavior;
    }

    public void setMisbehavior(String misbehavior)
    {
        this.misbehavior = misbehavior;
    }

    public String getMisbehaviorDescription()
    {
        return misbehaviorDescription;
    }

    public void setMisbehaviorDescription(String misbehaviorDescription)
    {
        this.misbehaviorDescription = misbehaviorDescription;
    }

    public Date getMisbehaviorDate()
    {
        return misbehaviorDate;
    }

    public void setMisbehaviorDate(Date misbehaviorDate)
    {
        this.misbehaviorDate = misbehaviorDate;
    }

    public BigDecimal getAmountWithdrawn()
    {
        return amountWithdrawn;
    }

    public void setAmountWithdrawn(BigDecimal amountWithdrawn)
    {
        this.amountWithdrawn = amountWithdrawn;
    }

    public boolean isUndesiredBehavior()
    {
        return undesiredBehavior;
    }

    public void setUndesiredBehavior(boolean undesiredBehavior)
    {
        this.undesiredBehavior = undesiredBehavior;
    }

    public WithdrawalType(int withdrawalTypeId, String misbehavior, String misbehaviorDescription, Date misbehaviorDate, BigDecimal amountWithdrawn, boolean undesiredBehavior)
    {
        this.withdrawalTypeId = withdrawalTypeId;
        this.misbehavior = misbehavior;
        this.misbehaviorDescription = misbehaviorDescription;
        this.misbehaviorDate = misbehaviorDate;
        this.amountWithdrawn = amountWithdrawn;
        this.undesiredBehavior = undesiredBehavior;
    }
}
