package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.security.PrivateKey;
import java.util.PrimitiveIterator;

@Entity
public class Chores
{
    @Id
    private int choreId;
    private String choreName;
    private Boolean taskCompletion;

    public int getChoreId()
    {
        return choreId;
    }

    public void setChoreId(int choreId)
    {
        this.choreId = choreId;
    }

    public String getChoreName()
    {
        return choreName;
    }

    public void setChoreName(String choreName)
    {
        this.choreName = choreName;
    }

    public Boolean getTaskCompletion()
    {
        return taskCompletion;
    }

    public void setTaskCompletion(Boolean taskCompletion)
    {
        this.taskCompletion = taskCompletion;
    }

    public Chores(int choreId, String choreName, Boolean taskCompletion)
    {
        this.choreId = choreId;
        this.choreName = choreName;
        this.taskCompletion = taskCompletion;
    }
}
