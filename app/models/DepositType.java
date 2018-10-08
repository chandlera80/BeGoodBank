package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class DepositType
{
    @Id
    private int depositTypeId;
    private String goodDeed;
    private String goodDeedDescription;
    private LocalDate goodDeedDate;
    private BigDecimal amountDeposited;
    private int childId;

    public int getChildId()
    {
        return childId;
    }

    public void setChildId(int childId)
    {
        this.childId = childId;
    }

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

    public LocalDate getGoodDeedDate()
    {
        return goodDeedDate;
    }

    public void setGoodDeedDate(LocalDate dateOfDeed)
    {
        this.goodDeedDate = dateOfDeed;
    }

    public BigDecimal getAmountDeposited()
    {
        return amountDeposited;
    }

    public void setAmountDeposited(BigDecimal amountDeposited)
    {
        this.amountDeposited = amountDeposited;
    }

    }

