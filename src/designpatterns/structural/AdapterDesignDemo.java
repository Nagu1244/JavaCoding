package designpatterns.structural;

import java.math.BigDecimal;

interface PaymentProcessor{
    void processPayment(BigDecimal amount);
}

interface ThirdPartyPaymentGateway{
    void pay();
}

class LegacyPaymentGateway implements ThirdPartyPaymentGateway{

    @Override
    public void pay() {
        System.out.println("Payment processed successfully with third party");
    }
}

class PaymentGatewayAdapter implements PaymentProcessor{
    private ThirdPartyPaymentGateway thirdPartyPaymentGateway;

    public PaymentGatewayAdapter(ThirdPartyPaymentGateway thirdPartyPaymentGateway) {
        this.thirdPartyPaymentGateway = thirdPartyPaymentGateway;
    }

    @Override
    public void processPayment(BigDecimal amount) {
        thirdPartyPaymentGateway.pay();
    }
}
public class AdapterDesignDemo {
    public static void main(String args[]) {
        ThirdPartyPaymentGateway thirdPartyPaymentGateway  = new LegacyPaymentGateway();
        PaymentProcessor paymentProcessor = new PaymentGatewayAdapter(thirdPartyPaymentGateway);
        paymentProcessor.processPayment(BigDecimal.valueOf(12000.00));
    }
}
