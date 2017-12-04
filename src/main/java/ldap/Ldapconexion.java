package ldap;


import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.ldap.LdapContext;

public class Ldapconexion {
	
	private static final String LDAP_HOST = "ldap://ceiba.local:389";
	private static final String CONTEXTO_INICIAL = "com.sun.jndi.ldap.LdapCtxFactory";
	private static final String DOMINIO = "CEIBA";
	LdapContext ctx = null;

	public Ldapconexion() {
	}
	
	@SuppressWarnings("unused")
	public String autenticacion( String user, String pass){

		
		Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,CONTEXTO_INICIAL);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL,DOMINIO+"\\"+user);
        env.put(Context.SECURITY_CREDENTIALS,pass);
        env.put(Context.PROVIDER_URL, LDAP_HOST);
        
        try {
            DirContext ctx = new InitialDirContext(env);
            } 
    catch (NamingException e) {
            e.printStackTrace();
            return null;
    }
    return user;   
}
	

}
