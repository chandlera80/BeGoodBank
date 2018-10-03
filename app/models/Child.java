package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Child
{
    @Id
   private int childId;
    private String lastName;
    private String firstName;
    private BigDecimal currentAccountBalance;
    private int guardianId;

    public int getGuardianId()
    {
        return guardianId;
    }

    public void setGuardianId(int guardianId)
    {
        this.guardianId = guardianId;
    }


    public int getChildId()
    {
        return childId;
    }

    public void setChildId(int childId)
    {
        this.childId = childId;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public BigDecimal getCurrentAccountBalance()
    {
        return currentAccountBalance;
    }

    public void setCurrentAccountBalance(BigDecimal currentAccountBalance)
    {
        this.currentAccountBalance = currentAccountBalance;
    }


}
