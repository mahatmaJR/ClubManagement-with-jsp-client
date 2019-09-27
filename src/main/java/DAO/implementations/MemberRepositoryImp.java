package DAO.implementations;

import DAO.interfaces.MemberRepository;
import models.Member;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class MemberRepositoryImp implements MemberRepository {

    @PersistenceContext(unitName = "ClubManagement")
    EntityManager entity;

    @Override
    public Member newMember(Member member) {
        Member registeredMember = this.newMember(member.getFirstName(), member.getLastName(), member.getEmail(), member.getMobileNo());
        return registeredMember;
    }

    @Override
    public Member newMember(String firstName, String lastName, String email, int mobileNo) {
        Member member = new Member();
        member.setFirstName(firstName);
        member.setLastName(lastName);
        member.setEmail(email);
        member.setMobileNo(mobileNo);

        entity.persist(member);

        return member;
    }

    @Override
    public List<Member> getAllMembers() {
        String sql = "SELECT m FROM member m";
        List<Member> members  = entity.createNamedQuery(sql).getResultList();
        return members;
    }

    @Override
    public Member getMemberById(int id) {
        Member memberById = (Member) entity.find(Member.class, id);
        return memberById;
    }

    @Override
    public Member getMemberByLastName(String lastName) {
        String sql = "SELECT m FROM m member WHERE lastName = :lastName";
        Query query = entity.createNamedQuery(sql);
        query.setParameter("lastName", lastName);

        List<Member> members = query.getResultList();
        Member memberByLastName = null;
        if (members.size() != 0){
            memberByLastName = members.get(0);
        }

        return memberByLastName;
    }

    @Override
    public Member getMemberByFirstName(String firstName) {
        String sql = "SELECT m FROM m member WHERE firstName = :firstName";
        Query query = entity.createNamedQuery(sql);
        query.setParameter("firstName", firstName);

        List<Member> members = query.getResultList();
        Member memberByFirstName = null;
        if (members.size() != 0){
            memberByFirstName = members.get(0);
        }
        return memberByFirstName;
    }
}
