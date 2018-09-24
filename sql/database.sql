
CREATE TABLE Chores (
                ChoreId INT NOT NULL,
                ChoreName VARCHAR(50) NOT NULL,
                DayAssigned VARCHAR(50) NOT NULL,
                TaskCompletion BOOLEAN NOT NULL,
                PRIMARY KEY (ChoreId)
);


CREATE TABLE BehavioralFocus (
                BehavioralFocusId INT NOT NULL,
                BehaviorObjectives VARCHAR(50),
                UndesiredBehavior VARCHAR(50),
                PRIMARY KEY (BehavioralFocusId)
);


CREATE TABLE BehavioralResources (
                BehavioralResourcesId INT NOT NULL,
                UndesiredBehavior VARCHAR(100) NOT NULL,
                Severity VARCHAR(50) NOT NULL,
                BehavioralFocusId INT NOT NULL,
                PRIMARY KEY (BehavioralResourcesId)
);


CREATE TABLE RewardOptions (
                RewardOptionId INT NOT NULL,
                RewardType VARCHAR(50) NOT NULL,
                RewardCost DECIMAL(8) NOT NULL,
                RewardDescription VARCHAR(300) NOT NULL,
                RewardPicture LONGTEXT,
                PRIMARY KEY (RewardOptionId)
);


CREATE TABLE Guardian (
                GuardianId INT NOT NULL,
                FirstName VARCHAR(50) NOT NULL,
                LastName VARCHAR(50) NOT NULL,
                RelationshipToChild VARCHAR(50) NOT NULL,
                PRIMARY KEY (GuardianId)
);


CREATE TABLE WithdrawalType (
                WithdrawalTypeId INT AUTO_INCREMENT NOT NULL,
                Misbehavior VARCHAR(50) NOT NULL,
                MisbehaviorDescription VARCHAR(50) NOT NULL,
                MisbehaviorDate DATE NOT NULL,
                AmountWithdrawn DECIMAL(8) NOT NULL,
                UndesiredBehavior BOOLEAN NOT NULL,
                BehavioralFocusId INT NOT NULL,
                PRIMARY KEY (WithdrawalTypeId)
);


CREATE TABLE Child (
                ChildId INT AUTO_INCREMENT NOT NULL,
                LastName VARCHAR(30) NOT NULL,
                FirstName VARCHAR(30) NOT NULL,
                CurrentAccountBalance DECIMAL(8) NOT NULL,
                GuardianId INT NOT NULL,
                PRIMARY KEY (ChildId)
);


CREATE TABLE RedeemedRewards (
                RedeemedRewardsId INT NOT NULL,
                RedeemedRewardType VARCHAR(50) NOT NULL,
                RedeemedRewardsCost DECIMAL(8) NOT NULL,
                RewardOptionId INT NOT NULL,
                ChildId INT NOT NULL,
                PRIMARY KEY (RedeemedRewardsId)
);


CREATE TABLE DepositType (
                DepositTypeId INT AUTO_INCREMENT NOT NULL,
                GoodDeed VARCHAR(50) NOT NULL,
                GoodDeedDescription VARCHAR(50) NOT NULL,
                goodDeedDate DATE NOT NULL,
                AmountDeposited DECIMAL(8) NOT NULL,
                BehavioralObjective BOOLEAN NOT NULL,
                ChildId INT NOT NULL,
                BehavioralFocusId INT NOT NULL,
                ChoreId INT NOT NULL,
                PRIMARY KEY (DepositTypeId)
);


ALTER TABLE DepositType ADD CONSTRAINT chores_deposittype_fk
FOREIGN KEY (ChoreId)
REFERENCES Chores (ChoreId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE WithdrawalType ADD CONSTRAINT behavioralfocus_withdrawaltype_fk
FOREIGN KEY (BehavioralFocusId)
REFERENCES BehavioralFocus (BehavioralFocusId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE DepositType ADD CONSTRAINT behavioralfocus_deposittype_fk
FOREIGN KEY (BehavioralFocusId)
REFERENCES BehavioralFocus (BehavioralFocusId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE BehavioralResources ADD CONSTRAINT behavioralfocus_behavioralresources_fk
FOREIGN KEY (BehavioralFocusId)
REFERENCES BehavioralFocus (BehavioralFocusId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE RedeemedRewards ADD CONSTRAINT rewardoptions_redeemedrewards_fk
FOREIGN KEY (RewardOptionId)
REFERENCES RewardOptions (RewardOptionId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Child ADD CONSTRAINT guardian/instructor_customer_fk
FOREIGN KEY (GuardianId)
REFERENCES Guardian (GuardianId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE DepositType ADD CONSTRAINT customer_deposittype_fk
FOREIGN KEY (ChildId)
REFERENCES Child (ChildId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE RedeemedRewards ADD CONSTRAINT child_redeemedrewards_fk
FOREIGN KEY (ChildId)
REFERENCES Child (ChildId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
