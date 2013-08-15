/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cHannonA4client;

/**
 *
 * @author gjung
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewJerseyClient newJerseyClient = new NewJerseyClient();
        String response1 = newJerseyClient.find_XML(String.class, "1");
        String response2 = newJerseyClient.find_JSON(String.class, "1");

        System.out.println("response is: " + response1);
        System.out.println("response is: " + response2);

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?> "
                + "<department> "
                + "  <dname>Payment Department</dname> "
                + "  <dnumber>88</dnumber> "
                + "  <mgrssn>999999998</mgrssn> "
                + "  <mgrstartdate>2000-06-15T00:00:00-04:00</mgrstartdate> "
                + "</department> ";
        newJerseyClient.create_XML(xml);

        
        newJerseyClient.close();
        // TODO code application logic here
    }
}