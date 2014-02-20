/**
 * Created by srajbhandari on 2/20/14.
 */

public class protobuffTest {
    public static void main(String args[]){
        Protobuff.VendorList.Builder vendorList=Protobuff.VendorList.newBuilder();
        for(int i=0;i<5;i++){
            Protobuff.Vendor.Builder vendor=Protobuff.Vendor.newBuilder();
            vendor.setPaidAmount(i);
            vendor.setPaidDate("2048-3-2");
            vendor.setVendorName("sandeep");
            vendor.setVendorType("new");
            vendorList.addList(vendor);
        }
        toPrint data=new toPrint(vendorList.build());

    }
}
