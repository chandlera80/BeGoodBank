package models;

import net.bytebuddy.asm.Advice;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class WithdrawalType
{
    @Id
    private int withdrawalTypeId;
    private String misbehavior;
    private String misbehaviorDescription;
    private LocalDate misbehaviorDate;
    private BigDecimal amountWithdrawn;
    private int childId;

    public int getChildId()
    {
        return childId;
    }

    public void setChildId(int childId)
    {
        this.childId = childId;
    }

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

    public LocalDate getMisbehaviorDate()
    {
        return misbehaviorDate;
    }

    public void setMisbehaviorDate(LocalDate misbehaviorDate)
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


    public WithdrawalType(int withdrawalTypeId, String misbehavior, String misbehaviorDescription, LocalDate misbehaviorDate, BigDecimal amountWithdrawn)
    {
        this.withdrawalTypeId = withdrawalTypeId;
        this.misbehavior = misbehavior;
        this.misbehaviorDescription = misbehaviorDescription;
        this.misbehaviorDate = misbehaviorDate;
        this.amountWithdrawn = amountWithdrawn;

    }

    public WithdrawalType()
    {
    }
}
