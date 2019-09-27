package services.resource;

import DAO.interfaces.MemberRepository;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import models.Member;

import javax.ejb.EJB;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/member")
public class MemberService {

    @EJB
    MemberRepository memberRepository;

    @Path("/addMember")
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMember(String json) {
        Member member = createMember(json);

        memberRepository.newMember(member);

        return Response.ok().entity(member).build();
    }

    public Member createMember(String json){
        Member member = new Member();
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();

        String firstName = jsonObject.get("firstName").getAsString();
        String lastName = jsonObject.get("lastName").getAsString();
        String email = jsonObject.get("email").getAsString();
        int mobileNo = jsonObject.get("mobileNo").getAsInt();

        member.setFirstName(firstName);
        member.setLastName(lastName);
        member.setEmail(email);
        member.setMobileNo(mobileNo);

        return member;
    }

    @Path("/view/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewMemberById(@PathParam("id") int id){
        Member member = (Member) memberRepository.getMemberById(id);
        return Response.ok().entity(member).build();
    }

    @Path("/allMembers")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMembers(){
        List<Member> memberList = memberRepository.getAllMembers();
        GenericEntity<List<Member>> memberWrapper = new GenericEntity<List<Member>>(memberList){};

        return Response.ok(memberWrapper).build();
    }

    @Path("/verify")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response verifyTest(){
        String result =  "take your RESTful skills and rise to the skies";

        return Response.status(200).entity(result).build();
    }
}
