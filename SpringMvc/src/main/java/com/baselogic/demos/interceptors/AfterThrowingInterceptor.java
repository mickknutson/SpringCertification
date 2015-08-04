package com.baselogic.demos.interceptors;

/**
 * HibernateConfiguration
 *
 * at_see <a href="http://springcert.sourceforge.net/core-3/index.html">Objectives</a><br>
 *
 * @author Mick Knutson
 * at_see Blog: <a href="http://www.baselogic.com">http://baselogic.com</a><br>
 * at_see LinkedIN: <a href="http://linkedin.com/in/mickknutson">http://linkedin.com/in/mickknutson</a><br>
 * at_see Twitter: <a href="http://twitter.com/mickknutson">http://twitter.com/mickknutson</a><br>
 * at_see Github: <a href="http://github.com/mickknutson">http://github.com/mickknutson</a><br>
 *
 * at_see <a href="http://www.packtpub.com/java-ee6-securing-tuning-extending-enterprise-applications-cookbook/book">JavaEE 6 Cookbook Packt</a><br>
 * at_see <a href="http://www.amazon.com/Cookbook-securing-extending-enterprise-applications/dp/1849683166">JavaEE 6 Cookbook Amazon</a><br>
 *
 * @since 2012
 *
 */
public class AfterThrowingInterceptor {

	/*@ExceptionHandler
	public String handleNotFoundException (NotFoundException ex, HttpServletResponse resp)
	{
		WebApiResponse webResp = ex.getWebResp ();
		if (webResp != null) {
			try {
				resp.getWriter ().print (objMapper.writeValueAsString (webResp));
				resp.setStatus (webResp.getHttpStatusCode ());
				resp.setHeader ("Content-Type", "application/json");
			} catch (Exception e) {
				e.printStackTrace ();
			}
		}
		return null;
	}*/
}
