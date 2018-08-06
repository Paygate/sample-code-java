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
 * Vault requests allow merchants to manage what is stored by the PayVault
 * tokenisation service.
 *
 * Please note that currently PayVault only supports the tokenisation of credit
 * card data.
 *
 * @author App Inlet (Pty) Ltd
 * @see
 * <a href="https://qa.paygate.co.za/api/?java#vault-request">SingleVaultRequest</a>
 * @version 1.0
 * @since 1.0
 */
public class SingleVault extends Parent {

    /**
     * Init for SingleVault
     *
     * @param payHost PayHost Primary Object
     */
    public SingleVault(PayHost payHost) {
        super(payHost);
        this.util = new Utilities();
        this.payHost = payHost;
    }

    /**
     * Card Vault Request
     *
     * @param object contains params for the function
     * @return Post http Response as XML String ready to Parse
     * @throws ParserConfigurationException ParserConfigurationException
     * @throws SAXException SAXException
     * @throws IOException IOException
     * @see
     * <a href="https://qa.paygate.co.za/api/?java#cardvaultrequest">CardVaultRequest</a>
     */
    public String cardVault(MyObject object) throws IOException, ParserConfigurationException, SAXException {
        String body = "<ns1:SingleVaultRequest>"
                + "    <ns1:CardVaultRequest>"
                + "        <ns1:Account>"
                + "            <ns1:PayGateId>" + object.getProperty("payGateId") + "</ns1:PayGateId>"
                + "            <ns1:Password>" + object.getProperty("password") + "</ns1:Password>"
                + "        </ns1:Account>"
                + "        <ns1:CardNumber>" + object.getProperty("cardNumber") + "</ns1:CardNumber>"
                + "        <ns1:CardExpiryDate>" + object.getProperty("cardExpiryDate") + "</ns1:CardExpiryDate>"
                /*+ "        <ns1:UserDefinedFields>"
                + "			<ns1:key>" + object.getProperty("key") + "</ns1:key>"
                + "			<ns1:value>" + object.getProperty("value") + "</ns1:value>"
                + "		</ns1:UserDefinedFields>"*/
                + "    </ns1:CardVaultRequest>"
                + "</ns1:SingleVaultRequest>";
        return util.callWebService(payHost.getUrl(), "SingleVaultRequest", body);
    }

    /**
     * Delete Vault Request
     *
     * @param object contains params for the function
     * @return Post http Response as XML String ready to Parse
     * @throws ParserConfigurationException ParserConfigurationException
     * @throws SAXException SAXException
     * @throws IOException IOException
     * @see
     * <a href="https://qa.paygate.co.za/api/?java#deletevaultrequest">DeleteVaultResponse</a>
     */
    public String deleteVault(MyObject object) throws IOException, ParserConfigurationException, SAXException {
        String body = "<ns1:SingleVaultRequest>"
                + "    <ns1:DeleteVaultRequest>"
                + "        <ns1:Account>"
                + "            <ns1:PayGateId>" + object.getProperty("payGateId") + "</ns1:PayGateId>"
                + "            <ns1:Password>" + object.getProperty("password") + "</ns1:Password>"
                + "        </ns1:Account>"
                + "        <ns1:VaultId>" + object.getProperty("vaultID") + "</ns1:VaultId>"
                /*+ "        <ns1:UserDefinedFields>"
                + "			<ns1:key>" + object.getProperty("key") + "</ns1:key>"
                + "			<ns1:value>" + object.getProperty("value") + "</ns1:value>"
                + "		</ns1:UserDefinedFields>"*/
                + "    </ns1:DeleteVaultRequest>"
                + "</ns1:SingleVaultRequest>";
        return util.callWebService(payHost.getUrl(), "SingleVaultRequest", body);
    }

    /**
     * Loockup Vault Request
     *
     * @param object contains params for the function
     * @return Post http Response as XML String ready to Parse
     * @throws ParserConfigurationException ParserConfigurationException
     * @throws SAXException SAXException
     * @throws IOException IOException
     * @see
     * <a href="https://qa.paygate.co.za/api/?java#loockupvaultrequest">LoockupVaultResponse</a>
     */
    public String lookupVault(MyObject object) throws IOException, ParserConfigurationException, SAXException {
        String body = "<ns1:SingleVaultRequest>"
                + "    <ns1:LookUpVaultRequest>"
                + "        <ns1:Account>"
                + "            <ns1:PayGateId>" + object.getProperty("payGateId") + "</ns1:PayGateId>"
                + "            <ns1:Password>" + object.getProperty("password") + "</ns1:Password>"
                + "        </ns1:Account>"
                + "        <ns1:VaultId>" + object.getProperty("vaultID") + "</ns1:VaultId>"
                /*+ "        <ns1:UserDefinedFields>"
                + "			<ns1:key>" + object.getProperty("key") + "</ns1:key>"
                + "			<ns1:value>" + object.getProperty("value") + "</ns1:value>"
                + "		</ns1:UserDefinedFields>"*/
                + "    </ns1:LookUpVaultRequest>"
                + "</ns1:SingleVaultRequest>";
        return util.callWebService(payHost.getUrl(), "SingleVaultRequest", body);
    }
}
