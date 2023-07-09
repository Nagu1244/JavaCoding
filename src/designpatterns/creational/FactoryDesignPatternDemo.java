package designpatterns.creational;


interface Logistic {
    void deliver();
}
 class RoadLogistic implements Logistic {
    private String trasportType;

    public RoadLogistic(String roadTrasport) {
        this.trasportType = roadTrasport;
    }
     @Override
     public void deliver() {
        System.out.println("Goods shipped by "+trasportType);
     }
 }
 class SeaLogistic implements Logistic{
     private String trasportType;
     public SeaLogistic(String seaTransport) {
      this.trasportType = seaTransport;
     }
     @Override
     public void deliver() {
         System.out.println("Goods shipped by "+trasportType);
     }
 }

 class CreateObjectFactory {
    public static Logistic getInstanc(String shipType) throws Exception {
        switch (shipType) {
            case "RoadTransport":
                return new RoadLogistic(shipType);
            case "ShipTransport" :
                return new SeaLogistic(shipType);
            default:
                throw new Exception(""+shipType+" type is not available");
        }
    }
 }


public class FactoryDesignPatternDemo {
    public static void main(String args[]) throws Exception {
        // In Factory design pattern we are not exposing how the object is created.
        Logistic objectFactory = CreateObjectFactory.getInstanc("RoadTransport");
        objectFactory.deliver();

        Logistic logistic = CreateObjectFactory.getInstanc("ShipTransport");
        logistic.deliver();

        Logistic logistic1 = CreateObjectFactory.getInstanc("FlightTransport");
        logistic1.deliver();
    }
}
