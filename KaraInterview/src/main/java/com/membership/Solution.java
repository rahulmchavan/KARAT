package com.membership;
public class Solution {

    public static void main(String[] args) {

        testMember();
        testMembership();

        System.out.println("All tests passed successfully!");
    }

    public static void testMember() {

        System.out.println("Running testMember");

        Member testMember =
                new Member(1,
                        "John Doe",
                        MembershipStatus.BRONZE);

        assert testMember.memberId == 1;

        assert testMember.name.equals("John Doe");

        assert testMember.membershipStatus ==
                MembershipStatus.BRONZE;
    }

    public static void testMembership() {

        System.out.println("Running testMembership");

        Membership testMembership = new Membership();

        Member testMember =
                new Member(1,
                        "John Doe",
                        MembershipStatus.BRONZE);

        testMembership.addMember(testMember);

        assert testMembership.members.size() == 1;

        testMembership.updateMembership(
                1,
                MembershipStatus.SILVER
        );

        assert testMembership.members.get(0)
                .membershipStatus ==
                MembershipStatus.SILVER;

        testMembership.addMember(
                new Member(2, "Alex C",
                        MembershipStatus.BRONZE));

        testMembership.addMember(
                new Member(3, "Marie C",
                        MembershipStatus.GOLD));

        testMembership.addMember(
                new Member(4, "Joe D",
                        MembershipStatus.SILVER));

        testMembership.addMember(
                new Member(5, "June R",
                        MembershipStatus.BRONZE));

        testMembership.addMember(
                new Member(6, "Westley D",
                        MembershipStatus.SILVER));

        MembershipStatistics stats =
                testMembership.getMembershipStatistics();

        assert stats.totalMembers == 6;

        assert stats.totalPaidMembers == 4;

        assert Math.abs(stats.conversionRate - 66.67) < 0.1;
    }
}