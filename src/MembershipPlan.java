abstract class MembershipPlan implements Billable {
    private int planCode;
    private String clientName;
    private int months;
    private Double baseMonthlyFee;
    private boolean autoRenew;
    private static final double VAT_RATE = 0.23;

    public MembershipPlan(int planCode, String clientName,int months, Double baseMonthlyFee) {
        this.planCode = planCode;
        this.clientName = clientName;
        this.baseMonthlyFee = baseMonthlyFee;
        this.autoRenew = autoRenew;
        this.months = months;
    }
    public int getPlanCode() {
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
        return baseMonthlyFee * (1 + VAT_RATE);
    }

    public double calculateTotalNetPrice(){
        return baseMonthlyFee * months;
    }

    public final void printSummary(){
        double totalNet = calculateTotalNetPrice();
        double monthlyGross = calculateMonthlyGrossPrice();

        System.out.println("======= PODSUMOWANIE PLANU =======");
        System.out.println("Klient:         " + clientName);
        System.out.println("Typ planu:      " + planCode);
        System.out.println("Czas trwania:   " + months + " mies.");
        System.out.println("Plan odnawiajacy sie automatycznie" + autoRenew);
        System.out.println("----------------------------------");
        System.out.printf("Cena netto/mies:  %.2f zł\n", calculateMonthlyNetPrice());
        System.out.printf("Cena brutto/mies: %.2f zł\n", calculateMonthlyGrossPrice());
        System.out.printf("ŁĄCZNA CENA NETTO: %.2f zł\n", calculateTotalNetPrice());
        System.out.println("==================================");
    }

    @Override
    public String toString() {
        return String.format("planCode: %s | clientName: %s | months: %.2f | baseMonthlyFee: %.2f | autoRenew: %s ", planCode, clientName, months, baseMonthlyFee, autoRenew);
    }

    public interface Billable {
        double calculateMonthlyNetPrice();
        double calculateMonthlyGrossPrice();
    }

}
