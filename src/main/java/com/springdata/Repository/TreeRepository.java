/**
 * <p>Title: TreeRepository.java</p>
 * <p>Description: </p>
 * <p>Copyright: lizhe (c) 2014</p>
 * <p>Company: xiaoma.com</p>
 * @author vincent
 * @date 2014年7月10日
 * @version 1.0
 */
package com.springdata.Repository;

import java.util.List;

import com.springdata.model.Tree;

/**
 * <p>Title: TreeRepository</p>
 * <p>Description: </p>
 * <p>Company: xiaoma.com</p> 
 * @author lizhe
 * @date 2014年7月10日
 */
public interface TreeRepository {

	/**
	 * <p>Title: findAll</p>
	 * <p>Description: </p>
	 * @return
	 */
	List<Tree> findAll();

}
