
package samples.jmx.proxy;

/**
 * @author robh
 */
public interface RuntimeInfo {

	String getBootClassPath();
	String getClassPath();
	String getVmName();
	String getVmVendor();
}
