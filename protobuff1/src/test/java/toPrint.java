/**
 * Created by srajbhandari on 2/20/14.
 */
public class toPrint {
    Protobuff.VendorList vendorList;
    public toPrint(Protobuff.VendorList vendorList){
        this.vendorList=vendorList;
        for (Protobuff.Vendor output : this.vendorList.getListList()){
            System.out.println(output.getPaidAmount());
            System.out.println(output.getPaidDate());
            System.out.println(output.getVendorName());
            System.out.println(output.getVendorType());

        }
    }


}
