/**
 * <p>Title: TestRepository.java</p>
 * <p>Description: </p>
 * <p>Copyright: lizhe (c) 2014</p>
 * <p>Company: xiaoma.com</p>
 * @author vincent
 * @date 2014年6月30日
 * @version 1.0
 */
package com.springdata.Repository;

import java.util.Collection;

import com.springdata.model.User;

/**
 * <p>Title: TestRepository</p>
 * <p>Description: </p>
 * <p>Company: xiaoma.com</p> 
 * @author lizhe
 * @date 2014年6月30日
 */
public interface TestRepository {

	/**
	 * <p>Title: getAllUser</p>
	 * <p>Description: </p>
	 * @return
	 */
	Collection<User> getAllUser();

}
