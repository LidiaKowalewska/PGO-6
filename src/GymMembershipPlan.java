class GymMembershipPlan extends MembershipPlan implements Freezable {

    private int entriesPerMonth;
    private boolean saunaAccess;

    public GymMembershipPlan(boolean autoRenew ,int planCode, String clientName,int months, Double baseMonthlyFee,int entriesPerMonth, boolean saunaAccess) {
        super(planCode, clientName, months, baseMonthlyFee, autoRenew);
        this.entriesPerMonth = entriesPerMonth;
        this.saunaAccess = saunaAccess;
    }

    public int getEntriesPerMonth() {
        return entriesPerMonth;
    }
    public boolean getSaunaAccess() {
        return saunaAccess;
    }

    public interface Freezable {
        boolean canFreeze();
    }

    @Override
    public String getPlanType() {
        return "GYM MEMBERSHIP";
    }
    @Override
    public double calculateMonthlyNetPrice(){
        double oplata = 0.0;
        oplata = baseMonthlyFee + (entriesPerMonth * 4);

        if(saunaAccess==true){
            oplata += 25.00;
        }else if (autoRenew==true){
            oplata -= 10.00;
        }
        return oplata;
    }

    @Override
    public boolean canFreeze() {
        return getMonths() >= 3;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", GymMembershipPlan{" +
                "entriesPerMonth=" + entriesPerMonth +
                ", saunaAccess=" + saunaAccess +
                '}';
    }

}