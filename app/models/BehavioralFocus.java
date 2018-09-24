package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BehavioralFocus
{
    @Id
    private int behavioralFocusId;
    private String behavioralObjectives;
    private String undesiredBehavior;

    public int getBehavioralFocusId()
    {
        return behavioralFocusId;
    }

    public void setBehavioralFocusId(int behavioralFocusId)
    {
        this.behavioralFocusId = behavioralFocusId;
    }

    public String getBehavioralObjectives()
    {
        return behavioralObjectives;
    }

    public void setBehavioralObjectives(String behavioralObjectives)
    {
        behavioralObjectives = behavioralObjectives;
    }

    public String getUndesiredBehavior()
    {
        return undesiredBehavior;
    }

    public void setUndesiredBehavior(String undesiredBehavior)
    { undesiredBehavior = undesiredBehavior;
    }

    public BehavioralFocus(int behavioralFocusId, String behavioralObjectives, String undesiredBehavior)
    {
        this.behavioralFocusId = behavioralFocusId;
        behavioralObjectives = behavioralObjectives;
        undesiredBehavior = undesiredBehavior;
    }
}
