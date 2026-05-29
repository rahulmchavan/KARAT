package com.membership;
import java.util.ArrayList;
import java.util.List;

public class Membership {

    public List<Member> members;

    public Membership() {
        members = new ArrayList<>();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void updateMembership(int memberId,
                                 MembershipStatus membershipStatus) {

        for (Member member : members) {

            if (member.memberId == memberId) {
                member.membershipStatus = membershipStatus;
                break;
            }
        }
    }

    public MembershipStatistics getMembershipStatistics() {

        int totalMembers = members.size();
        int totalPaidMembers = 0;

        for (Member member : members) {

            if (member.membershipStatus == MembershipStatus.GOLD ||
                    member.membershipStatus == MembershipStatus.SILVER) {

                totalPaidMembers++;
            }
        }

        double conversionRate = 0.0;

        if (totalMembers > 0) {
            conversionRate =
                    ((double) totalPaidMembers / totalMembers) * 100;
        }

        return new MembershipStatistics(
                totalMembers,
                totalPaidMembers,
                conversionRate
        );
    }
}