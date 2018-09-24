INSERT INTO Guardian ( guardianId,FirstName,LastName, RelationshipToChild) Values (3,'Jarvis', 'Chandler', 'instructor')
 INTO CHILD ( childId,LastName,FirstName,CurrentAccountBalance,guardianId) Values (6,'Zandy', 'Davis',12.00,4)
 INSERT INTO Rewardoptions (RewardoptionId, rewardType, rewardCost, RewardDescription) Values (4,'movie night', 15.00,'Your choice of family night movie!')
 INSERT INTO redeemedrewards(redeemedRewardsId, redeemedrewardType, redeemedrewardsCost, RewardoptionId,childId) Values (1,'movie night', 15.00, 4, 1)