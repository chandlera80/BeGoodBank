package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;


@Entity
    public class ChildDetail
    {
        @Id private int childId;
        private String firstName;
        private String lastName;
        private BigDecimal currentAccountBalance;
        private int guardianId;
        private String guardianFirstName;
        private String guardianLastName;
        private String relationshipToChild;

        public int getChildId()
        {
            return childId;
        }

        public void setChildId(int childId)
        {
            this.childId = childId;
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

        public BigDecimal getCurrentAccountBalance()
        {
            return currentAccountBalance;
        }

        public void setCurrentAccountBalance(BigDecimal currentAccountBalance)
        {
            this.currentAccountBalance = currentAccountBalance;
        }

        public int getGuardianId()
        {
            return guardianId;
        }

        public void setGuardianId(int guardianId)
        {
            this.guardianId = guardianId;
        }

        public String getGuardianFirstName()
        {
            return guardianFirstName;
        }

        public void setGuardianFirstName(String guardianFirstName)
        {
            this.guardianFirstName = guardianFirstName;
        }

        public String getGuardianLastName()
        {
            return guardianLastName;
        }

        public void setGuardianLastName(String guardianLastName)
        {
            this.guardianLastName = guardianLastName;
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
