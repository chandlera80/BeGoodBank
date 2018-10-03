package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Guardian
{

   @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
   int guardianId;
   private String firstName;
   private String lastName;
   private String relationshipToChild;

    public int getGuardianId()
    {
        return guardianId;
    }

    public void setGuardianId(int guardianId)
    {
        this.guardianId = guardianId;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getRelationshipToChild()
    {
        return relationshipToChild;
    }

    public void setRelationshipToChild(String relationshipToChild)
    {
        this.relationshipToChild = relationshipToChild;
    }


}
