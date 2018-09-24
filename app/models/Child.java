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

    public Child(int childId, String lastName, String firstName, BigDecimal currentAccountBalance)
    {
        this.childId = childId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.currentAccountBalance = currentAccountBalance;
    }
}
