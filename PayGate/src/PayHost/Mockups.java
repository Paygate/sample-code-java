/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PayHost;

/**
 * Common Mockups ready for tests Class
 *
 * @author App Inlet (Pty) Ltd
 * @version 1.0
 * @since 1.0
 */
public class Mockups {

    /**
     * Generic Properties MyObject Maker for all requests
     *
     * @return MyObject
     */
    public MyObject common() {
        MyObject object = new MyObject();
        object.setProperty("payGateID", "10011064270");
        object.setProperty("payRequestID", "6B739421-C177-903F-B23A-4BC1F09AB791");
        object.setProperty("TransactionID", "5");
        object.setProperty("transactionType", "Settlement");
        object.setProperty("transactionDate", "Settlement");
        object.setProperty("MerchantOrderID", "order-1234");//INV101
        object.setProperty("password", "test");
        object.setProperty("firstname", "Joe");
        object.setProperty("lastname", "Soap");
        object.setProperty("phone", "0861234567");
        object.setProperty("mobile", "0735552233");
        object.setProperty("notifyUrl", "https://www.mytestsite.com/notify");
        object.setProperty("returnUrl", "https://www.mytestsite.com/return");
        object.setProperty("budgetPeriod", "0");
        object.setProperty("cvv", "999");
        object.setProperty("email", "joes@example.com");
        object.setProperty("cardNumber", "5200000000000015");
        object.setProperty("cardExpDate", "112030");
        object.setProperty("merchantOrderID", "order-1234");
        object.setProperty("currency", "ZAR");
        object.setProperty("amount", "100");
        object.setProperty("vaultID", "c36a13e8-65a0-49fd-a12f-05fe78bf9eaa");
        return object;
    }

    /**
     * SingleFollowUP Query Properties
     *
     * @return MyObject
     */
    public MyObject singleFollowUpQuery() {
        MyObject object = new MyObject();
        object.setProperty("payGateID", "10011064270");
        object.setProperty("payRequestID", "6B739421-C177-903F-B23A-4BC1F09AB791");
        object.setProperty("password", "test");
        return object;
    }

    /**
     * singleFollowUpVoid Properties
     *
     * @return MyObject
     */
    public MyObject singleFollowUpVoid() {
        MyObject object = new MyObject();
        object.setProperty("payGateID", "10011064270");
        object.setProperty("password", "test");
        object.setProperty("transactionID", "28790224");
        object.setProperty("transactionType", "Settlement");
        return object;
    }

    /**
     * singleFollowUpSettlement Properties
     *
     * @return MyObject
     */
    public MyObject singleFollowUpSettlement() {
        MyObject object = new MyObject();
        object.setProperty("payGateID", "10011064270");
        object.setProperty("password", "test");
        object.setProperty("transactionID", "28790224");
        return object;
    }

    /**
     * singleFollowUpRefund Properties
     *
     * @return MyObject
     */
    public MyObject singleFollowUpRefund() {
        MyObject object = new MyObject();
        object.setProperty("payGateID", "10011064270");
        object.setProperty("password", "test");
        object.setProperty("transactionID", "28790224");
        object.setProperty("amount", "100");
        return object;
    }

    /**
     * singleVaultCard Properties
     *
     * @return MyObject
     */
    public MyObject singleVaultCard() {
        MyObject object = new MyObject();
        object.setProperty("payGateID", "10011064270");
        object.setProperty("password", "test");
        object.setProperty("cardNumber", "5200000000000015");
        object.setProperty("cardExpiryDate", "112030");
        return object;
    }

    /**
     * singleVaultLookup Properties
     *
     * @return MyObject
     */
    public MyObject singleVaultLookup() {
        MyObject object = new MyObject();
        object.setProperty("payGateID", "10011064270");
        object.setProperty("password", "test");
        object.setProperty("vaultID", "c36a13e8-65a0-49fd-a12f-05fe78bf9eaa");
        return object;
    }

    /**
     * singleVaultDelete Properties
     *
     * @return MyObject
     */
    public MyObject singleVaultDelete() {
        MyObject object = new MyObject();
        object.setProperty("payGateID", "10011064270");
        object.setProperty("password", "test");
        object.setProperty("vaultID", "c36a13e8-65a0-49fd-a12f-05fe78bf9eaa");
        return object;
    }

    /**
     * singlePayout Properties
     *
     * @return MyObject
     */
    public MyObject singlePayout() {
        MyObject object = new MyObject();
        object.setProperty("payGateID", "10011064270");
        object.setProperty("password", "test");
        object.setProperty("firstname", "Joe");
        object.setProperty("lastname", "Soap");
        object.setProperty("email", "joes@example.com");
        object.setProperty("cardNumber", "4000000000000002");
        object.setProperty("cardExpiryDate", "052015");
        object.setProperty("merchantOrderID", "order-1234");
        object.setProperty("currency", "ZAR");
        object.setProperty("amount", "100");
        return object;
    }

