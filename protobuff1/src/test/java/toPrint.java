/**
 * Created by srajbhandari on 2/20/14.
 */
public class toPrint {
    Protobuff.VendorList vendorList;
    public toPrint(Protobuff.VendorList vendorList){
        this.vendorList=vendorList;
        for (Protobuff.Vendor output : this.vendorList.getListList()){
            System.out.println("paidAmount"+output.getPaidAmount());
            System.out.println("paidDate"+output.getPaidDate());
            System.out.println("VendorName"+output.getVendorName());
            System.out.println("VendorType"+output.getVendorType());

        }
    }


}
