package designpatterns;

interface LegacyCustomer {
    String getName();
    String location();
}
class LegacyCustomerImpl implements LegacyCustomer {
    private String name;
    private String location;

    public LegacyCustomerImpl(String name, String location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String location() {
        return this.location;
    }
}

interface NewCustomer {
    String getFullName();
    String getAddress();
}

class AdapterCustomer implements NewCustomer{
 private LegacyCustomer legacyCustomer;


    public AdapterCustomer(LegacyCustomer legacyCustomer) {
        this.legacyCustomer = legacyCustomer;
    }

    @Override
    public String getFullName() {
        return legacyCustomer.getName();
    }

    @Override
    public String getAddress() {
        return legacyCustomer.location();
    }
}

public class AdapterDesignDemo {
    public static void main(String args[]) {
        LegacyCustomer legacyCustomer = new LegacyCustomerImpl("Nagaraj Shabad", "Sangareddy");
        NewCustomer newCustomer = new AdapterCustomer(legacyCustomer);
        System.out.println(newCustomer.getFullName());
        System.out.println(newCustomer.getAddress());
    }
}
