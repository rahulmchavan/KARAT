package com.membership;
public class MembershipStatistics {

    public int totalMembers;
    public int totalPaidMembers;
    public double conversionRate;

    public MembershipStatistics(int totalMembers,
                                int totalPaidMembers,
                                double conversionRate) {

        this.totalMembers = totalMembers;
        this.totalPaidMembers = totalPaidMembers;
        this.conversionRate = conversionRate;
    }
}