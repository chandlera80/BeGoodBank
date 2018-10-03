package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class ChildChore
{
    @Id
    private int childChoreId;
    private LocalDate dateAssigned;

    public int getChildChoreId()
    {
        return childChoreId;
    }

    public void setChildChoreId(int childChoreId)
    {
        this.childChoreId = childChoreId;
    }

    public LocalDate getDateAssigned()
    {
        return dateAssigned;
    }

    public void setDateAssigned(LocalDate dateAssigned)
    {
        this.dateAssigned = dateAssigned;
    }

    public boolean isTaskCompletion()
    {
        return taskCompletion;
    }

    public void setTaskCompletion(boolean taskCompletion)
    {
        this.taskCompletion = taskCompletion;
    }

    public int getChildId()
    {
        return childId;
    }

    public void setChildId(int childId)
    {
        this.childId = childId;
    }

    public int getChoreId()
    {
        return choreId;
    }

    public void setChoreId(int choreId)
    {
        this.choreId = choreId;
    }

    private boolean taskCompletion ;
    private int  childId;
    private int choreId;
}
