package dominioTest;

import org.junit.Test;

import junit.framework.Assert;
import ldap.Ldapconexion;


@SuppressWarnings("deprecation")
public class ldaptest {

	
	@Test
	public void seconectotest() {
	Ldapconexion ldap =new Ldapconexion();
	 Assert.assertNotNull(ldap.autenticacion("adminsp.dllo", "!lqvelqi08-*"));
	
	}

}
