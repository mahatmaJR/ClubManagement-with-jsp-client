package DAO.implementations;

import DAO.interfaces.MemberOrderRepository;
import DAO.interfaces.MemberRepository;
import DAO.interfaces.PointsRepository;
import models.Member;
import models.MemberOrder;
import models.MemberPoints;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@Stateless
public class PointsRepositoryImp implements PointsRepository {
    @EJB
    MemberRepository member;

    @EJB
    MemberOrderRepository memberOrderRepo;

    Date date;

    @PersistenceContext(name = "ClubManagement")
    EntityManager entity;

    @Override
    public Member findMember(int memberId){
        Member member = entity.find(Member.class, memberId);
        return member;
    }

    @Override
    public MemberPoints saveMemPoints(MemberPoints memberPoints){
        entity.persist(memberPoints);
        return memberPoints;
    }

    @Override
    public MemberPoints saveMemberPoints(int memberId, int points){
        MemberPoints memberPoints = new MemberPoints();

        memberPoints.setMember(findMember(memberId));
        memberPoints.setPoints(points);

        saveMemPoints(memberPoints);
        return memberPoints;
    }

    @Override
    public int calculatePoints(int memberOrderId, int memberId){
        int points = 0;

        MemberOrder memberOrder = new MemberOrder();
        MemberPoints MPoints = new MemberPoints();

        if (memberOrder.getId() == memberOrderId && MPoints.getMember().equals(findMember(memberId)) && memberOrder.getDate().equals(date)){
            points = (int) (memberOrder.getTotalCost() * 10);

            MPoints.setPoints(points);
        }

        return points;
    }

    @Override
    public int calculatePointsAfterRedeeming(int memberId, int redeemedPoints){
        int newPoints = 0;
        MemberPoints MPoints = new MemberPoints();

        if (MPoints.getMember().equals(findMember(memberId))){
            newPoints = MPoints.getPoints() - redeemedPoints;
        }

        MPoints.setPoints(newPoints);

        return newPoints;
    }
}
