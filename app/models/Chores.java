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




}