    /**
     * singlePaymentToken Properties
     *
     * @return MyObject
     */
    public MyObject singlePaymentToken() {
        MyObject object = new MyObject();
        object.setProperty("payGateID", "10011064270");
        object.setProperty("password", "test");
        object.setProperty("token", "2258098676320541501");
        object.setProperty("tokenDetail", "VCO");
        object.setProperty("merchantOrderID", "order-1234");
        object.setProperty("currency", "ZAR");
        object.setProperty("amount", "100");
        return object;
    }

    /**
     * singlePaymentWeb Properties
     *
     * @return MyObject
     */
    public MyObject singlePaymentWeb() {
        MyObject object = new MyObject();
        object.setProperty("payGateID", "10011064270");
        object.setProperty("password", "test");
        object.setProperty("title", "Mr");
        object.setProperty("firstname", "Joe");
        object.setProperty("lastname", "Soap");
        object.setProperty("email", "joes@example.com");
        object.setProperty("notifyUrl", "https://www.mytestsite.com/notify");
        object.setProperty("returnUrl", "https://www.mytestsite.com/return");
        object.setProperty("merchantOrderID", "order-1234");
        object.setProperty("currency", "ZAR");
        object.setProperty("amount", "100");
        object.setProperty("transactionDate", "2014-04-06T18:30:00+02:00");
        object.setProperty("billingTitle", "Mr");
        object.setProperty("billingFirstname", "PayGate");
        object.setProperty("billingLastname", "Test");
        object.setProperty("billingEmail", "itsupport@paygate.co.za");
        object.setProperty("addressLine", "Apartment 2A");
        object.setProperty("city", "Cape Town");
        object.setProperty("state", "Western Cape");
        object.setProperty("country", "ZAF");
        object.setProperty("zip", "7700");
        return object;
    }

    /**
     * singlePaymentCardSimple Properties
     *
     * @return MyObject
     */
    public MyObject singlePaymentCardSimple() {
        MyObject object = new MyObject();
        object.setProperty("payGateID", "10011064270");
        object.setProperty("password", "test");
        object.setProperty("title", "Mr");
        object.setProperty("firstname", "Joe");
        object.setProperty("lastname", "Soap");
        object.setProperty("email", "joes@example.com");
        object.setProperty("telephone", "0861234567");
        object.setProperty("mobile", "0735552233");
        object.setProperty("notifyUrl", "https://www.mytestsite.com/notify");
        object.setProperty("returnUrl", "https://www.mytestsite.com/return");
        object.setProperty("merchantOrderID", "order-1234");
        object.setProperty("currency", "ZAR");
        object.setProperty("amount", "100");
        object.setProperty("transactionDate", "2014-04-06T18:30:00+02:00");
        object.setProperty("billingTitle", "Mr");
        object.setProperty("billingFirstname", "PayGate");
        object.setProperty("billingLastname", "Test");
        object.setProperty("billingEmail", "itsupport@paygate.co.za");
        object.setProperty("addressLine", "Apartment 2A");
        object.setProperty("city", "Cape Town");
        object.setProperty("state", "Western Cape");
        object.setProperty("country", "ZAF");
        object.setProperty("zip", "7700");
        object.setProperty("cardNumber", "4000000000000002");
        object.setProperty("cardExpiryDate", "122019");
        object.setProperty("cvv", "999");
        object.setProperty("budgetPeriod", "0");
        return object;
    }

    /**
     * paywebInitiate Properties
     *
     * @return MyObject
     */
    public MyObject paywebInitiate() {
        MyObject object = new MyObject();
        object.setProperty("PAYGATE_ID", "10011072130");
        object.setProperty("REFERENCE", "pgtest_123456789");
        object.setProperty("AMOUNT", "3299");
        object.setProperty("CURRENCY", "ZAR");
        object.setProperty("RETURN_URL", "https://my.return.url/page");
        object.setProperty("TRANSACTION_DATE", "2018-01-01 12:00:00");
        object.setProperty("LOCALE", "en-za");
        object.setProperty("COUNTRY", "ZAF");
        object.setProperty("EMAIL", "customer@paygate.co.za");
        object.setProperty("CHECKSUM", "59229d9c6cb336ae4bd287c87e6f0220");
        return object;
    }

    /**
     * paywebQuery Properties
     *
     * @return MyObject
     */
    public MyObject paywebQuery() {
        MyObject object = new MyObject();
        object.setProperty("PAYGATE_ID", "10011072130");
        object.setProperty("REFERENCE", "pgtest_123456789");
        object.setProperty("PAY_REQUEST_ID", "23B785AE-C96C-32AF-4879-D2C9363DB6E8");
        object.setProperty("CHECKSUM", "b41a77f83a275a849f23e30b4666e837");
        return object;
    }

    /**
     * MD5
     *
     * @param md5 String to hash
     * @return String
     */
    public String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
}
