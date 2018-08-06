/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PayHost;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * Class for samples
 *
 * @author App Inlet (Pty) Ltd
 * @version 1.0
 * @since 1.0
 */
public class Test {

    /**
     * Main function to run tests
     *
     * @param args the command line arguments
     * @throws ParserConfigurationException ParserConfigurationException
     * @throws SAXException SAXException
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

        PayHost ph = new PayHost("https://secure.paygate.co.za/payhost/process.trans", "ns1");

        // Test SinglePayoutRequest
        /*SinglePayoutRequest spr = new SinglePayoutRequest(ph);
        System.out.println("Prorperites : ");
        (new Mockups()).singlePayoutRequest().printProperties();
        String str = spr.cardPayoutRequest((new Mockups()).singlePayoutRequest());
        MyObject status = sv.getUtil().getStatus(res);
        if (spr.error(res)) {
            // Request is denied
            System.out.println("Error : " + status.getProperty("ResultDescription"));
        } else {
            // Request is applied
            System.out.println("No Error");
        }
         */
        //Test Vault
        /*SingleVault sv = new SingleVault(ph);
        System.out.println("Prorperites : ");
        (new Mockups()).common().printProperties();
        String res = sv.cardVault((new Mockups()).common());
        MyObject status = sv.getUtil().getStatus(res);
        if (sv.error(res)) {
            // Request is denied
            System.out.println("Error : " + status.getProperty("ResultDescription"));
        } else {
            // Request is applied
            System.out.println("No Error");
        }*/
        // Test SingleFollowUp
        /*System.out.println("Response SingleFollowUP:");
        SingleFollowUp sfu = new SingleFollowUp(ph);
        String res = sfu.settlment((new Mockups()).common());
        MyObject status = sfu.getUtil().getStatus(res);
        if (sfu.error(res)) {
            // Request is denied
            System.out.println("Error : " + status.getProperty("ResultDescription"));
        } else {
            // Request is applied
            System.out.println("No Error");
        }*/
    }
}
