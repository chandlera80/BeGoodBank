package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class ChildBehavior
{
    @Id
    private String goodDeed;
    private String goodDeedDescription;
    private LocalDate dateOfDeed;
    private int childId;
    private String misbehavior;
    private String misbehaviorDescription;
    private LocalDate misbehaviorDate;

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

    public LocalDate getDateOfDeed()
    {
        return dateOfDeed;
    }

    public void setDateOfDeed(LocalDate dateOfDeed)
    {
        this.dateOfDeed = dateOfDeed;
    }

    public int getChildId()
    {
        return childId;
    }

    public void setChildId(int childId)
    {
        this.childId = childId;
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
}
