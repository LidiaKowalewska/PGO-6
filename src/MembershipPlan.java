abstract class MembershipPlan implements Billable {
    private String planCode;
    private String clientName;
    private int months;
    public Double baseMonthlyFee;
    public boolean autoRenew;
    private static final double VAT_RATE = 0.23;

    public MembershipPlan(String planCode, String clientName, int months, Double baseMonthlyFee, boolean autoRenew) {
        this.planCode = planCode;
        this.clientName = clientName;
        this.baseMonthlyFee = baseMonthlyFee;
        this.autoRenew = this.autoRenew;
        this.months = months;
    }
    public String getPlanCode() {
        return planCode;
    }
    public String getClientName() {
        return clientName;
    }
    public int getMonths() {
        return months;
    }

    public Double getBaseMonthlyFee() {
        return baseMonthlyFee;
    }
    public boolean isAutoRenew() {
        return autoRenew;
    }

    public abstract String getPlanType();

   @Override
    public abstract double calculateMonthlyNetPrice();

     @Override
   public double calculateMonthlyGrossPrice(){
        return calculateTotalNetPrice() * 1.23;
    }

    public double calculateTotalNetPrice(){
        return baseMonthlyFee * months;
    }

    public final void printSummary(){
        double totalNet = calculateTotalNetPrice();
        double monthlyGross = calculateMonthlyGrossPrice();

        System.out.println("======= PODSUMOWANIE PLANU =======");
        System.out.println("Klient:         " + clientName);
        System.out.println("Typ planu:      " + getPlanType());
        System.out.println("Czas trwania:   " + months + " mies.");
        System.out.println("Plan odnawiajacy sie automatycznie " + autoRenew);
        System.out.println("----------------------------------");
        System.out.printf("Cena netto/mies:  %.2f zł\n", calculateMonthlyNetPrice());
        System.out.printf("Cena brutto/mies: %.2f zł\n", calculateMonthlyGrossPrice());
        System.out.printf("ŁĄCZNA CENA NETTO: %.2f zł\n", calculateTotalNetPrice());
        System.out.println("==================================");
    }

    @Override
    public String toString() {
        return String.format("planCode: %s | clientName: %s | months: %d | baseMonthlyFee: %.2f | autoRenew: %b ", planCode, clientName, months, baseMonthlyFee, autoRenew);
    }

    public interface Billable {
        double calculateMonthlyNetPrice();
        double calculateMonthlyGrossPrice();
    }

}
