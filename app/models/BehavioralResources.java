package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BehavioralResources
{

    @Id private int behavioralResourcesId;
   private String undesiredBehavior;
   private String severity;

    public int getBehavioralResourcesId()
    {
        return behavioralResourcesId;
    }

    public void setBehavioralResourcesId(int behavioralResourcesId)
    {
        this.behavioralResourcesId = behavioralResourcesId;
    }

    public String getUndesiredBehavior()
    {
        return undesiredBehavior;
    }

    public void setUndesiredBehavior(String undesiredBehavior)
    {
        this.undesiredBehavior = undesiredBehavior;
    }

    public String getSeverity()
    {
        return severity;
    }

    public void setSeverity(String severity)
    {
        this.severity = severity;
    }

    public BehavioralResources(int behavioralResourcesId, String undesiredBehavior, String severity)
    {
        this.behavioralResourcesId = behavioralResourcesId;
        this.undesiredBehavior = undesiredBehavior;
        this.severity = severity;
    }
}
