package DAO.interfaces;

import models.Member;
import models.MemberPoints;

public interface PointsRepository {
    Member findMember(int memberId);
    MemberPoints saveMemPoints(MemberPoints memberPoints);
    MemberPoints saveMemberPoints(int memberId, int points);
    int calculatePoints(int memberOrderId, int memberId);
    int calculatePointsAfterRedeeming(int memberId, int redeemedPoints);
}
